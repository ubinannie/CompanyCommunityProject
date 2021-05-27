package company.blind.dao;

import java.util.List;

import company.blind.dto.FindData;
import company.blind.dto.Go_BoardDTO;
import company.blind.dto.LiketoDTO;
import company.blind.dto.PageBasic;

public interface Go_BoardDAO {
	
	public void insert(Go_BoardDTO gdto) throws Exception;
	
	public Go_BoardDTO select(Integer brd_num) throws Exception;
	
	public void update(Go_BoardDTO gdto) throws Exception;
	
	public void delete(Integer brd_num)throws Exception;
	
	// 게시글 번호로 전체 데이터 조회하기
	public List<Go_BoardDTO> numlist() throws Exception;
	
	// 조회수로 전체 데이터 조회하기	-> 아직 처리 안함 !!
	public List<Go_BoardDTO> viewelist() throws Exception;
	
	// 페이징 처리
	public List<Go_BoardDTO> listPage(int page) throws Exception;
	
	// 2번째 페이징 처리
	public List<Go_BoardDTO> listPageBasic(PageBasic pagebasic) throws Exception;
	
	// 전체 조회
	public int countData (PageBasic pagebis) throws Exception;
	
	// 조회수 증가 처리
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
	public List<Go_BoardDTO> ViewlistPageBasic(PageBasic pbsc) throws Exception;
			
	// 2) 정렬 !! 전체 조회 : 조회수 순서
	public int ViewcountData (PageBasic pbsc) throws Exception;
		
	// 3) 정렬 !! 좋아요 수 정렬
	public List<Go_BoardDTO> likelistPageBasic(PageBasic pbsc) throws Exception;
			
	// 3) 정렬 !! 좋아요 수 정렬 카운트
	public int LikeCountData (PageBasic pbsc) throws Exception;

}
