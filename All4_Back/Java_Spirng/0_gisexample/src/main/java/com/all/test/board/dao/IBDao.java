package com.all.test.board.dao;

import java.util.ArrayList;

import com.all.test.board.dto.BoardDto;
import com.all.test.member.dto.MemberDto;

public interface IBDao {
	
	public ArrayList<BoardDto> listDao(); // 목록 
	public void writeDao(String bTitle, String bContent, String name); // 작성
	public BoardDto contentDao(String bId); // 상세
	public void deleteDao(String bId); // 삭제
	public void modifyDao(String bTitle, String bContent, String bId); // 수정
	public void upHitDao(String bId);
	
	public BoardDto reply_view(String bId); // 답변 입력페이지
	public void replyDao(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent); // 답변
	
}
