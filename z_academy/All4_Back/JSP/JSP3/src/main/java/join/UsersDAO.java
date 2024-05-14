package join;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class UsersDAO {
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet rs;

	public UsersDAO() {
		try {
			String psql = "jdbc:postgresql://localhost:5432/postgres?useUnicode=true&characterEncoding=utf8";
			String pID = "postgres";
			String PPw = "1234";

			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(psql, pID, PPw);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 회원가입 
	//-1 = 아이디 중복
	public int join(Users users) {
		String SQL = "INSERT INTO USERS  (user_id, user_pw, email, user_name, regi_num_fornt,  regi_num_back, b_year,b_month,b_day,interest ,introduce) VALUES (?,?,?,?,? ,?,?,?,?,?,?)";
				 
		try {
			// 배열로 받아온 값을 string 으로 변환해서 db에 넣기
			// 넣는데 쉼표로 구분
			String interesting = " ";
			for(String i : users.getInterest()) {
				interesting = i + "," +interesting ;
			}
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, users.getUser_id());
			pstmt.setString(2, users.getUser_pw());
			pstmt.setString(3, users.getEmail());
			pstmt.setString(4, users.getName());
			pstmt.setString(5, users.getRegi_num_front());
			pstmt.setString(6, users.getRegi_num_back());
			pstmt.setString(7, users.getYear());
			pstmt.setString(8, users.getMonth());
			pstmt.setString(9, users.getDay());
			pstmt.setString(10, interesting);
			pstmt.setString(11, users.getIntroduce());
			
			return pstmt.executeUpdate();
		} catch (Exception e) {
			//e.printStackTrace();
		}
		return -1; // 데이터베이스 오류
	}
	
	// 로그인 성공 1 비번다름 0 아이디없음 -1 db 오류 -2
	// admin = 2
	public int login(String user_id, String user_pw) {
		String SQL = "SELECT user_pw FROM users WHERE user_id =?";
		try {
			pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, user_id);

			rs = pstmt.executeQuery();
			if (rs.next()) {
				if (rs.getString(1).equals(user_pw)) {
					if (user_id.equals("admin")) {
						return 2;
					}
					
					return 1; // 로그인 성공
				} else {
					return 0; // 비밀번호 불일치
				}
			}
			return -1;

		} catch (Exception e) {
			e.printStackTrace();
		}
		return -2; // DB 오류
	}
	
	 //유저정보 가져오기 
	public Users getUsers(String user_id) {
		Users users;
		String SQL = "SELECT * FROM users WHERE user_id=?";
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			pstmt.setString(1, user_id);
			rs = pstmt.executeQuery();
			if (rs.next()) {
				users = new Users();
				users.setUser_id(rs.getString(1));
				users.setUser_pw(rs.getString(2));
				users.setEmail(rs.getString(3));
				users.setName(rs.getString(4));
				users.setRegi_num_front(rs.getString(5));
				users.setRegi_num_back(rs.getString(6));
				users.setYear(rs.getString(7));
				users.setMonth(rs.getString(8));
				users.setDay(rs.getString(9));
				// 쉼표로 넣어놨던 db에서 다시 쉼표로 구분해서
				// 배열에 넣은다음에 그 배열을 set
				String [] interest = rs.getString(10).split(",");
				users.setInterest( interest );
				users.setIntroduce(rs.getString(11));
				System.out.println(interest);
				System.out.println(users);
				return users;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	// 유저 아이디 가져오기
	public ArrayList <String> getUserID() {
		String SQL = "SELECT user_id FROM users ";
		ArrayList<String> uList = new ArrayList<String>();
		try {
			PreparedStatement pstmt = con.prepareStatement(SQL);
			rs = pstmt.executeQuery();
			while ( rs.next()) {
				uList.add(rs.getString(1));
			}
			return uList;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
}
