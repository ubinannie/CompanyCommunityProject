package company.blind.dto;

public class LiketoDTO {
	
	private int likeno;		// 좋아요 인덱스
	private int brd_num;	// 게시물 번호
	private String mem_id;	// 회원 고유 번호
	private int like_check;	// 좋아요 체크 했는지 안했는지
							// DEFAULT 값을 0으로 잡아놨음
							// 0 -> 체크 안함
							// 1 -> 체크 함 
	
	public LiketoDTO() {
		// TODO Auto-generated constructor stub
	}

	public int getLikeno() {
		return likeno;
	}

	public void setLikeno(int likeno) {
		this.likeno = likeno;
	}

	public int getBrd_num() {
		return brd_num;
	}

	public void setBrd_num(int brd_num) {
		this.brd_num = brd_num;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public int getLike_check() {
		return like_check;
	}

	public void setLike_check(int like_check) {
		this.like_check = like_check;
	}
	
	
	
	

}
