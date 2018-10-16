package com.bit.tatab.login.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.tatab.login.vo.LoginVO;

public interface LoginDAO {

	// 로그인 info db에 존재하는지 확인(검색)
	public List<LoginVO> memberInfoFind(LoginVO loginVO);

	// 로그인 info db에  추가
	public void memberInfoInsert(LoginVO loginVO);
	
}
