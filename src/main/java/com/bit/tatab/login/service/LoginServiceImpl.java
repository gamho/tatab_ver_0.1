package com.bit.tatab.login.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.tatab.login.dao.LoginDAO;
import com.bit.tatab.login.vo.LoginVO;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;

	// 로그인 info db에 존재하는지 확인(검색)
	@Override
	public List<LoginVO> memberInfoFind(LoginVO loginVO) {
		return loginDAO.memberInfoFind(loginVO);
	}
	
	// 로그인 info db에  추가
	@Override
	public void memberInfoInsert(LoginVO loginVO) {
		loginDAO.memberInfoInsert(loginVO);
	}

}
