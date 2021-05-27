package company.blind.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import company.blind.dao.Go_BoardDAO;
import company.blind.dto.FindData;
import company.blind.dto.Go_BoardDTO;
import company.blind.dto.PageBasic;

// 여기는 서비스 처리하는 곳
@Service
public class Go_BoardServiceImple implements Go_BoardService {

	@Inject
	private Go_BoardDAO gdao;
	
	@Override
	public void insert(Go_BoardDTO gdto) throws Exception {
		// TODO Auto-generated method stub
		gdao.insert(gdto);
	}

	@Override
	public Go_BoardDTO select(Integer brd_num) throws Exception {
		// TODO Auto-generated method stub
		return gdao.select(brd_num);
	}

	@Override
	public void update(Go_BoardDTO gdto) throws Exception {
		// TODO Auto-generated method stub
		gdao.update(gdto);
	}

	// 삭제하기
	@Override
	public void delete(Integer brd_num) throws Exception {
		// TODO Auto-generated method stub
		gdao.delete(brd_num);
	}

	// 게시글 번호로 전체 조회하기
	@Override
	public List<Go_BoardDTO> numlist() throws Exception {
		// TODO Auto-generated method stub
		return gdao.numlist();
	}

	// 페이징 처리
	@Override
	public List<Go_BoardDTO> listPage(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return gdao.listPageBasic(pbsc);
	}

	// 페이징 처리 갯수
	@Override
	public int count(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return gdao.countData(pbsc);
	}

	// 조회 수 증가
	@Override
	public void updateViewCnt(Integer brd_viewed) throws Exception {
		// TODO Auto-generated method stub
		gdao.updateViewCnt(brd_viewed);
	}

	// 검색 처리
	@Override
	public List<Go_BoardDTO> listFind(FindData fd) throws Exception {
		// TODO Auto-generated method stub
		return gdao.listFind(fd);
	}

	// 검색 리스트 불러오기
	@Override
	public int findCount(FindData fd) throws Exception {
		// TODO Auto-generated method stub
		return gdao.findCount(fd);
	}
	

	@Override
	public void updatelikeCntUp(Integer Like_cnt) throws Exception {
		// TODO Auto-generated method stub
		gdao.updatelikeCntUp(Like_cnt);
	}

	@Override
	public void updatelikeCntDown(Integer Like_cnt) throws Exception {
		// TODO Auto-generated method stub
		gdao.updatelikeCntDown(Like_cnt);
	}
	
	@Override
	public List<Go_BoardDTO> ViewlistPage(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return gdao.ViewlistPageBasic(pbsc);
	}

	@Override
	public int Viewcount(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return gdao.ViewcountData(pbsc);
	}
	
	// 좋아요 정렬 
	@Override
	public List<Go_BoardDTO> likelistPage(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return gdao.likelistPageBasic(pbsc);
	}

	// 좋아요 정렬 시 카운트
	@Override
	public int LikeCount(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return gdao.LikeCountData(pbsc);
	}
	
	
	
	

}
