package company.blind.dto;

import java.util.Date;

public class CommentDTO {
	private int cmt_num;			//해당 댓글의 num, auto increment
	private String com_cont;		//내용
	private int com_lev;			//레벨, 안쓰긴 함
	private int com_group;		//부모 댓글 num
	private int brd_num;			//게시글 번호
	private String mem_id;		//맴버 id
	private Date com_regdate;

	public CommentDTO() {}

	public int getCmt_num() {
		return cmt_num;
	}

	public void setCmt_num(int cmt_num) {
		this.cmt_num = cmt_num;
	}

	public String getCom_cont() {
		return com_cont;
	}

	public void setCom_cont(String com_cont) {
		this.com_cont = com_cont;
	}

	public int getCom_lev() {
		return com_lev;
	}

	public void setCom_lev(int com_lev) {
		this.com_lev = com_lev;
	}

	public int getCom_group() {
		return com_group;
	}

	public void setCom_group(int com_group) {
		this.com_group = com_group;
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

	public Date getCom_regdate() {
		return com_regdate;
	}

	public void setCom_regdate(Date com_regdate) {
		this.com_regdate = com_regdate;
	}
	
	
	
}
