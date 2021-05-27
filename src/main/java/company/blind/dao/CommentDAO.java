package company.blind.dao;

import java.util.List;

import company.blind.dto.CommentDTO;

public interface CommentDAO {
	public void insert(CommentDTO cdto) throws Exception;
	public void update(CommentDTO cdto) throws Exception;
	public void delete(int cmt_num) throws Exception;
	public CommentDTO read(int cmt_num) throws Exception;
	
	public List<CommentDTO> listByHierarchi(int brd_num) throws Exception;
	
	public List<CommentDTO> listByMem(String mem_id) throws Exception;
}
