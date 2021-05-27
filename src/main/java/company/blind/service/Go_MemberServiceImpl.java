package company.blind.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import company.blind.dao.Go_MemberDAO;
import company.blind.dto.Go_MemberDTO;

@Service
public class Go_MemberServiceImpl implements Go_MemberService {
	
	@Inject
	private Go_MemberDAO mdao;
	
	@Override
	public void injectMem(Go_MemberDTO mdto) throws Exception {
		// TODO Auto-generated method stub
		mdao.insertMem(mdto);
	}

	@Override
	public void adjustMem(Go_MemberDTO mdto) throws Exception {
		// TODO Auto-generated method stub
		mdao.updateMem(mdto);
	}

	@Override
	public void removeMem(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		mdao.deleteMem(mem_id);
	}

	@Override
	public int receiveMem(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return mdao.getMem(mem_id);
	}

	@Override
	public List<Go_MemberDTO> allMem() throws Exception {
		// TODO Auto-generated method stub
		return mdao.listMem();
	}

	@Override
	public List<Go_MemberDTO> allMemByCom(String com_name) throws Exception {
		// TODO Auto-generated method stub
		return mdao.listMemByCom(com_name);
	}

	@Override
	public String getComName(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return mdao.getCom(mem_id);
	}

}
