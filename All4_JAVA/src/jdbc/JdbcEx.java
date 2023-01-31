package jdbc;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class JdbcEx {
	public static void main(String[] args) throws ClassNotFoundException {
		// jdbc 드라이버 로드
		Class.forName("org.postgresql.Driver");

		String con = "jdbc:postgresql://localhost:5432/postgres";
		String user = "postgres";
		String pw = "8888";

		Statement statement = null;
		ResultSet resultSet = null;
		Connection connection = null;
		PreparedStatement psmt = null;
		
		int num2 = 2;
		String name2 = "name2";
		
		// connection -> 데이터베이스 연결
		try {
			connection = DriverManager.getConnection(con, user, pw);
			
			// statement static 객체 .. 생성
			statement = connection.createStatement();
			// 결과 받기 -> 버전 받기
			
			psmt = connection.prepareStatement("INSERT INTO test3 VALUES (?,?)");
			psmt.setInt(1, num2);
			psmt.setString(2, name2);
			psmt.executeUpdate();
			
			resultSet = statement.executeQuery("SELECT * FROM test3");

			while (resultSet.next()) {
				int num = resultSet.getInt("num");
				String name = resultSet.getString("name");
				
				System.out.println(num + "\t" + name);
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
