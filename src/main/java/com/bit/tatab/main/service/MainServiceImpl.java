package com.bit.tatab.main.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bit.tatab.main.dao.MainDAO;
import com.bit.tatab.main.vo.ProjectVO;
import com.bit.tatab.stickynote.vo.StickyNoteVO;



@Service
public class MainServiceImpl implements MainService{

	@Inject
	private MainDAO mainDao;
	
	@Override
	public void insert(ProjectVO project) {
		mainDao.insert(project);
	}

	// stickyNote findAll
	public List<StickyNoteVO> stickyNoteFindAll(String login_email) {
		return mainDao.stickyNoteFindAll(login_email);
	}


	// stickyNote insert
	public void insertStickyNote(StickyNoteVO stickyNoteVO) {
		mainDao.insertStickyNote(stickyNoteVO);
	}
}
