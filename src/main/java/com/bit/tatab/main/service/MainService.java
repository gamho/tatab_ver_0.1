package com.bit.tatab.main.service;

import java.util.List;

import com.bit.tatab.main.vo.ProjectVO;
import com.bit.tatab.stickynote.vo.StickyNoteVO;

public interface MainService {

	public void insert(ProjectVO project);
	
	// stickyNote findAll
	public List<StickyNoteVO> stickyNoteFindAll(String login_email);
	
	// stickyNote insert
	public void insertStickyNote(StickyNoteVO stickyNoteVO);
}
