package company.blind.dao;

import java.util.HashMap;
import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import company.blind.dto.LiketoDTO;
import company.blind.dto.PageBasic;

@Repository("company.blind.dao.LiketoDAO")
public class LiketoDAO implements LiketoInter{

	@Autowired
	private SqlSessionTemplate mybatis;
	
	public LiketoDAO() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public int countbyLike(HashMap hashMap) {
		// TODO Auto-generated method stub
		int count = mybatis.selectOne("liketo.countbyLike", hashMap);
		return count;
	}

	@Override
	public int create(HashMap hashMap) {
		int count = mybatis.insert("liketo.like_create", hashMap);
		return count;
	}

	@Override
	public int like_check(HashMap hashMap) {
		int count = mybatis.update("liketo.like_check", hashMap);
		return count;
	}

	@Override
	public int like_check_cancel(HashMap hashMap) {
		int count = mybatis.update("liketo.like_check_cancel", hashMap);
		return count;
	}

	@Override
	public LiketoDTO read(HashMap hashMap) {
		// TODO Auto-generated method stub
		LiketoDTO liktdto = mybatis.selectOne("liketo.like_read", hashMap);
		return liktdto;
	}

	@Override
	public int deletebybnum(int brd_num) {
		int count = mybatis.delete("liketo.deletebybnum", brd_num);
		return count;
	}

	// 좋아요 페이지 정렬
	/*
	@Override
	public List<LiketoDTO> likelistPageBasic(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectList("likelistPageBasic", pbsc);
	}

	// 좋아요 페이지 정렬시 count
	@Override
	public int LikeCountData(PageBasic pbsc) throws Exception {
		// TODO Auto-generated method stub
		return mybatis.selectOne("LikeCountData", pbsc);
	}
	*/
	/*
	@Override
	public int deletebyMemnum(String mem_id) {
		// TODO Auto-generated method stub
		int count = mybatis.delete("liketo.deletebyMemnum", mem_id);
		return count;
	}
	*/
	/*
	@Override
	public void deletebyMemnum(String mem_id) {
		int count = mybatis.delete("liketo.deletebyMemnum", mem_id);
		return count;
	}
	*/
}
