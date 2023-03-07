package com.all.test.member.dao;

import java.util.ArrayList;

import com.all.test.member.dto.MemberDto;

public interface IMDao {
	public ArrayList<MemberDto>login(String id); // 로그인

	public void join(String member_id, String member_pw, String member_email, String member_name, String member_pumber, String member_year, String member_month, String member_day, String member_postcode, String member_addr1, String addr2, String member_favorite, String member_introduce); // 회원가입

	public MemberDto MemberDao(String mId); // 회원 상세페이지 - 관리자

	public ArrayList<MemberDto> listDao(); // 회원 목록 - 관리자

	public void deleteDao(String mId); // 회원 삭제 - 관리자

	public void modifyDao(String member_id, String member_pw, String member_name, 
			String member_email, String member_pnumber,	String member_favorite,
			String member_introduce, String member_year, String member_month, String member_day,
			String member_postcode, String member_address);
	
}