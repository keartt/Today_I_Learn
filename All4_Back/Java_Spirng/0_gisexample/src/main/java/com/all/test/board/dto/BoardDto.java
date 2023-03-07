package com.all.test.board.dto;

import java.sql.Date;

public class BoardDto {
	private int bId;  // 글 번호
	private String bName;  // 작성자 이름
	private String bPw; // 작성자 비밀번호
	private String bTitle;  // 글 제목
	private String bContent; // 글 내용
	private String bFILE; // 파일
	private Date bDate;  // 작성 날짜
	private int bHit; // 조회수
	private int bGroup; // 그룹 번호
	private int bStep; // 답글 순서
	private int bIndent;// 들여쓰기
	
	
	public BoardDto() {
		
	}


	public BoardDto(int bId, String bName, String bPw, String bTitle, String bContent, String bFILE, Date bDate,
			int bHit, int bGroup, int bStep, int bIndent) {
		super();
		this.bId = bId;
		this.bName = bName;
		this.bPw = bPw;
		this.bTitle = bTitle;
		this.bContent = bContent;
		this.bFILE = bFILE;
		this.bDate = bDate;
		this.bHit = bHit;
		this.bGroup = bGroup;
		this.bStep = bStep;
		this.bIndent = bIndent;
	}


	public int getbId() {
		return bId;
	}


	public void setbId(int bId) {
		this.bId = bId;
	}


	public String getbName() {
		return bName;
	}


	public void setbName(String bName) {
		this.bName = bName;
	}


	public String getbPw() {
		return bPw;
	}


	public void setbPw(String bPw) {
		this.bPw = bPw;
	}


	public String getbTitle() {
		return bTitle;
	}


	public void setbTitle(String bTitle) {
		this.bTitle = bTitle;
	}


	public String getbContent() {
		return bContent;
	}


	public void setbContent(String bContent) {
		this.bContent = bContent;
	}


	public String getbFILE() {
		return bFILE;
	}


	public void setbFILE(String bFILE) {
		this.bFILE = bFILE;
	}


	public Date getbDate() {
		return bDate;
	}


	public void setbDate(Date bDate) {
		this.bDate = bDate;
	}


	public int getbHit() {
		return bHit;
	}


	public void setbHit(int bHit) {
		this.bHit = bHit;
	}


	public int getbGroup() {
		return bGroup;
	}


	public void setbGroup(int bGroup) {
		this.bGroup = bGroup;
	}


	public int getbStep() {
		return bStep;
	}


	public void setbStep(int bStep) {
		this.bStep = bStep;
	}


	public int getbIndent() {
		return bIndent;
	}


	public void setbIndent(int bIndent) {
		this.bIndent = bIndent;
	}
	
	

}
