package com.bit.tatab.login.service;

import java.util.List;

import com.bit.tatab.login.vo.LoginVO;

public interface LoginService {

	// 로그인 info db에 존재하는지 확인(검색)
	public List<LoginVO> memberInfoFind(LoginVO loginVO);
	
	// 로그인 info db에  추가
 	public void memberInfoInsert(LoginVO loginVO);
}
