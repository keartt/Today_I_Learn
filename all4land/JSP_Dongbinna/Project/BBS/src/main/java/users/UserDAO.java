package users;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class UserDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;
	
	public UserDAO() {
		try {
			String psql = "jdbc:postgresql://localhost:5432/vroom";
			String pID = "postgres";
			String PPw = "1234";
			
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(psql, pID, PPw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public int login(String userId, String userPassword) {
		String SQL = "SELECT user_pw FROM users WHERE user_id =?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, userId);
			
			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(userPassword)) {
					return 1; // 로그인 성공
				}
				else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1;
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // DB 오류 
	}
	
	public int join(Users users) {
		String SQL = "insert into users values (?, ?, ?, ?, ?)";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, users.getUserId());
			pstmt.setString(2, users.getUserPassword());
			pstmt.setString(3, users.getUserName());
			pstmt.setString(4, users.getUserGender());
			pstmt.setString(5, users.getUserEmail());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return -1;
	}
		
}
