package company.blind.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import company.blind.dao.CommentDAO;
import company.blind.dto.CommentDTO;

@Service
public class CommentServiceImpl implements CommentService {
	
	@Inject
	private CommentDAO cdao;
	
	@Override
	public void write(CommentDTO cdto) throws Exception {
		// TODO Auto-generated method stub
		cdao.insert(cdto);
	}

	@Override
	public void modify(CommentDTO cdto) throws Exception {
		// TODO Auto-generated method stub
		cdao.update(cdto);
	}

	@Override
	public void delete(int cmt_num) throws Exception {
		// TODO Auto-generated method stub
		cdao.delete(cmt_num);
	}

	@Override
	public CommentDTO get(int cmt_num) throws Exception {
		// TODO Auto-generated method stub
		return cdao.read(cmt_num);
	}

	@Override
	public List<CommentDTO> list(int brd_num) throws Exception {
		// TODO Auto-generated method stub
		return cdao.listByHierarchi(brd_num);
	}

	@Override
	public List<CommentDTO> listMem(String mem_id) throws Exception {
		// TODO Auto-generated method stub
		return cdao.listByMem(mem_id);
	}
	
	

}
