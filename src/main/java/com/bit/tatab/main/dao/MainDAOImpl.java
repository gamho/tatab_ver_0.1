package com.bit.tatab.main.dao;


import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.bit.tatab.main.vo.ProjectVO;
import com.bit.tatab.stickynote.vo.StickyNoteVO;


@Repository
public class MainDAOImpl implements MainDAO {

	@Inject
	private SqlSession sqlSession;

	@Override
	public void insert(ProjectVO project) {
		
		sqlSession.insert("insert", project);
	}
	
	@Override
	// stickyNote findAll
	public List<StickyNoteVO> stickyNoteFindAll(String login_email) {
		return sqlSession.selectList("stickyNoteFindAll", login_email);
	}

	@Override
	// stickyNote insert
	public void insertStickyNote(StickyNoteVO stickyNoteVO) {
		sqlSession.insert("insertStickyNote", stickyNoteVO);
	}
}
