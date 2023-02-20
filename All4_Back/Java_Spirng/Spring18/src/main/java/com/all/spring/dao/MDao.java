package com.all.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.all.spring.util.Constant;
import com.all.spring.dto.BDto;
import com.all.spring.dto.MDto;

public class MDao {
	JdbcTemplate template;
	
	// 템플릿 쓸거야
	public MDao() {
		this.template = Constant.template;
	}

	// 회원가입 할거야
	public void Join(final String user_id, final String user_pw, final String email, final String name,
			final String regi_num_front, final String regi_num_back, final String year, final String month,
			final String day, final String interest, final String introduce) {
		this.template.update(new PreparedStatementCreator() {

			@Override
			public PreparedStatement createPreparedStatement(Connection con) throws SQLException {
				String query = "insert into mvc_member  values (?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement pstmt = con.prepareStatement(query);
				pstmt.setString(1, user_id);
				pstmt.setString(2, user_pw);
				pstmt.setString(3, email);
				pstmt.setString(4, name);
				pstmt.setString(5, regi_num_front);
				pstmt.setString(6, regi_num_back);
				pstmt.setString(7, year);
				pstmt.setString(8, month);
				pstmt.setString(9, day);
				pstmt.setString(10, interest);
				pstmt.setString(11, introduce);

				return pstmt;
			}
		});

	}
	
	// 로그인 할거야 (아이디, 비번 동일한 거 찾을거야)
	public MDto login(final String user_id, final String user_pw) {
	      String query = "select * from mvc_member where user_id = '" +  user_id + "' and user_pw = '" + user_pw +"'";
	      return template.queryForObject(query, new BeanPropertyRowMapper<MDto>(MDto.class));
	}
	
	// 회원 목록 불러올거야 , admin 만 빼고 
	public ArrayList<MDto> list() {
		String query = "select * from mvc_member where NOT user_id ='admin' ";
	      return (ArrayList<MDto>) template.query(query, new BeanPropertyRowMapper<MDto>(MDto.class));
	}
	
	// 회원 상세 보기 할거야 
	public MDto memberView(String user_id) {
		
		String query = "select * from mvc_member where user_id = '" + user_id +"'";
	    return template.queryForObject(query, new BeanPropertyRowMapper<MDto>(MDto.class));
	      
	}
	
	// 회원 지워버리기 
	public void delete(final String user_id) {
		 String query = "delete from mvc_member where user_id= ?";

		 this.template.update(query, new PreparedStatementSetter() {
	         
	         @Override
	         public void setValues(PreparedStatement ps) throws SQLException {
	            ps.setString(1, user_id);
	         }
	      });
	}

}
