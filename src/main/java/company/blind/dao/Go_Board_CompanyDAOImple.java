package company.blind.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import company.blind.dto.FindData;
import company.blind.dto.Go_Board_CompanyDTO;
import company.blind.dto.PageBasic;

@Repository
public class Go_Board_CompanyDAOImple implements Go_Board_CompanyDAO{

	@Inject
	private SqlSession sqlSession;
	
	// 게시물 작성
	@Override
	public void insertCompany(Go_Board_CompanyDTO gcdto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("insertcompanyboard", gcdto);
	}

	// 페이징 처리할 때 필요
	@Override
	public Go_Board_CompanyDTO selectCompany(Integer brd_cm_num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectcompanyboard", brd_cm_num);
	}

	// 수정
	@Override
	public void updatecompany(Go_Board_CompanyDTO gdto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("updatecompanyboard", gdto);
	}

	// 삭제
	@Override
	public void deleteCompany(Integer brd_cm_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("deletecompanyboard", brd_cm_num);
	}

	// 전체 조회
	@Override
	public List<Go_Board_CompanyDTO> numlistCompany() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("numlistcompanyboard");
	}

	// 페이징 처리
	@Override
	public List<Go_Board_CompanyDTO> listPageCompany(int page) throws Exception {
		// TODO Auto-generated method stub
		if (page <=0) {
			page = 1;
		}
		page = (page -1) * 20;
		
		return sqlSession.selectList("listcompanypage", page);
	}

	// 페이지 조회
	@Override
	public List<Go_Board_CompanyDTO> listPageBasicCompany(PageBasic pagebasic) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("listPageBasicCompany", pagebasic);
	}

	@Override
	public int countDataCompany(PageBasic pagebis) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("countDataCompany", pagebis);
	}


	@Override
	public List<Go_Board_CompanyDTO> listFind(FindData fd) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("listFindCompany", fd);
	}

	@Override
	public int findCount(FindData fd) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("findCountCompany", fd);
	}

}
