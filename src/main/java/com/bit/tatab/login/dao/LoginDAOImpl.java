package com.bit.tatab.login.dao;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bit.tatab.login.vo.LoginVO;

@Repository
public class LoginDAOImpl implements LoginDAO {

	@Inject
	private SqlSession sqlSession;

	// 로그인 info db에 존재하는지 확인(검색)
	@Override
	public List<LoginVO> memberInfoFind(LoginVO loginVO) {
		return sqlSession.selectList("loginInfoFind", loginVO);
	}

	// 로그인 info db에  추가
	@Override
	public void memberInfoInsert(LoginVO loginVO) {
		
		System.out.println("dao에서 확인! " + loginVO.getLoginEmail() + ", " + loginVO.getLoginName());
		sqlSession.insert("loginInfoInsert", loginVO);
		
	}
}
