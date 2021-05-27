package company.blind.service;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import company.blind.dao.LiketoInter;
import company.blind.dto.LiketoDTO;
import company.blind.dto.PageBasic;

@Component("company.blind.service.LiketoService")
public class LiketoService implements liketoproIner{
	
	@Autowired
	@Qualifier("company.blind.dao.LiketoDAO")
	private LiketoInter liketoDAO = null;
	
	public LiketoService() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public int countbylike(HashMap hashmap) {
		int count = liketoDAO.countbyLike(hashmap);
		return count;
	}

	@Override
	public int create(HashMap hashmap) {
		int count = liketoDAO.create(hashmap);
		return count;
	}

	@Override
	public int like_check(HashMap hashmap) {
		int count = liketoDAO.like_check(hashmap);
		return count;
	}

	@Override
	public int like_check_cancel(HashMap hashmap) {
		int count = liketoDAO.like_check_cancel(hashmap);
		return count;
	}

	@Override
	public LiketoDTO read(HashMap hashmap) {
		LiketoDTO likedto = liketoDAO.read(hashmap);
		return likedto;
	}

	@Override
	public int deletebybnum(int brd_num) {
		// TODO Auto-generated method stub
		int count = liketoDAO.deletebybnum(brd_num);
		return count;
	}

	// 좋아요 정렬 
	/*
	@Override
	public List<LiketoDTO> likelistPage(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return liketoDAO.likelistPageBasic(pbsc);
	}

	// 좋아요 정렬 시 카운트
	@Override
	public int LikeCount(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return liketoDAO.LikeCountData(pbsc);
	}
	*/
	/*
	@Override
	@Override
	public int deletebyMemnum(int mem_num) {
		// TODO Auto-generated method stub
		int count = liketoDAO.deletebyMemnum(mem_num);
		return count;
	}
	*/
}
