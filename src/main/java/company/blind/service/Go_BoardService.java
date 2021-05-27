package company.blind.service;

import java.util.List;

import company.blind.dto.FindData;
import company.blind.dto.Go_BoardDTO;
import company.blind.dto.PageBasic;

public interface Go_BoardService {
	
	public void insert(Go_BoardDTO gdto) throws Exception;
	
	public Go_BoardDTO select(Integer brd_num) throws Exception;
	
	public void update(Go_BoardDTO gdto) throws Exception;
	
	public void delete(Integer brd_num)throws Exception;
	
	// 데이터 보여주기 
	public List<Go_BoardDTO> numlist() throws Exception;
		
	// 페이지 처리
	public List<Go_BoardDTO> listPage(PageBasic pbsc) throws Exception;
	
	// 2번째 페이지 처리
	public int count(PageBasic pbsc) throws Exception;
	
	// 조회수 증가
	public void updateViewCnt(Integer brd_viewed) throws Exception;
	
	// 검색 처리
	public List<Go_BoardDTO> listFind(FindData fd) throws Exception;
	// 검색했을 때 몇개 나오는지 확인
	public int findCount(FindData fd) throws Exception;
	
	// 좋아요 증가 처리
	public void updatelikeCntUp(Integer Like_cnt) throws Exception;
			
	// 좋아요 감소 처리
	public void updatelikeCntDown(Integer Like_cnt) throws Exception;
	
	// 2) 정렬 !! 2번째 페이징 처리 : 조회수 순서
	public List<Go_BoardDTO> ViewlistPage(PageBasic pbsc) throws Exception;
			
	// 2) 정렬 !! 전체 조회 : 조회수 순서
	public int Viewcount (PageBasic pbsc) throws Exception;
	
	// 3) 정렬 !! 좋아요 수 정렬
	public List<Go_BoardDTO> likelistPage(PageBasic pbsc) throws Exception;
			
	// 3) 정렬 !! 좋아요 수 정렬 카운트
	public int LikeCount (PageBasic pbsc) throws Exception;

}




