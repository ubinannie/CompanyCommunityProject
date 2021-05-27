package company.blind.dao;

import java.util.List;

import company.blind.dto.FindData;
import company.blind.dto.Go_Board_CompanyDTO;
import company.blind.dto.PageBasic;

public interface Go_Board_CompanyDAO {
	
	public void insertCompany(Go_Board_CompanyDTO gcdto) throws Exception;
	
	public Go_Board_CompanyDTO selectCompany(Integer brd_cm_num) throws Exception;
	
	public void updatecompany(Go_Board_CompanyDTO gdto) throws Exception;
	
	public void deleteCompany(Integer brd_cm_num)throws Exception;
	
	// 게시글 번호로 전체 데이터 조회하기
	public List<Go_Board_CompanyDTO> numlistCompany() throws Exception;
	
	// 페이징 처리
	public List<Go_Board_CompanyDTO> listPageCompany(int page) throws Exception;
	
	// 2번째 페이징 처리
	public List<Go_Board_CompanyDTO> listPageBasicCompany(PageBasic pagebasic) throws Exception;
	
	// 전체 조회
	public int countDataCompany (PageBasic page) throws Exception;

	// 검색 처리
	public List<Go_Board_CompanyDTO> listFind(FindData fd) throws Exception;
		
	// 검색했을 때 몇개 나오는지 확인
	public int findCount(FindData fd) throws Exception;	

}
