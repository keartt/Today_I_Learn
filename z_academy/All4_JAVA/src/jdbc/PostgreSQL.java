package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostgreSQL {
	public static void main(String[] args) throws ClassNotFoundException {
		// jdbc 드라이버 로드
		Class.forName("org.postgresql.Driver");

		String con = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String pw = "8888";

		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		
		// connection -> 데이터베이스 연결
		try {
			connection = DriverManager.getConnection(con, user, pw);
			
			// statement static 객체 .. 생성
			statement = connection.createStatement();
			// 결과 받기 -> 버전 받기
			resultSet = statement.executeQuery("SELECT VERSION() AS version");

			while (resultSet.next()) {
				String version = resultSet.getString("version");
				System.out.println(version);
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("연결실패");
		} finally {
			try {
				resultSet.close();
				statement.close();
				connection.close();
			} catch (SQLException e2) {
				e2.printStackTrace();
			}
		}
	}
}
