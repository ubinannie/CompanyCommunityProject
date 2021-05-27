package company.blind.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import company.blind.dao.Go_MemberDAO;
import company.blind.dto.CommentDTO;
import company.blind.dto.Go_MemberDTO;
import company.blind.service.CommentServiceImpl;
import company.blind.service.Go_MemberService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class Go_MemberServiceTest {
	
	@Inject
	private Go_MemberService gms;
	//private Go_MemberDAO mdao;
	
	@Inject
	private CommentServiceImpl csi;
	
	private static Logger LOGGER = LoggerFactory.getLogger(Go_MemberServiceTest.class);
	
	
	//@Test
	public void testTest() throws Exception {
		
		CommentDTO cdto = new CommentDTO();
		
		cdto.setBrd_num(101);
		cdto.setCom_cont("test1234");
		cdto.setCom_group(1);
		cdto.setMem_id("14796223");
		
		csi.write(cdto);
	}
	
	
	
	
	
	
	
	 //멤버 정보 저장 
	 // 이상 없음
	/*
	@Test
	public void injectMemTest() throws Exception{
		Go_MemberDTO mdto = new Go_MemberDTO();
		mdto.setMem_id("yu123141");
		mdto.setMem_pwd("123242342345");
		mdto.setMem_email("gghfd512@naver.com");
		mdto.setMem_level(1);
		mdto.setMem_name("유고");
		mdto.setCom_name("구트아카데미");
		
		mdto.setMem_age_range(null);
		mdto.setMem_birth(null);
		mdto.setMem_gender(null);
		mdto.setMem_phone(null);
		
		gms.injectMem(mdto);
		//mdao.insertMem(mdto);
	}
	*/
	
	
	// 수정 정보 : mem_id (아이디) / mem_pwd (비밀번호) / mem_email (이메일) / mem_name (회원이름) / mem_phone (회원 전화번호) / com_name (회사 이름)
	// 이상 없음
	
	//@Test
	public void adjustMemTest() throws Exception{
		Go_MemberDTO mdto = new Go_MemberDTO();
//		mdto.setMem_num(1);
//		
//		mdto.setMem_id("hong");
//		mdto.setMem_pwd("2345");
//		mdto.setMem_email("gwan1234@sun.com");
//		mdto.setMem_level(1);
//		mdto.setMem_name("냥냥이");
//		mdto.setCom_name("구트아카데미11");
//		
//		mdto.setMem_age_range(null);
//		mdto.setMem_birth(null);
//		mdto.setMem_gender(null);
//		mdto.setMem_phone(null);
		
		gms.adjustMem(mdto);
	}
	
	
	
	//회원 고유번호로 삭제
	/* 이상 없음
	@Test
	
	public void removeMemTest() throws Exception{
		gms.removeMem(1);
	}
	*/
	
	// 회원 정보 조회
	/*
	@Test
	public void receiveMemTest() throws Exception{
		Go_MemberDTO mdto = gms.receiveMem(1);
		
		LOGGER.info(mdto.getMem_id()+" "+mdto.getMem_pwd()+" "+mdto.getMem_email());
	}
	*/
	
	
	// 회원 정보 조회
	// 이상 없음
	/*
	@Test
	public void listTest() throws Exception{
		List<Go_MemberDTO> mlist = gms.allMem();
		
		for(Go_MemberDTO mdto : mlist) {
			LOGGER.info(mdto.getMem_id()+" "+mdto.getMem_pwd()+" "+mdto.getMem_email());
		}
	}
	*/
	
	// 회사 정보별로 회원 조회 할 수 있는거 =
	/*
	@Test
	public void listByComTest() throws Exception{
		List<Go_MemberDTO> mlist = gms.allMemByCom("구트아카데미");
		//List<Go_MemberDTO> mlist = gms.allMemByCom("없는것");
		
		for(Go_MemberDTO mdto : mlist) {
			LOGGER.info(mdto.getMem_id()+" "+mdto.getMem_pwd()+" "+mdto.getMem_email());
		}
	}
	*/
	
	
	
	
	
	
	
	
}
