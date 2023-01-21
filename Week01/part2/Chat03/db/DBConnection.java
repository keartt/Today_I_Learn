package Chat03.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

// DB Connection 용 클래스
public class DBConnection {
	public static Connection getConnection() throws ClassNotFoundException {
		Connection con = null;
		

		String psql = "jdbc:postgresql://localhost:5432/postgres";
		String pID = "postgres";
		String PPw = "0000";
		
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(psql, pID, PPw);
			
		} catch (Exception e) {
			System.out.println("DB 접속 오류");
		}
		return con;
	}

	/* 주의
	con > ps > rs 순서로 열었기 때문에
	닫을 때는 rs > ps > con */
	
	
	// 닫는 메소드
	public static void close(Connection conn) {
		if(conn != null) {try {conn.close();} catch (SQLException e) {e.printStackTrace();}}
	}

	public static void close(PreparedStatement pstmt) {
		if(pstmt != null) {try {pstmt.close();} catch (SQLException e) {e.printStackTrace();}}
	}
	public static void close(ResultSet rs) {
		if(rs != null) {try {rs.close();} catch (SQLException e) {e.printStackTrace();}}
	}
	
}
