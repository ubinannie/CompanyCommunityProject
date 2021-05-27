package company.blind.dao;

import java.util.List;

import company.blind.dto.Go_MemberDTO;

public interface Go_MemberDAO {
	public void insertMem(Go_MemberDTO mdto) throws Exception;
	public void updateMem(Go_MemberDTO mdto) throws Exception;
	public void deleteMem(String mem_id) throws Exception;
	
	//회원 존재 여부 체크용
	public int getMem(String mem_id) throws Exception;
	
	//필요할까 싶지만 일단 리스트
	public List<Go_MemberDTO> listMem() throws Exception;
	
	//회사별 리스트
	public List<Go_MemberDTO> listMemByCom(String com_name) throws Exception;
	
	//mem_id로 회사명
	public String getCom(String mem_id) throws Exception;
	
}

