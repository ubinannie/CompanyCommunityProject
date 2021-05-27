package company.blind.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import company.blind.dto.Go_MemberDTO;

@Repository
public class Go_MemberDAOImpl implements Go_MemberDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insertMem(Go_MemberDTO mdto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("inMem", mdto);
	}

	@Override
	public void updateMem(Go_MemberDTO mdto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("upMem", mdto);
	}

	@Override
	public void deleteMem(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("deMem", mem_id);
	}

	@Override
	public int getMem(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getMem", mem_id);
	}

	@Override
	public List<Go_MemberDTO> listMem() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("listMem");
	}

	@Override
	public List<Go_MemberDTO> listMemByCom(String com_name) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("listMemberByCom", com_name);
	}

	@Override
	public String getCom(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("getCom", mem_id);
	}

}
