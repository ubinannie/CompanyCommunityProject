package company.blind.web;

import java.sql.Connection;
import java.sql.SQLException;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

// mysql 접근 이상 없음 
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class DataSourceTest {
	
	// root-context에 있는 DriverManagerDataSource 객체 테스트
	@Inject
	private DataSource datasource;
	
	@Test
	public void testConnection() {
		try {
			Connection conn = datasource.getConnection();
			
			System.out.println("conn : " + conn);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}







