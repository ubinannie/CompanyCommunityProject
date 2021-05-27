package company.blind.service;

import java.util.List;

import company.blind.dto.CommentDTO;

public interface CommentService {
	public void write(CommentDTO cdto) throws Exception;
	public void modify(CommentDTO cdto) throws Exception;
	public void delete(int cmt_num) throws Exception;
	public CommentDTO get(int cmt_num) throws Exception;
	
	public List<CommentDTO> list(int brd_num) throws Exception;
	
	public List<CommentDTO> listMem(String mem_id) throws Exception;
	

}



