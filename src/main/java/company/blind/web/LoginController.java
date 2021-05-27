package company.blind.web;

import java.io.IOException;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;

import javax.inject.Inject;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import company.blind.dao.Go_BoardDTOImple;
import company.blind.dao.LiketoInter;
import company.blind.dto.CommentDTO;
import company.blind.dto.FindData;
import company.blind.dto.Go_BoardDTO;
import company.blind.dto.Go_Board_CompanyDTO;
import company.blind.dto.Go_MemberDTO;
import company.blind.dto.LiketoDTO;
import company.blind.dto.ListData;
import company.blind.dto.PageBasic;
import company.blind.dto.Paging;
import company.blind.service.CommentServiceImpl;
import company.blind.service.Go_BoardService;
import company.blind.service.Go_Board_CompanyService;
import company.blind.service.Go_MemberService;

@Controller
@SessionAttributes({"mem_id", "mem_name", "mem_email", "com_name"})
@WebServlet("/like.ajax")
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(LoginController.class);
	
	
	@Inject //맴버
	private Go_MemberService gms;
	@Inject //검색, 보드
	private Go_BoardService gsvc;
	@Inject //검색, 보드
	private CommentServiceImpl csi;
	@Inject // 회사, 보드
	private Go_Board_CompanyService gsccv;
	
	// 좋아요 추가 
	@Autowired
	@Qualifier("company.blind.dao.LiketoDAO")
	private LiketoInter liketodao = null;
	
	@Autowired
	private Go_BoardDTOImple gdto = null;

	
	
	
	
	
	//////////////////////////////맴버컨트롤러//////////////////////////////////
	@RequestMapping(value="/member/login", method=RequestMethod.GET)
	public String loginGET() {
		return "/member/login";
	}
	
	@RequestMapping(value="/member/logout", method=RequestMethod.GET)
	public String logoutGET(Model model) {
		model.addAttribute("mem_id", "");
		model.addAttribute("mem_email", "");
		model.addAttribute("mem_name", "");
		model.addAttribute("com_name", "");
		
		
		return "redirect:/member/login";
	}
	@RequestMapping(value="/member/loginNaver", method=RequestMethod.GET)
	public String loginNaver(HttpSession session) {
		return "/member/loginNaver";
	}
	
	@RequestMapping(value="/member/loginMem", method=RequestMethod.POST)
	public String loginMem(Model model, HttpServletRequest request) throws Exception {
		
		String mem_id = request.getParameter("mem_id");
		String mem_email = request.getParameter("mem_email");
		String mem_name = request.getParameter("mem_name");
		
		
//		model.addAttribute("mem_id", mem_id);
//		model.addAttribute("mem_email", mem_email);
//		model.addAttribute("mem_name", mem_name);
		
		System.out.println("-----mem_id는 "+mem_id+"입니다.-----");
		System.out.println("-----mem_email은 "+mem_email+"입니다.-----");
		System.out.println("-----mem_name은 "+mem_name+"입니다.-----");

		int isExist = gms.receiveMem(mem_id);
		System.out.println(isExist);
		
		//isExist = 1;			//환영 페이지 넘겨서 데이터 받는거 확인하려고 한겁니다. 실구현시 주석처리 하세요
		
		if(isExist == 0) {		//db에 존재하지 않으면 (카운트=0)
			System.out.println("회원 존재 안함, 가입으로");
			model.addAttribute("mem_id", mem_id);
			model.addAttribute("mem_email", mem_email);
			model.addAttribute("mem_name", mem_name);
			
			return "/member/joinForm";	
		}else {
			System.out.println("회원 존재");
			model.addAttribute("mem_id", mem_id);
			model.addAttribute("mem_email", mem_email);
			model.addAttribute("mem_name", mem_name);
			String com_name = gms.getComName(mem_id);
			model.addAttribute("com_name", com_name);
			
			return "/main/mainPage";
		}
	}
	
	@RequestMapping(value="/member/joinForm", method=RequestMethod.POST)
	public String insertPostMem(Model model, HttpServletRequest request) throws Exception {
		System.out.println("가입처리완료중");
		
		String mem_id = request.getParameter("mem_id");
		String mem_email = request.getParameter("mem_email");
		String mem_name = request.getParameter("mem_name");
		String com_name = request.getParameter("com_name");
		 
		System.out.println(mem_email+mem_id+mem_name+com_name);
		
		Go_MemberDTO gdto = new Go_MemberDTO();
		gdto.setCom_name(com_name);
		gdto.setMem_email(mem_email);
		gdto.setMem_id(mem_id);
		gdto.setMem_name(mem_name);
		
		gms.injectMem(gdto);
		
		System.out.println("-----가입 완료-----");
		
		return "/member/login";
	}
	
	@RequestMapping(value = "/member/modifyForm", method = RequestMethod.GET)
	public String modifyForm(HttpSession session,  Model model) {
		
		return "member/modifyForm";
	}
	
	@RequestMapping(value = "/member/modifyForm", method = RequestMethod.POST)
	public String modifyPostForm(HttpSession session, HttpServletRequest request,  Model model) throws Exception {
		
		String mem_id = (String) model.getAttribute("mem_id");
		String mem_name = (String) model.getAttribute("mem_name");
		String mem_email = request.getParameter("mem_email");
		String com_name = request.getParameter("com_name");
		
		System.out.println(mem_email+com_name);
		
		Go_MemberDTO mdto = new Go_MemberDTO();
		mdto.setCom_name(com_name);
		mdto.setMem_email(mem_email);
		mdto.setMem_id(mem_id);
		mdto.setMem_name(mem_name);
		
		gms.adjustMem(mdto);
		
		model.addAttribute("mem_email", mem_email);
		model.addAttribute("com_name", com_name);
		
		return "redirect:/member/modifyForm";
	}
	
	@RequestMapping(value = "/member/mypage", method = RequestMethod.GET)
	public String mypage(HttpSession session,  Model model) throws Exception{
		
		return "member/mypage";
	}
	//알람 나중에
	@RequestMapping(value = "/member/alarmList", method = RequestMethod.GET)
	public String alarmList(HttpSession session, Model model) throws Exception{
		
		return "member/alarmList";
	}
	
	@RequestMapping(value = "/member/agreeList", method = RequestMethod.GET)
	public String agreeList(HttpSession session,  Model model) throws Exception{
		
		return "member/agreeList";
	}
	
	//메인
	@RequestMapping(value = "/main/mainPage", method = RequestMethod.GET)
	public String home(Model model, ListData page) throws Exception{
		List<Go_BoardDTO> alists = new ArrayList<Go_BoardDTO>();
		alists = pageList(page, model);	//익명

		List<Go_BoardDTO> flists = new ArrayList<Go_BoardDTO>();
		flists = pageList(page, model);	//이거 자유게시판도 되나?

		List<Go_BoardDTO> llists = new ArrayList<Go_BoardDTO>();
		llists = LikepageList(page, model);	//인기(pop)

		List<Go_BoardDTO> hlists = new ArrayList<Go_BoardDTO>();
		hlists = ViewpageList(page, model);	//핫

		model.addAttribute("anonyList", alists);
		model.addAttribute("hotList", hlists);
		model.addAttribute("popList", llists);
		model.addAttribute("freeList", flists);
		
		return "/main/mainPage";
	}
	
	//////////////////////////////검색 컨트롤러///////////////////////////////////
	public void commentlist(int brd_num, Model model) throws Exception{
		// 댓글을 리스트로 보냄. 알아서 선후관계 정렬됨
		model.addAttribute("commentList", csi.list(brd_num));
	}
	
	// 데이터 부르기
	// 검색했을 때 넘어오는 값
	@RequestMapping(value = "/fboard/search", method = RequestMethod.GET)
	public String listFind(@ModelAttribute("fd")FindData fd, Model model) {
		LOGGER.info("=======listFind=======");
		try {
			model.addAttribute("searchList", gsvc.listFind(fd));
			// 검색 정보
			Paging paging = new Paging();
			paging.setCt(fd);
			
			// 페이징 처리할 때 페이징 정보
			paging.setTotal(gsvc.findCount(fd));
			model.addAttribute("paging", paging);
			model.addAttribute("findData", fd);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "/board/search_board";
	}	
	
	@RequestMapping(value = "/fboard/search_board_view", method = RequestMethod.GET)
	public String anonyBoardView(@RequestParam("brd_num") int brd_num, @ModelAttribute("pbsc") PageBasic pbsc, Model model) throws Exception {
		// 잘 나오는지 확인하는 곳
		LOGGER.info("======pageview========");
		model.addAttribute("list", gsvc.select(brd_num));
		commentlist(brd_num, model);
		return "/board/search_board_view";
	}	
	
	@RequestMapping(value = "/fboard/list11")
	public void listShowPage(@RequestParam("brd_num") int brd_num, @ModelAttribute("fd") FindData fd, Model model)
		throws Exception {
		model.addAttribute(gsvc.select(brd_num));
	}	
	
	/////////////////////////////보드 컨트롤러///////////////////////////////////
	// 댓글
	public void commentList(int brd_num, Model model) throws Exception{
		// 댓글을 리스트로 보냄. 알아서 선후관계 정렬됨
		model.addAttribute("commentList", csi.list(brd_num));
	}	
	
	// 페이징 (핸들러X)
	public List<Go_BoardDTO> pageList(PageBasic pbsc, Model model) throws Exception { // 잘 나오는지 확인하는 곳
		LOGGER.info("======페이지 + 버튼 처리========");
		
		// 데이터가 20개씩 나오게 하게 끔 정보를 보냄 // 메인 페이지에서 몇개씩 나올건지는 알아서 뷰에서 가져다 쓰기

		Paging paging = new Paging();

		// 데이터 양을 paging로 보내기 paging.setCt(pbsc);
		paging.setCt(pbsc);
		paging.setTotal(gsvc.count(pbsc));
		
		System.out.println(paging.getStart());
		System.out.println(paging.getEnd());
		System.out.println(paging.getShowPageNum());
		
		model.addAttribute("paging", paging);
		
		return gsvc.listPage(pbsc);
	}	
	
	
	
	// 익명
	// 익명 게시판 맵핑(데이터 보여주기!)
	@RequestMapping(value = "/board/anony_board", method = RequestMethod.GET) 
	public String anonyBoard(Model model, ListData page) throws Exception {
		List<Go_BoardDTO> lists = new ArrayList<Go_BoardDTO>();
		try {
			lists = pageList(page, model);
		} catch (Exception e) {
			e.printStackTrace();
		}

		//lists.forEach(System.out::println);
		model.addAttribute("anonyList", lists);
		
		LOGGER.info("리스트 출력 중......단 게시글 번호로 리스트 출력 중 "); 
		return "/board/anony_board"; 
	}	
	
	// 익명 게시판 상세보기 맵핑
	@RequestMapping(value = "/board/anony_board_view", method = RequestMethod.GET)
	public void anonyBoardView2(@RequestParam("brd_num") int brd_num, @ModelAttribute("pbsc") PageBasic pbsc, Model model) throws Exception {
		// 잘 나오는지 확인하는 곳
		LOGGER.info("======pageview========");
		gsvc.updateViewCnt(brd_num); 
		
		//commentList(brd_num, model);
		
		model.addAttribute("list", gsvc.select(brd_num));
		
		List<CommentDTO> clist = csi.list(brd_num);
		
		CommentDTO flash = new CommentDTO();	//잠시 저장, 플레시
		
		int depth_cnt = 0;	//깊이
		
		for(int i=0;i<clist.size();i++) {		// 비교 기준 댓글
			depth_cnt = 0;
			for(int j=i+1;j<clist.size();j++) {	// 비교중 댓글
				if(clist.get(i).getCmt_num() == clist.get(j).getCom_group()) {
					//플레시에 저장해두고
					flash.setBrd_num(clist.get(j).getBrd_num());
					flash.setCmt_num(clist.get(j).getCmt_num());
					flash.setCom_cont(clist.get(j).getCom_cont());
					flash.setCom_group(clist.get(j).getCom_group());
					flash.setCom_lev(clist.get(j).getCom_lev());
					flash.setCom_regdate(clist.get(j).getCom_regdate());
					flash.setMem_id(clist.get(j).getMem_id());
					
					//한칸씩 미루기
					for(int k=j-1; k>i+depth_cnt; k--) {
						clist.get(k+1).setBrd_num(clist.get(k).getBrd_num());
						clist.get(k+1).setCmt_num(clist.get(k).getCmt_num());
						clist.get(k+1).setCom_cont(clist.get(k).getCom_cont());
						clist.get(k+1).setCom_group(clist.get(k).getCom_group());
						clist.get(k+1).setCom_lev(clist.get(k).getCom_lev());
						clist.get(k+1).setCom_regdate(clist.get(k).getCom_regdate());
						clist.get(k+1).setMem_id(clist.get(k).getMem_id());
					}
					
					depth_cnt ++;	//깊이를 늘림
					
					//LOGGER.info("---------------자리에 넣기---------------");
					clist.get(i+depth_cnt).setBrd_num(flash.getBrd_num());
					clist.get(i+depth_cnt).setCmt_num(flash.getCmt_num());
					clist.get(i+depth_cnt).setCom_cont(flash.getCom_cont());
					clist.get(i+depth_cnt).setCom_group(flash.getCom_group());
					clist.get(i+depth_cnt).setCom_lev(flash.getCom_lev());
					clist.get(i+depth_cnt).setCom_regdate(flash.getCom_regdate());
					clist.get(i+depth_cnt).setMem_id(flash.getMem_id());
				}//비교 if end
			}//내부 for end
		}//최종  for end		
		
		model.addAttribute("commentList", clist);
		
		//return "/board/anony_board_view?brd_num="+brd_num;
	}	
	
	//익명 상세 댓글 입력은 POST로 받고 insert후 리다이렉트
	@RequestMapping(value = "/board/anony", method = RequestMethod.GET)
	public String anonyBoardViewPostComment( @RequestParam("brd_num") int brd_num, @ModelAttribute("pbsc") PageBasic pbsc,
						@RequestParam("com_cont") String com_cont , @RequestParam("com_group") int com_group, Model model) throws Exception {
		
		LOGGER.info("댓글쓰기 진입"+brd_num+com_cont+com_group);
		
		String mem_id = (String) model.getAttribute("mem_id");
		
		CommentDTO cdto = new CommentDTO();
		
		cdto.setBrd_num(brd_num);
		cdto.setCom_cont(com_cont);
		cdto.setCom_group(com_group);
		cdto.setMem_id(mem_id);
		
		System.out.println(brd_num);
		
		csi.write(cdto);
		
		return "redirect:/board/anony_board_view?brd_num="+brd_num;
	}
	
	//hot
	// 핫 게시판 맵핑(데이터 보여주기!)
	@RequestMapping(value = "/board/hot_board", method = RequestMethod.GET) 
	public String hotBoard(Model model, ListData page) throws Exception {
		
		List<Go_BoardDTO> lists = new ArrayList<Go_BoardDTO>();
		
		lists = ViewpageList(page, model);

		//lists.forEach(System.out::println);
		model.addAttribute("hotList", lists);
		
		LOGGER.info("리스트 출력 중......단 게시글 번호로 리스트 출력 중 ");
		return "/board/hot_board"; 
	
	}	
	
	// 핫 게시판 상세보기 맵핑
	@RequestMapping(value = "/board/hot_board_view", method = RequestMethod.GET)
	public void hotBoardView(@RequestParam("brd_num") int brd_num, @ModelAttribute("pbsc") PageBasic pbsc, Model model) throws Exception {
		// 잘 나오는지 확인하는 곳
		LOGGER.info("======pageview========");
List<CommentDTO> clist = csi.list(brd_num);
gsvc.updateViewCnt(brd_num);
		CommentDTO flash = new CommentDTO();	//잠시 저장, 플레시
		
		int depth_cnt = 0;	//깊이
		
		for(int i=0;i<clist.size();i++) {		// 비교 기준 댓글
			depth_cnt = 0;
			for(int j=i+1;j<clist.size();j++) {	// 비교중 댓글
				if(clist.get(i).getCmt_num() == clist.get(j).getCom_group()) {
					//플레시에 저장해두고
					flash.setBrd_num(clist.get(j).getBrd_num());
					flash.setCmt_num(clist.get(j).getCmt_num());
					flash.setCom_cont(clist.get(j).getCom_cont());
					flash.setCom_group(clist.get(j).getCom_group());
					flash.setCom_lev(clist.get(j).getCom_lev());
					flash.setCom_regdate(clist.get(j).getCom_regdate());
					flash.setMem_id(clist.get(j).getMem_id());
					
					//한칸씩 미루기
					for(int k=j-1; k>i+depth_cnt; k--) {
						clist.get(k+1).setBrd_num(clist.get(k).getBrd_num());
						clist.get(k+1).setCmt_num(clist.get(k).getCmt_num());
						clist.get(k+1).setCom_cont(clist.get(k).getCom_cont());
						clist.get(k+1).setCom_group(clist.get(k).getCom_group());
						clist.get(k+1).setCom_lev(clist.get(k).getCom_lev());
						clist.get(k+1).setCom_regdate(clist.get(k).getCom_regdate());
						clist.get(k+1).setMem_id(clist.get(k).getMem_id());
					}
					
					depth_cnt ++;	//깊이를 늘림
					
					//LOGGER.info("---------------자리에 넣기---------------");
					clist.get(i+depth_cnt).setBrd_num(flash.getBrd_num());
					clist.get(i+depth_cnt).setCmt_num(flash.getCmt_num());
					clist.get(i+depth_cnt).setCom_cont(flash.getCom_cont());
					clist.get(i+depth_cnt).setCom_group(flash.getCom_group());
					clist.get(i+depth_cnt).setCom_lev(flash.getCom_lev());
					clist.get(i+depth_cnt).setCom_regdate(flash.getCom_regdate());
					clist.get(i+depth_cnt).setMem_id(flash.getMem_id());
				}//비교 if end
			}//내부 for end
		}//최종  for end		
		
		model.addAttribute("commentList", clist);
		model.addAttribute("list", gsvc.select(brd_num));
	}	
	
	//핫 상세 댓글 입력은 POST로 받고 insert후 리다이렉트
	@RequestMapping(value = "/board/hotcom", method = RequestMethod.GET)
	public String hotcomBoardViewPostComment( @RequestParam("brd_num") int brd_num, @ModelAttribute("pbsc") PageBasic pbsc,
						@RequestParam("com_cont") String com_cont , @RequestParam("com_group") int com_group, Model model) throws Exception {
		
		LOGGER.info("댓글쓰기 진입"+brd_num+com_cont+com_group);
		
		String mem_id = (String) model.getAttribute("mem_id");
		
		CommentDTO cdto = new CommentDTO();
		
		cdto.setBrd_num(brd_num);
		cdto.setCom_cont(com_cont);
		cdto.setCom_group(com_group);
		cdto.setMem_id(mem_id);
		
		System.out.println(brd_num);
		
		csi.write(cdto);
		
		return "redirect:/board/hot_board_view?brd_num="+brd_num;
	}
	
	
	//자유게시판
	// 자유 게시판 맵핑(데이터 보여주기!)
	@RequestMapping(value = "/board/free_board", method = RequestMethod.GET) 
	public String hotBoard2(Model model, ListData page) throws Exception {
		
		List<Go_BoardDTO> lists = new ArrayList<Go_BoardDTO>();

		lists = pageList(page, model);		//자유게시판 페이징 있나요

		//lists.forEach(System.out::println);
		model.addAttribute("hotList", lists);
		
		LOGGER.info("리스트 출력 중......단 게시글 번호로 리스트 출력 중 ");
		return "/board/free_board"; 
	
	}	
	
	//수정 (modify)
		// 수정 페이지 + 페이지 정보 넘기는 곳
			@RequestMapping(value = "/board/modifyPage", method = RequestMethod.GET)
			public void modifyPage(@RequestParam("brd_num")int brd_num, @ModelAttribute("pbsc")PageBasic pbsc,
					Model model) throws Exception{
				// 잘 나오는지 확인하는 곳
				LOGGER.info("======modifyPage========");
				
				Go_BoardDTO gdto = gsvc.select(brd_num);
				
				//System.out.println(gdto.getCom_name()+ "-------------------------------");
				
				model.addAttribute("gdto", gdto);
				LOGGER.info("=====왜왜왜========");
			}
			
			
			
			
			@RequestMapping(value = "/board/modifyPage2", method = RequestMethod.POST)
			public String modifyPOST(Go_BoardDTO gdto, PageBasic pbsc, RedirectAttributes reAttr, String title, String content) throws Exception{
				// 잘 나오는지 확인하는 곳
				LOGGER.info("======modifyPOST========");
			   
				System.out.println("====제목====" + title);
				System.out.println("====내용====" + content);

				gdto.setBrd_title(title);
				gdto.setBrd_cont(content);

				System.out.println("====제목22222====" + gdto.getBrd_title());
				System.out.println("====내용22222====" + gdto.getBrd_cont());
				// 수정하기 db로 넣기
				gsvc.update(gdto);
				
				// 페이지 정보 가져오기
				reAttr.addAttribute("page", pbsc.getPage());
				reAttr.addAttribute("numPage", pbsc.getNumPage());
				reAttr.addFlashAttribute("result", "수정 테스트 ");
				
				return "redirect:/board/anony_board";
				
			}
	
	//회사소식 (news)	
	//회사소식 매핑 게시판
//	@RequestMapping(value = "/board/news_board", method = RequestMethod.GET)
//	public String newsBoardGet(Model model, ListData page) {
//		List<Go_BoardDTO> lists = new ArrayList<Go_BoardDTO>();
//		try {
//			lists = pageList(page, model);
//		} catch (Exception e) {
//			e.printStackTrace();
//		}
//
//		//lists.forEach(System.out::println);
//		model.addAttribute("newsList", lists);
//
//		return "board/news_board";
//	}	
	
	//인기글 (pop)
	// 인기글 게시판 맵핑(데이터 보여주기!)
	@RequestMapping(value = "/board/pop_board", method = RequestMethod.GET)
	public String popBoard(Model model, ListData page) throws Exception {
		List<Go_BoardDTO> lists = new ArrayList<Go_BoardDTO>();
		lists = LikepageList(page, model);

		//lists.forEach(System.out::println);
		model.addAttribute("popList", lists);

		return "board/pop_board";
	}	
	
	// 인기글 게시판 상세페이지 맵핑(데이터 보여주기!)  
	@RequestMapping(value = "/board/pop_board_view", method = RequestMethod.GET) 
	public String popBoardView(@RequestParam("brd_num") int brd_num, @ModelAttribute("pbsc") PageBasic pbsc, Model model) throws Exception {
		// 잘 나오는지 확인하는 곳
		LOGGER.info("======pageview========");
List<CommentDTO> clist = csi.list(brd_num);
		
		CommentDTO flash = new CommentDTO();	//잠시 저장, 플레시
		
		int depth_cnt = 0;	//깊이
		
		for(int i=0;i<clist.size();i++) {		// 비교 기준 댓글
			depth_cnt = 0;
			for(int j=i+1;j<clist.size();j++) {	// 비교중 댓글
				if(clist.get(i).getCmt_num() == clist.get(j).getCom_group()) {
					//플레시에 저장해두고
					flash.setBrd_num(clist.get(j).getBrd_num());
					flash.setCmt_num(clist.get(j).getCmt_num());
					flash.setCom_cont(clist.get(j).getCom_cont());
					flash.setCom_group(clist.get(j).getCom_group());
					flash.setCom_lev(clist.get(j).getCom_lev());
					flash.setCom_regdate(clist.get(j).getCom_regdate());
					flash.setMem_id(clist.get(j).getMem_id());
					
					//한칸씩 미루기
					for(int k=j-1; k>i+depth_cnt; k--) {
						clist.get(k+1).setBrd_num(clist.get(k).getBrd_num());
						clist.get(k+1).setCmt_num(clist.get(k).getCmt_num());
						clist.get(k+1).setCom_cont(clist.get(k).getCom_cont());
						clist.get(k+1).setCom_group(clist.get(k).getCom_group());
						clist.get(k+1).setCom_lev(clist.get(k).getCom_lev());
						clist.get(k+1).setCom_regdate(clist.get(k).getCom_regdate());
						clist.get(k+1).setMem_id(clist.get(k).getMem_id());
					}
					
					depth_cnt ++;	//깊이를 늘림
					
					//LOGGER.info("---------------자리에 넣기---------------");
					clist.get(i+depth_cnt).setBrd_num(flash.getBrd_num());
					clist.get(i+depth_cnt).setCmt_num(flash.getCmt_num());
					clist.get(i+depth_cnt).setCom_cont(flash.getCom_cont());
					clist.get(i+depth_cnt).setCom_group(flash.getCom_group());
					clist.get(i+depth_cnt).setCom_lev(flash.getCom_lev());
					clist.get(i+depth_cnt).setCom_regdate(flash.getCom_regdate());
					clist.get(i+depth_cnt).setMem_id(flash.getMem_id());
				}//비교 if end
			}//내부 for end
		}//최종  for end		
		
		model.addAttribute("commentList", clist);
		model.addAttribute("list", gsvc.select(brd_num));
		return "/board/pop_board_view"; 
	}	
	
	//인기 상세 댓글 입력은 POST로 받고 insert후 리다이렉트
	@RequestMapping(value = "/board/popcom", method = RequestMethod.GET)
	public String popcomBoardViewPostComment( @RequestParam("brd_num") int brd_num, @ModelAttribute("pbsc") PageBasic pbsc,
						@RequestParam("com_cont") String com_cont , @RequestParam("com_group") int com_group, Model model) throws Exception {
		
		LOGGER.info("댓글쓰기 진입"+brd_num+com_cont+com_group);
		
		String mem_id = (String) model.getAttribute("mem_id");
		
		CommentDTO cdto = new CommentDTO();
		
		cdto.setBrd_num(brd_num);
		cdto.setCom_cont(com_cont);
		cdto.setCom_group(com_group);
		cdto.setMem_id(mem_id);
		
		System.out.println(brd_num);
		
		csi.write(cdto);
		
		return "redirect:/board/pop_board_view?brd_num="+brd_num;
	}
	
	
	// 글쓰기 (write)
	// 게시글 작성
	@RequestMapping(value = "/board/writePage", method = RequestMethod.GET)
	public String writeGET(Go_BoardDTO gdto, Model model) throws Exception {
		LOGGER.info("써진다 ... get 방식으로 ,,,, 그렇다");
		return "/board/writePage";
	}	
	
	// 게시글 작성
	@RequestMapping(value = "/board/writePage", method = RequestMethod.POST) 
	public String writeReal(@RequestParam("boardSel") int boardSel, Model model, Go_BoardDTO gdto, RedirectAttributes reAttr, String title, String content) throws Exception {
		
		
		
		LOGGER.info("포스트 쓴다.,,,, "+boardSel+"!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
		LOGGER.info(gdto.toString()); // 확인용
			
		LOGGER.info(":::::::::::::::::"); // 확인용
		
		//com_name, mem_id 세션에서 받
		String mem_id = (String) model.getAttribute("mem_id");
		String com_name = (String) model.getAttribute("com_name");
		
		// DB에 저장하기
		if(boardSel == 1) {		//회사 소식 저장
			Go_Board_CompanyDTO gbdto = new Go_Board_CompanyDTO();
			gbdto.setBrd_cm_title(title);
			gbdto.setBrd_cm_cont(content);
			
			gbdto.setCom_name(com_name);
			gbdto.setMem_id(mem_id);
			
			
			gsccv.insertCompany(gbdto);
		
			return "redirect:/board/news_board";
		}else {			//anony 저장
			gdto.setBrd_title(title);
			gdto.setBrd_cont(content);
			
			gdto.setCom_name(com_name);
			gdto.setMem_id(mem_id);
			gdto.setBrd_viewed(0);
			gdto.setLike_cnt(0);

			gsvc.insert(gdto);
			
			return "redirect:/board/anony_board";
		}
		
		
	}	
	

	
	// -------------
	// 글 번호랑 페이징 처리 정보를 보내줘야함
//	@RequestMapping(value = "/board/news_board_view", method = RequestMethod.GET)
//	public void pageview(@RequestParam("brd_num") int brd_num, @ModelAttribute("pbsc") PageBasic pbsc, Model model) throws Exception {
//		// 잘 나오는지 확인하는 곳
//		LOGGER.info("======pageview========");
//		commentList(brd_num, model);
//		model.addAttribute("list", gsvc.select(brd_num));
//	}	
	
	// 삭제 처리하는 곳 + 페이지 정보
	@RequestMapping(value = "/board/del", method = RequestMethod.GET)
	public String delPage(@RequestParam("brd_num") int brd_num, PageBasic pbsc, RedirectAttributes reAttr)
			throws Exception {
		// 잘 나오는지 확인하는 곳
		LOGGER.info("======delPage========");
		// 삭제하는 로직
		gsvc.delete(brd_num);

		// 페이지 정보 받아오기 (뷰에서 히든으로 보내줘야함) 
		reAttr.addAttribute("page", pbsc.getPage());
		reAttr.addAttribute("numPag", pbsc.getNumPage());
		reAttr.addFlashAttribute("result", "테스트 하는 곳 ");

		return "redirect:/board/anony_board";
	}	
	
	//리스트 테스트
	@RequestMapping(value = "/board/test", method = RequestMethod.GET)
	public void anything(Model model) throws Exception {
		LOGGER.info("리스트 출력 중......단 게시글 번호로 리스트 출력 중 ");
		// model.addAttribute("list", gsvc.numlist());
	}
	
	// 추가
	// 여기는 유빈이가 추가 한 곳
	// 조회수 정렬 페이징 처리 
	public List<Go_BoardDTO> ViewpageList(PageBasic pbsc, Model model) throws Exception { // 잘 나오는지 확인하는 곳
		LOGGER.info("======ViewpageList + 버튼 처리========");
		
		// 데이터가 20개씩 나오게 하게 끔 정보를 보냄 // 메인 페이지에서 몇개씩 나올건지는 알아서 뷰에서 가져다 쓰기

		Paging paging = new Paging();

		// 데이터 양을 paging로 보내기 paging.setCt(pbsc);
		paging.setCt(pbsc);
		paging.setTotal(gsvc.Viewcount(pbsc));
		
		System.out.println(paging.getStart());
		System.out.println(paging.getEnd());
		System.out.println(paging.getShowPageNum());
		
		model.addAttribute("paging", paging);
		
		return gsvc.ViewlistPage(pbsc);
	}
	
	// 좋아요 정렬 페이징 처리 
	public List<Go_BoardDTO> LikepageList(PageBasic pbsc, Model model) throws Exception { // 잘 나오는지 확인하는 곳
		LOGGER.info("======LikepageList + 버튼 처리========");
			
		// 데이터가 20개씩 나오게 하게 끔 정보를 보냄 // 메인 페이지에서 몇개씩 나올건지는 알아서 뷰에서 가져다 쓰기

		Paging paging = new Paging();

		// 데이터 양을 paging로 보내기 paging.setCt(pbsc);
		paging.setCt(pbsc);
		paging.setTotal(gsvc.LikeCount(pbsc));
			
		System.out.println(paging.getStart());
		System.out.println(paging.getEnd());
		System.out.println(paging.getShowPageNum());
			
		model.addAttribute("paging", paging);
			
		return gsvc.likelistPage(pbsc);
	}
	
	// 여기서 부터 좋아요 처리
	// 주소 수정 
	@ResponseBody
	@RequestMapping(method = RequestMethod.GET)
	public String like(int brd_num, HttpSession session) throws Exception {
		
		String mem_id = (String)session.getAttribute("mem_id");		// 회원 아이디 가져오기
		JSONObject obj = new JSONObject();
		
		ArrayList<String> msg = new ArrayList<String>();
		HashMap<String, Object> hashMap = new HashMap<String, Object>();
		
		hashMap.put("brd_num", brd_num);
		hashMap.put("mem_id", mem_id);
		
		LiketoDTO likeDTO = liketodao.read(hashMap);
		
		Go_BoardDTO gobDTO = gdto.select(brd_num);
		
		int like_cnt = gobDTO.getLike_cnt();					// 게시판의 좋아요 카운트
		int like_check = 0;
		like_check = likeDTO.getLike_check();					// 좋아요 체크 값
		
		if(liketodao.countbyLike(hashMap)==0) {
			liketodao.create(hashMap);
		}
		
		if(like_check == 0) {
			msg.add("좋아요 ~");
			liketodao.like_check(hashMap);
			like_check++;
			like_cnt++;
			gdto.updatelikeCntUp(brd_num);			// 좋아요 갯수 증가
		}else {
			msg.add("좋아요 취소~");
			liketodao.like_check(hashMap);
			like_check--;
			like_cnt--;
			gdto.updatelikeCntDown(brd_num);		// 좋아요 갯수 감소
		}
		
		obj.put("brd_num", likeDTO.getBrd_num());
		obj.put("like_check", like_check);
		obj.put("like_cnt", like_cnt);
		obj.put("msg", msg);
		
		return obj.toJSONString();
	}
		
	
	
	// 회사소식 부분
	private static final Logger LOGGER2= LoggerFactory.getLogger(Go_Board_CompanyController.class);
		
		

		@RequestMapping(value = "/board/news_board", method = RequestMethod.GET)
		public void list22(Model model) throws Exception{
			
			LOGGER2.info("리스트 출력 중...... ");
			System.out.println("제발");
			model.addAttribute("news", gsccv.numlistCompany());
		}
		
	
		
		
		@RequestMapping(value = "/board/news_board_view", method = RequestMethod.GET)
		public void readPage21(@RequestParam("brd_cm_num") int brd_cm_num, Model model) throws Exception{
			
			model.addAttribute("go_boardDTO", gsccv.selectCompany(brd_cm_num));
			LOGGER2.info("ㅎ2????????????? ");
		}
		
		
		
		
		

		// 수정 페이지 + 페이지 정보 넘기는 곳
			@RequestMapping(value = "/modifyPage3", method = RequestMethod.GET)
			public void modifyPage21(@RequestParam("brd_cm_num")int brd_cm_num, @ModelAttribute("pbsc")PageBasic pbsc,
					Model model) throws Exception{
				// 잘 나오는지 확인하는 곳
				LOGGER2.info("======modifyPage========");
				model.addAttribute("go_boardDTO", gsccv.selectCompany(brd_cm_num));			
				
			}
		
		
		
		// 수정하기 DB 넣기
		@RequestMapping(value = "/modifyPage3", method = RequestMethod.POST)
		public String modifyPOST21(Go_Board_CompanyDTO gdto, PageBasic pbsc, RedirectAttributes reAttr, String title, String content, int brd_cm_num) throws Exception{
			// 잘 나오는지 확인하는 곳
			LOGGER2.info("======modifyPOST========");
		   
			System.out.println("====제목====" + title);
			System.out.println("====내용====" + content);
			System.out.println("====내용====" + brd_cm_num);
			//System.out.println("====내용====" + num);
			

			gdto.setBrd_cm_title(title);
			gdto.setBrd_cm_cont(content);
			gdto.setBrd_cm_num(brd_cm_num);
			//.setBrd_cm_num(num);
			
			
			System.out.println("====제목22222====" + gdto.getBrd_cm_title());
			System.out.println("====내용22222====" + gdto.getBrd_cm_cont());
			//.out.println("====내용22222====" + gdto.getBrd_cm_num());

			// 수정하기 db로 넣기
			gsccv.updatecompany(gdto);
			
			System.out.println(gdto);
			// 페이지 정보 가져오기
			reAttr.addAttribute("page", pbsc.getPage());
			reAttr.addAttribute("numPage", pbsc.getNumPage());
			reAttr.addFlashAttribute("result", "수정 테스트 ");
			
			return "redirect:/board/news_board";
			
		}
		
		
		// 좋아요 up
		   @RequestMapping(value = "/board/up", method = RequestMethod.GET) 
		   public String anonyBoard121(@RequestParam("brd_num") int brd_num) throws Exception {
		      LOGGER.info("시이이잉발ㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹㄹ");
		      gsvc.updatelikeCntUp(brd_num);
		      
		      return "redirect:/board/anony_board_view?brd_num="+brd_num;
		            /*?brd_num="+brd_num; 
		*/   }
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
