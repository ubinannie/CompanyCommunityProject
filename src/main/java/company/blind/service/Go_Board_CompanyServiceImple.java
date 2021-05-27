package company.blind.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import company.blind.dao.Go_Board_CompanyDAO;
import company.blind.dto.FindData;
import company.blind.dto.Go_Board_CompanyDTO;
import company.blind.dto.PageBasic;

@Service
public class Go_Board_CompanyServiceImple implements Go_Board_CompanyService{
	
	@Inject
	private Go_Board_CompanyDAO gcdao;

	// 게시물 작성
	@Override
	public void insertCompany(Go_Board_CompanyDTO gcdto) throws Exception {
		// TODO Auto-generated method stub
		gcdao.insertCompany(gcdto);
	}

	// 페이징 처리할 때 필요
	@Override
	public Go_Board_CompanyDTO selectCompany(Integer brd_cm_num) throws Exception {
		// TODO Auto-generated method stub
		return gcdao.selectCompany(brd_cm_num);
	}

	// 수정
	@Override
	public void updatecompany(Go_Board_CompanyDTO gdto) throws Exception {
		// TODO Auto-generated method stub
		gcdao.updatecompany(gdto);
	}

	// 삭제
	@Override
	public void deleteCompany(Integer brd_cm_num) throws Exception {
		// TODO Auto-generated method stub
		gcdao.deleteCompany(brd_cm_num);
	}

	// 전체 조회
	@Override
	public List<Go_Board_CompanyDTO> numlistCompany() throws Exception {
		// TODO Auto-generated method stub
		return gcdao.numlistCompany();
	}

	// 페이징 처리
	
	@Override
	public List<Go_Board_CompanyDTO> listPageCompany(int page) throws Exception {
		// TODO Auto-generated method stub
		return gcdao.listPageCompany(page);
	}
	

	// 페이징 처리
	@Override
	public List<Go_Board_CompanyDTO> listPageBasicCompany(PageBasic pagebasic) throws Exception {
		// TODO Auto-generated method stub
		return gcdao.listPageBasicCompany(pagebasic);
	}

	// 페이징 처리 정보
	@Override
	public int countDataCompany(PageBasic pagebasic) throws Exception {
		// TODO Auto-generated method stub
		return gcdao.countDataCompany(pagebasic);
	}

	// 검색 처리
	@Override
	public List<Go_Board_CompanyDTO> listFind(FindData fd) throws Exception {
		// TODO Auto-generated method stub
		return gcdao.listFind(fd);
	}

	// 검색 리스트 불러오기
	@Override
	public int findCount(FindData fd) throws Exception {
		// TODO Auto-generated method stub
		return gcdao.findCount(fd);
	}

}
