package company.blind.dao;

import java.util.HashMap;
import java.util.List;

// import org.apache.ibatis.annotations.Param;

import company.blind.dto.LiketoDTO;
import company.blind.dto.PageBasic;

public interface LiketoInter {
	
	// 게시판의 좋아요 번호가 있는지 카운트
	public int countbyLike(HashMap hashMap);
	
	// 좋아요 번호 등록
	public int create(HashMap hashMap);
	
	// 좋아요 체크 여부
	// @Param hashMap
	// 0 -> 1
	public int like_check(HashMap hashMap);
	
	// 1 -> 0
	public int like_check_cancel(HashMap hashMap);
	
	// 조회
	public LiketoDTO read(HashMap hashMap);
	
	// 게시판의 좋아요 삭제 
	public int deletebybnum(int brd_num);
	
	// 회원의 좋아요 삭제 
	// public int deletebyMemnum(String mem_id);
	
	// 좋아요 수 정렬
	// public List<LiketoDTO> likelistPageBasic(PageBasic pbsc) throws Exception;
	
	// 좋아요 수 정렬 카운트
	// public int LikeCountData (PageBasic pbsc) throws Exception;
	
}
