package com.all.spring.dao;

import com.all.spring.dto.MDto;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

public interface MDao {

	// 회원가
	public void join(@Param("user_id") String user_id, @Param("user_pw") String user_pw, @Param("email") String email,
			@Param("name") String name, @Param("regi_num_front") String regi_num_front,
			@Param("regi_num_back") String regi_num_back, @Param("year") String year, @Param("month") String month,
			@Param("day") String day, @Param("interest") String interest, @Param("introduce") String introduce);

	// 로그인
	public MDto login(@Param("user_id") String user_id, @Param("user_pw") String user_pw);

	// 회원 목록 불러오기
	public ArrayList<MDto> list();

	// 회원 상세 보기
	public MDto memberView(@Param("user_id") String user_id);

	// 회원 삭제
	public void delete(@Param("user_id") String user_id);

	// 개인정보 수정
	public void edit(@Param("user_id") String user_id, @Param("user_pw") String user_pw, @Param("email") String email,
			@Param("user_name") String user_name, @Param("interest") String interest, @Param("introduce") String introduce);
}
