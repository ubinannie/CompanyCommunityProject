package company.blind.web;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

// file:src/main/webapp/WEB-INF/spring/**/*.xml
// 원래는 위에가 권장사항이나 ""안에는 잘 인식하지 못할 수 있으므로 정확한 주소를 적어줘도 무관함
// 어노테이션 할 때 어디서 제공하는지 명확하게 파악하고 사용해야함
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration		// 스프링 MVC를 테스트하는데 필요한  annotation 
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ControllerTest {
	
	private static final Logger logger = LoggerFactory.getLogger(ControllerTest.class);

	@Inject
	private WebApplicationContext webAppCtx;
	
	private MockMvc mockmavc;	// Tomcat 역할을 대신해줄 객체 
	
	@Before
	public void setUp() {
		this.mockmavc = MockMvcBuilders.webAppContextSetup(this.webAppCtx).build();
		logger.info("setUp() 호출....");			// sysout 대신에 사용할 수 있음
	}
	
	@Test
	public void testController() {
		try {
			mockmavc.perform(MockMvcRequestBuilders.get("/controller"));  // POST, GET 방식 사용 가능 
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}





