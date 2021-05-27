package company.blind.dao;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import company.blind.dto.MemberDTOTest;

@Repository		// @Repository : 를 꼬옥 넣어놔야함 -> 컨트롤러에 넣어놔도 여기서 한번 더 넣어줘야함
public class MemberDAOImpleTest implements MemberDAOTest{

	// src 밑에 resources 밑에 mappers 밑에 MemberMapperTest 
	private static final String NAMESPACE = "company.exam.dao";
	
	@Inject
	private SqlSession sqlsession;
	
	// 회원 정보 추가 테스트 로직 
	@Override
	public void insertTest(MemberDTOTest mdto) {
		// TODO Auto-generated method stub
		// insert는 return 값이 아니므로 바로 sqlsession 선언하기
		sqlsession.insert(NAMESPACE + ".insertMember", mdto);
	}
	
	

}
