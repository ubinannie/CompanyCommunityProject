package company.blind.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import company.blind.dto.FindData;
import company.blind.dto.Go_BoardDTO;
import company.blind.dto.LiketoDTO;
import company.blind.dto.PageBasic;

// @Repository : DAO 의 역할을 해줘
@Repository
public class Go_BoardDTOImple implements Go_BoardDAO{

	@Inject
	private SqlSession sqlSession;
	
	
	@Override
	public void insert(Go_BoardDTO gdto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("insertboard", gdto);
	}

	@Override
	public Go_BoardDTO select(Integer brd_num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("selectboard", brd_num);
	}

	@Override
	public void update(Go_BoardDTO gdto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("updateboard", gdto);
	}

	@Override
	public void delete(Integer brd_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("deleteboard", brd_num);
	}

	// 번호로 전체 데이터 조회
	@Override
	public List<Go_BoardDTO> numlist() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("numlist");
	}

	// 조회수로 전체 데이터 조회 -> 아직 처리 안함 !!!!! 
	@Override
	public List<Go_BoardDTO> viewelist() throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("viewelist");
	}

	// 페이징 처리하는 부분 
	@Override
	public List<Go_BoardDTO> listPage(int page) throws Exception {
		// TODO Auto-generated method stub
		if (page <=0) {
			page = 1;
		}
		
		page = (page - 1) * 20;
		
		return sqlSession.selectList("listPage", page);
	}

	// 페이지 조회
	// (번호로)
	@Override
	public List<Go_BoardDTO> listPageBasic(PageBasic pagebasic) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("listPageBasic", pagebasic);
	}

	@Override
	public int countData(PageBasic pagebis) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("countData", pagebis);
	}

	// 조회 수 증가
	@Override
	public void updateViewCnt(Integer brd_viewed) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("updateViewCnt", brd_viewed);
	}

	// 검색 처리
	@Override
	public List<Go_BoardDTO> listFind(FindData fd) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("listFind", fd);
	}

	@Override
	public int findCount(FindData fd) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("findCount", fd);
	}
	
	// 좋아요 증가 처리
		@Override
		public void updatelikeCntUp(Integer Like_cnt) throws Exception {
			// TODO Auto-generated method stub
			sqlSession.update("updatelikeCntUp", Like_cnt);
		}

	// 좋아요 감소 처리
	@Override
	public void updatelikeCntDown(Integer Like_cnt) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("updatelikeCntDown", Like_cnt);
	}
	
	// 2) 정렬 !! 2번째 페이징 처리 : 조회수 순서
	@Override
	public List<Go_BoardDTO> ViewlistPageBasic(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("ViewlistPageBasic", pbsc);
	}

	// 2) 정렬 !! 2번째 페이징 처리 : 조회수 순서
	@Override
	public int ViewcountData(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("ViewcountData", pbsc);
	}
	
	// 3) 정렬 !! 페이징 처리 : 좋아요 순서
	@Override
	public List<Go_BoardDTO> likelistPageBasic(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("likelistPageBasic", pbsc);
	}

	// 3) 정렬 !! 페이징 처리 : 좋아요 순서
	@Override
	public int LikeCountData(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("LikeCountData", pbsc);
		}
		
	
	
	

}
