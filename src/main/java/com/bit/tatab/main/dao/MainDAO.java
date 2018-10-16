package com.bit.tatab.main.dao;

import java.util.List;

import com.bit.tatab.main.vo.ProjectVO;
import com.bit.tatab.stickynote.vo.StickyNoteVO;

public interface MainDAO {

	public void insert(ProjectVO project);

	// stickyNote findAll
	public List<StickyNoteVO> stickyNoteFindAll(String login_email);

	// stickyNote insert
	public void insertStickyNote(StickyNoteVO stickyNoteVO);
}
