package company.blind.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import company.blind.dto.CommentDTO;

@Repository
public class CommentDAOImpl implements CommentDAO {
	
	@Inject
	private SqlSession sqlSession;
	
	@Override
	public void insert(CommentDTO cdto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.insert("insertComment", cdto);
	}

	@Override
	public void update(CommentDTO cdto) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.update("updateComment", cdto);
	}

	@Override
	public void delete(int cmt_num) throws Exception {
		// TODO Auto-generated method stub
		sqlSession.delete("deleteComment", cmt_num);
	}

	@Override
	public List<CommentDTO> listByHierarchi(int brd_num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("listComment", brd_num);
	}

	@Override
	public CommentDTO read(int cmt_num) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("readComment",cmt_num);
	}

	@Override
	public List<CommentDTO> listByMem(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return sqlSession.selectList("listCommentByMem", mem_id);
	}

}
