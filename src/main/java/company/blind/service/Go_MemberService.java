package company.blind.service;

import java.util.List;

import company.blind.dto.Go_MemberDTO;

public interface Go_MemberService {
	public void injectMem(Go_MemberDTO mdto) throws Exception;
	public void adjustMem(Go_MemberDTO mdto) throws Exception;
	public void removeMem(String mem_id) throws Exception;
	public int receiveMem(String mem_id) throws Exception;
	
	public List<Go_MemberDTO> allMem() throws Exception;
	public List<Go_MemberDTO> allMemByCom(String com_name) throws Exception;
	public String getComName(String mem_id) throws Exception;
}
