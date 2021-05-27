package company.blind.web;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.bind.annotation.RequestMapping;

import company.blind.dao.Go_BoardDAO;
import company.blind.dto.FindData;
import company.blind.dto.Go_BoardDTO;

// 여기는 Go_BoardDAO Test 하는 곳
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
public class TestGo_BoardDAO {
	
	@Inject
	private Go_BoardDAO gdao;
	
	private static Logger logger = LoggerFactory.getLogger(TestGo_BoardDAO.class);
	
	// 게시물 작성하는 곳 -> 이상 없음 
	
	//@Test
	public void insertTest() throws Exception{
		String[] animal1 = {"사자","호랑이","강아지","고양이","원숭이","양","돼지","닭","용","고릴라"};
		String[] animal2 = {"사자","호랑이","강아지","고양이","원숭이","양","돼지","닭","용","고릴라"};
		Go_BoardDTO gdto = new Go_BoardDTO();
		
		for(int i=0; i<100;i++) {
			Integer random = (int)(Math.random()*10);
			String ranDom = Integer.toString(random);
			gdto.setBrd_viewed((int)(Math.random()*300));
			gdto.setLike_cnt((int)(Math.random()*200));
			gdto.setBrd_title(animal1[random]+i);
			gdto.setBrd_cont(animal2[random]+i);
			gdto.setCom_name("goott");
			gdto.setMem_id("12345678");
			gdao.insert(gdto);
		}

	}
	
	
	// 게시글 번호로 조회하는 곳  -> 이상 없음
	/*
	@Test
	public void selectNumTest() throws Exception{
		logger.info(gdao.select(2).toString());
	}
	*/
	
	// 수정하기	-> 이상 없음
	/*
	@Test
	public void updateTest() throws Exception{
		Go_BoardDTO gdto = new Go_BoardDTO();
		gdto.setBrd_num(2);
		gdto.setBrd_title("수정한 제목");
		gdto.setBrd_cont("수정한 내용");
		gdao.update(gdto);
	}
	*/

	// 삭제하기 	-> 이상 없음
	/*
	@Test
	public void deleteTest() throws Exception{
		gdao.delete(2);
		
	}
	*/
	
	// 번호로 전체 조회하기	-> 이상 없음 (추후에 brd_regdate : Wed Mar 31 16:10:06 KST 2021 -> 뷰 단에서 처리하기)
	/*
	@Test
	public void listNumTest() throws Exception {
		logger.info(gdao.numlist().toString());
	}
	*/
	
	// 페이징 test
	
	// pageCri를 통한 페이징 설정 test
	

	
	@Test
	   public void findTest() throws Exception {
	      FindData fCri = new FindData();
	      fCri.setPage(1);
	      fCri.setFindType("NAME");
	      fCri.setWord("양");
	      logger.info("-----------------------테스트 글 목록 탐색 -----------------------");
	      gdao.listFind(fCri);
	      
	      List<Go_BoardDTO> list = gdao.listFind(fCri);
	      for(Go_BoardDTO gdao : list) {
	         logger.info(gdao.getBrd_title() + " : " + gdao.getBrd_cont());
	      }
	      logger.info("-----------------------하이 data 갯수 출력-----------------------");
	      logger.info("findCountDate : " + gdao.findCount(fCri));
	   }
	
	
	
	
	
	
	
	
	
	
}












