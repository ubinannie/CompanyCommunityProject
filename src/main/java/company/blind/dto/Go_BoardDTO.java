package company.blind.dto;

import java.util.Date;

public class Go_BoardDTO {

	private Integer brd_num;
	private String brd_title;
	private String brd_cont;
	private Date brd_regdate;
	private Integer brd_viewed;
	private String com_name;
	private String mem_id;
	private Integer Like_cnt;
	
	// 기본 생성자 
	public Go_BoardDTO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Go_BoardDTO [ brd_num : " + this.brd_num + ", brd_title : " + this.brd_title + ", brd_cont : " + this.brd_cont
				+ " , brd_regdate : " + this.brd_regdate + " , brd_viewed : " + this.brd_viewed
				+ " , com_name : " + this.com_name + " , mem_id : " + this.mem_id + 
				 " , Like_cnt : " + this.Like_cnt + " ] " ;
	}

	public Integer getBrd_num() {
		return brd_num;
	}

	public void setBrd_num(Integer brd_num) {
		this.brd_num = brd_num;
	}

	public String getBrd_title() {
		return brd_title;
	}

	public void setBrd_title(String brd_title) {
		this.brd_title = brd_title;
	}

	public String getBrd_cont() {
		return brd_cont;
	}

	public void setBrd_cont(String brd_cont) {
		this.brd_cont = brd_cont;
	}

	public Date getBrd_regdate() {
		return brd_regdate;
	}

	public void setBrd_regdate(Date brd_regdate) {
		this.brd_regdate = brd_regdate;
	}

	public Integer getBrd_viewed() {
		return brd_viewed;
	}

	public void setBrd_viewed(Integer brd_viewed) {
		this.brd_viewed = brd_viewed;
	}

	public String getCom_name() {
		return com_name;
	}

	public void setCom_name(String com_name) {
		this.com_name = com_name;
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}
	
	public Integer getLike_cnt() {
		return Like_cnt;
	}

	public void setLike_cnt(Integer like_cnt) {
		Like_cnt = like_cnt;
	}
	
	
}
