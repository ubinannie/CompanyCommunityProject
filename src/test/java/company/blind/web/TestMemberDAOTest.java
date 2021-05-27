package company.blind.web;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import company.blind.dao.Go_MemberDAO;
import company.blind.dto.Go_MemberDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestMemberDAOTest {
	
	private static final Logger logger = LoggerFactory.getLogger(TestMemberDAOTest.class);
	
	@Inject
	private Go_MemberDAO goMemberDAO;
	
	@Test
	public void testInsertMember() throws Exception {
		
		Go_MemberDTO mdto = new Go_MemberDTO();
		mdto.setMem_id("yu");
//		mdto.setMem_pwd("2345");
//		mdto.setMem_email("3.1@korea.com");
//		mdto.setMem_age_range("10");
//		mdto.setMem_birth("0301");		
//		mdto.setMem_gender("2");
//		mdto.setMem_phone("01022223333");
//		mdto.setMem_name("관순");
//		mdto.setCom_name("삼일절");		
		
					
		logger.info(mdto.toString());
		
		goMemberDAO.insertMem(mdto);
		
	}
	
}
















