package net.member.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class MemberDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;

	// 커넥션 풀
	public MemberDAO() {
		try {
			Context init = new InitialContext();
			DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/postgreSQL");
			con = ds.getConnection();
			System.out.println("DB 연결성공");
		} catch (Exception ex) {
			System.out.println("DB 연결실패 : " + ex);
			return;
		}
	}

	// insert 회원가입
	public int Join(String id, String pw, String email, String name, String birth, String hobby, String intro, String address) {
		String sql = "INSERT INTO user_info values(?, ?, ?, ?, ?, ?, ?, ?)"; // 쿼리문

		try {
			pstmt = con.prepareStatement(sql);

			pstmt.setString(1, id);
			pstmt.setString(2, pw);
			pstmt.setString(3, email);
			pstmt.setString(4, name);
			pstmt.setString(5, birth);
			pstmt.setString(6, hobby);
			pstmt.setString(7, intro);
			pstmt.setString(8, address);

			// update
			pstmt.executeUpdate();

			return 1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		// 로그인 실패
		return 0;
	}

	// 로그인 로직 구현
	public boolean Login(String id, String pw) {
		String SQL = "SELECT pw FROM user_info WHERE id =?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(pw)) {
					return true; // 로그인 성공
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		return false; // 실패
	}

	public ArrayList<String> getUserID() {
		ArrayList<String> arr = new ArrayList<String>();
		String sql = "SELECT * FROM user_info";
		try {
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				arr.add(rs.getString(1));
			}
			arr.remove("admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return arr;
	}

	public void deleteUser(String id) {
		String sql = "DELETE FROM user_info where id = ?";
		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public MemberBean ViewUser(String id) {
		String sql = "SELECT * FROM user_info WHERE ID = ?";

		try {
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				MemberBean member = new MemberBean();
				member.setUser_id(rs.getString(1));
				member.setUser_pw(rs.getString(2));
				member.setEmail(rs.getString(3));
				member.setName(rs.getString(4));
				member.setBirth(rs.getString(5));
				member.setHobby(rs.getString(6));
				member.setIntro(rs.getString(7));
				member.setAddress(rs.getString(8));
				return member;
			}

		} catch (Exception ex) {
			System.out.println("getMemberInfo err : " + ex);
		}

		return null;

	}

}
