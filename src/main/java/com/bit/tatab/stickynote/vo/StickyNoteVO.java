package com.bit.tatab.stickynote.vo;

public class StickyNoteVO {
	
	private int no;
	private String login_email;
	private String note_title;
	private String note_content;

	public StickyNoteVO() {
		super();
	}
	
	public StickyNoteVO(String note_title, String note_content) {
		super();
		this.note_title = note_title;
		this.note_content = note_content;
	}
	
	public StickyNoteVO(int no, String login_email, String note_title, String note_content) {
		super();
		this.no = no;
		this.login_email = login_email;
		this.note_title = note_title;
		this.note_content = note_content;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getLogin_email() {
		return login_email;
	}

	public void setLogin_email(String login_email) {
		this.login_email = login_email;
	}

	public String getNote_title() {
		return note_title;
	}

	public void setNote_title(String note_title) {
		this.note_title = note_title;
	}

	public String getNote_content() {
		return note_content;
	}

	public void setNote_content(String note_content) {
		this.note_content = note_content;
	}

	@Override
	public String toString() {
		return "StickyNoteVO [no=" + no + ", login_email=" + login_email + ", note_title=" + note_title
				+ ", note_content=" + note_content + "]";
	}
	
	
}
