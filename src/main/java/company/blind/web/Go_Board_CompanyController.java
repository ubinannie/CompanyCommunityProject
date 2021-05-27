package company.blind.web;


import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import company.blind.dto.Go_BoardDTO;
import company.blind.dto.Go_Board_CompanyDTO;
import company.blind.dto.PageBasic;
import company.blind.dto.Paging;
import company.blind.service.Go_Board_CompanyService;



// 회사 소식 
@Controller
@RequestMapping("/boardCompany/*")
public class Go_Board_CompanyController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(Go_Board_CompanyController.class);
	
	@Inject
	private Go_Board_CompanyService gsccv;
	
	// 회사소식 -> 게시글 작성
	// 작성시에 mapper 참고 : 회원 level 2만 작성 할 수 있게 조건식을 걸어 놨음
	@RequestMapping(value = "/write222", method = RequestMethod.GET)
	public void writeGET(Go_Board_CompanyDTO gcdto, Model model) throws Exception {
		LOGGER.info("=============writeGET : 잘 써짐 컨트롤러 이상 없음=============");
	}
	
	// 회사소석 -> 게시글 작성
	@RequestMapping(value = "/write22233", method = RequestMethod.POST)
	public String writeRe(Go_Board_CompanyDTO gcdto, RedirectAttributes reAttr) throws Exception {
		LOGGER.info("=============writeRe : 잘 써짐 이상 없음=============");
		LOGGER.info(gcdto.toString()); 
		
		// DB에 저장하기
		gsccv.insertCompany(gcdto);
		
		reAttr.addFlashAttribute("result", "잘넘어갔음");
		LOGGER.info("=============writeRe : 컨트롤러 이상 없음=============");
		
		return "redirect:/boardCompany/list";
	}
	
	
	@RequestMapping(value = "/news_board", method = RequestMethod.GET)
	public void list(Model model) throws Exception{
		LOGGER.info("리스트 출력 중...... ");
		model.addAttribute("list", gsccv.numlistCompany());
	}
	

	
	@RequestMapping(value = "/readPage", method = RequestMethod.GET)
	public void readPage(@RequestParam("brd_cm_num") int brd_cm_num, Model model) throws Exception{
		
		model.addAttribute("go_boardDTO", gsccv.selectCompany(brd_cm_num));
		LOGGER.info("ㅎ2????????????? ");
	}
	
	
	// 삭제 버튼 + 페이지정보
	@RequestMapping(value = "/del", method = RequestMethod.GET)
	public String delPage(@RequestParam("brd_cm_num")int brd_cm_num, PageBasic pbsc, RedirectAttributes reAttr)
		throws Exception{
		// 잘 나오는지 확인하는 곳
		LOGGER.info("======delPage========");
		// 삭제하는 로직 
		gsccv.deleteCompany(brd_cm_num);
		
		// 페이지 정보 받아오기 (뷰에서 히든으로 보내줘야함)
		reAttr.addAttribute("page", pbsc.getPage());
		reAttr.addAttribute("numPage", pbsc.getNumPage());
		reAttr.addFlashAttribute("result", "테스트 하는 곳 ");
		
		return "redirect:/boardCompany/news_board";
		
	}
	
	

	// 수정 페이지 + 페이지 정보 넘기는 곳
		@RequestMapping(value = "/modifyPage", method = RequestMethod.GET)
		public void modifyPage(@RequestParam("brd_cm_num")int brd_cm_num, @ModelAttribute("pbsc")PageBasic pbsc,
				Model model) throws Exception{
			// 잘 나오는지 확인하는 곳
			LOGGER.info("======modifyPage========");
			model.addAttribute("go_boardDTO", gsccv.selectCompany(brd_cm_num));			
			
		}
	
	
	
	// 수정하기 DB 넣기
	@RequestMapping(value = "/modifyPage", method = RequestMethod.POST)
	public String modifyPOST(Go_Board_CompanyDTO gdto, PageBasic pbsc, RedirectAttributes reAttr, String title, String content, int brd_cm_num) throws Exception{
		// 잘 나오는지 확인하는 곳
		LOGGER.info("======modifyPOST========");
	   
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
		
		return "redirect:/boardCompany/news_board";
		
	}
	
	
	
	// 페이지 + 버튼 처리
	public void pageList(PageBasic pb, Model model) throws Exception {
		
		// 데이터가 20개씩 나오게 하게 끔 정보를 보내는곳 
		model.addAttribute("listPage", gsccv.listPageBasicCompany(pb));
		
		Paging paging = new Paging();
		
		// 데이터 양을 paging으로 보내기
		paging.setCt(pb);
		
		paging.setTotal(gsccv.countDataCompany(pb));
		
		model.addAttribute("pagingCompany", paging);
	}
		
	
	@RequestMapping(value = "/mainPage", method = RequestMethod.GET)
	public void list0(Model model) throws Exception{
		LOGGER.info("리스트 출력 중......단 게시글 번호로 리스트 출력 중 ");
		//model.addAttribute("list", gsvc.numlist());
	}
	

}
