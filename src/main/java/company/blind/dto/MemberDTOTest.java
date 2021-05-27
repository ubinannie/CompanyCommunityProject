package company.blind.dto;

public class MemberDTOTest {

	private String mem_id;
	private String mem_pwd;
	private String mem_email;
	private String mem_age_range;
	private String mem_birth;
	private String mem_birthyear;
	private String mem_gender;
	private String mem_phone;
	
	public MemberDTOTest() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "MemberDTO [mem_id : " + this.mem_id + "mem_pwd : " + this.mem_pwd +
				"mem_email : " + this.mem_email + "mem_age_range : " + this.mem_age_range +
				"mem_birth : " + this.mem_birth + "mem_birthyear : " + this.mem_birthyear +
				"gender : " + this.mem_gender + "phone : " + this.mem_phone + "]";
	}

	public String getMem_id() {
		return mem_id;
	}

	public void setMem_id(String mem_id) {
		this.mem_id = mem_id;
	}

	public String getMem_pwd() {
		return mem_pwd;
	}

	public void setMem_pwd(String mem_pwd) {
		this.mem_pwd = mem_pwd;
	}

	public String getMem_email() {
		return mem_email;
	}

	public void setMem_email(String mem_email) {
		this.mem_email = mem_email;
	}

	public String getMem_age_range() {
		return mem_age_range;
	}

	public void setMem_age_range(String mem_age_range) {
		this.mem_age_range = mem_age_range;
	}

	public String getMem_birth() {
		return mem_birth;
	}

	public void setMem_birth(String mem_birth) {
		this.mem_birth = mem_birth;
	}

	public String getMem_birthyear() {
		return mem_birthyear;
	}

	public void setMem_birthyear(String mem_birthyear) {
		this.mem_birthyear = mem_birthyear;
	}

	public String getMem_Gender() {
		return mem_gender;
	}

	public void setMem_Gender(String mem_gender) {
		this.mem_gender = mem_gender;
	}

	public String getMem_Phone() {
		return mem_phone;
	}

	public void setMem_Phone(String mem_phone) {
		this.mem_phone = mem_phone;
	}
	
	
	
}
