package company.blind.web;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MybatisTest {

	@Inject
	private SqlSessionFactory sqlFactory;
	
	@Test
	public void testSqlFactory() {
		System.out.println(sqlFactory);
	}
	
}
