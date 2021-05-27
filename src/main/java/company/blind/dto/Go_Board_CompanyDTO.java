package company.blind.dto;

import java.util.Date;

public class Go_Board_CompanyDTO {
	
	private Integer brd_cm_num;
	private String brd_cm_title;
	private String brd_cm_cont;
	private Date brd_cm_regdate;
	private Integer mem_level;		// default 값을 2로 잡아놨음
									// 회원가입 할 때는 mem_level default 값이 1임
									// 관리자 권한으로 변경 시 연락달라고해서 우리가 직접 승인하는 시스템으로 할꺼임
									// mem_level 1 -> 사용자 -> 회사 소식 볼 수 만 있게 처리 -> 작성 / 수정 / 삭제는 불가능하게
									// mem_level 2 -> 관리자 -> 볼 수 있고 / 작성 / 수정 / 삭제 가능하게 처리 
	private String com_name;
	private String mem_id;
	
	// 기본 생성자
	public Go_Board_CompanyDTO() {
		// TODO Auto-generated constructor stub
	}

	public Integer getBrd_cm_num() {
		return brd_cm_num;
	}

	public void setBrd_cm_num(Integer brd_cm_num) {
		this.brd_cm_num = brd_cm_num;
	}

	public String getBrd_cm_title() {
		return brd_cm_title;
	}

	public void setBrd_cm_title(String brd_cm_title) {
		this.brd_cm_title = brd_cm_title;
	}

	public String getBrd_cm_cont() {
		return brd_cm_cont;
	}

	public void setBrd_cm_cont(String brd_cm_cont) {
		this.brd_cm_cont = brd_cm_cont;
	}

	public Date getBrd_cm_regdate() {
		return brd_cm_regdate;
	}

	public void setBrd_cm_regdate(Date brd_cm_regdate) {
		this.brd_cm_regdate = brd_cm_regdate;
	}

	public Integer getMem_level() {
		return mem_level;
	}

	public void setMem_level(Integer mem_level) {
		this.mem_level = mem_level;
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
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "Go_Board_CompanyDTO [ brd_cm_num : " + this.brd_cm_num + ", brd_cm_title : " + this.brd_cm_title 
				+ ", brd_cm_cont : " + this.brd_cm_cont
			+ " , brd_cm_regdate : " + this.brd_cm_regdate + " , mem_level : " + this.mem_level
			+ " , com_name : " + this.com_name + " , mem_id : " + this.mem_id + " ] " ;
	}
	

}
