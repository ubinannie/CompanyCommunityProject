package company.blind.service;

import java.util.HashMap;
import java.util.List;

import company.blind.dto.LiketoDTO;
import company.blind.dto.PageBasic;

public interface liketoproIner {
	
	// 게시판의 좋아요 번호가 있는지 
	public int countbylike(HashMap hashmap);

	// 좋아요 번호 등록
	public int create(HashMap hashmap);
	
	// 좋아요 체크 여부
	// 0 -> 1
	public int like_check(HashMap hashmap);
	
	// 좋아요 체크 여부
	// 1 -> 0
	public int like_check_cancel(HashMap hashmap);
	
	// 조회
	public LiketoDTO read(HashMap hashmap);

	// 게시판의 좋아요 삭제 
	public int deletebybnum(int brd_num);
	
	// 회원의 좋아요 삭제 
	// public String deletebyMemnum(String mem_num);
	
	// 좋아요 수 정렬
	// public List<LiketoDTO> likelistPage(PageBasic pbsc) throws Exception;
		
	// 좋아요 수 정렬 카운트
	// public int LikeCount (PageBasic pbsc) throws Exception;
}
