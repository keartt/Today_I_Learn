package Chat03.db;

import java.security.Timestamp;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

// 데이터 DB 에 저장/조회 하는 클래스
public class DBRun {
	static ResultSet rs = null;
	static PreparedStatement psmt = null;
	
// ------------------------ users 테이블 관련 ----------------------------------

	// 회원가입 시 아이디 중복 체크 -> 중복일 경우 false
	public static boolean duplicateCheck(String user_id) throws ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		try {
			// 입력된 아이디와 같은 아이디가 db에 있는지 조회
			psmt = con.prepareStatement("select user_id from users where user_id =?");
			psmt.setString(1, user_id);
			rs = psmt.executeQuery();
			// 있으면 false
			if (rs.next()) {
				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(rs);
				DBConnection.close(psmt);
				DBConnection.close(con);
			} catch (Exception e2) {

			}
		}
		return false;
	}

	// 회원가입
	// 로그인 창에서 받은 값을 테이블에 삽입한다.
	public static void join(String name, String email, String user_id, String user_pw) throws ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		try {
			psmt = con.prepareStatement("insert into users (name, email, user_id, user_pw) values (? , ? , ? ,?)");
			psmt.setString(1, name);
			psmt.setString(2, email);
			psmt.setString(3, user_id);
			psmt.setString(4, user_pw);
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(psmt);
				DBConnection.close(con);
			} catch (Exception e2) {

			}
		}

	}

	// 로그인 -> id, pw 를 입력받아 db에 저장된 값과 일치 여부를 확인한다.
	// 1 : 로그인 성공 , 2 : 비번 오류, 3: 아이디 부재, 0 : 오류, 9 : 관리자
	public static int loginCheck(String user_id, String user_pw) throws ClassNotFoundException {
		Connection con = DBConnection.getConnection();

		try {
			psmt = con.prepareStatement("select user_pw, isAdmin from users where user_id =?");
			psmt.setString(1, user_id);

			rs = psmt.executeQuery();
			// 아이디가 있으면
			if (rs.next()) {
				// 아이디에 해당하는 비밀번호 값을 가져와서 그게 이 메소드에 입력된 password 랑 같으면
				if (rs.getString("user_pw").equals(user_pw)) {
					if (rs.getBoolean("isAdmin")) {
						return 9;
					}
					return 1; // 로그읜 성공
				} else {
					System.out.println("2번 성공");
					return 2; // 비밀번호 오류
				}
			}
			// 아이디 없음
			else {
				System.out.println("여기까진 오케이");
				return 3; // 아이디 없음
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("join 에서 오류2");

		} finally {
			try {
				DBConnection.close(rs);
				DBConnection.close(psmt);
				DBConnection.close(con);
			} catch (Exception e2) {

			}
		}
		return 0;
	}

	// id - > name  : 채팅방에서는 아이디가 아닌 닉네임을 사용하기 때문에
	public static String getName(String user_id) throws ClassNotFoundException {
		String name = "";
		Connection con = DBConnection.getConnection();
		try {
			// 유저 테이블에서 아이디 가져오는 쿼리문
			psmt = con.prepareStatement("select name from users where user_id = ?");
			psmt.setString(1, user_id);
			ResultSet rs = psmt.executeQuery();

			if (rs.next()) {
				name = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(con);
				DBConnection.close(rs);
				DBConnection.close(psmt);
			} catch (Exception e2) {

			}
		}
		return name;
	}

	// 관리자페이지의 유저정보  
	public static ArrayList<UsersTable> getInfo() throws ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		ArrayList<UsersTable> info = null;
		try {
			psmt = con.prepareStatement("select * from users");
			ResultSet rs = psmt.executeQuery();

			info = new ArrayList<UsersTable>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				String email = rs.getString("email");
				String user_id = rs.getString("user_id");
				String user_pw = rs.getString("user_pw");
				boolean isAdmin = rs.getBoolean("isAdmin");

				info.add(new UsersTable(id, name, email, user_id, user_pw, isAdmin));

			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(con);
				DBConnection.close(rs);
				DBConnection.close(psmt);
			} catch (Exception e2) {

			}
		}
		return info;
	}

// ------------------------ loginlog 테이블 관련 ----------------------------------	
	// LoginLog 테이블 관리용 - > 관리자 페이지의 로그인 기록 관리
	public static ArrayList<LoginLog> getLog() throws ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		ArrayList<LoginLog> log = null;
		
		try {
			psmt = con.prepareStatement("select * from loginlog");
			ResultSet rs = psmt.executeQuery();
			log = new ArrayList<LoginLog>();
			while (rs.next()) {
				int id = rs.getInt("id");
				String user_id = rs.getString("user_id");
				boolean login = rs.getBoolean("login");
				java.sql.Timestamp in_out_time = rs.getTimestamp("in_out_time");
			
				log.add(new LoginLog(id, user_id, login, in_out_time));
			}
			
		} catch (Exception e) {
			
		}finally {
			try {
				DBConnection.close(con);
				DBConnection.close(rs);
				DBConnection.close(psmt);
			} catch (Exception e2) {

			}
		}
		
		return log;
		
	}
	
	// 로그인 성공 시 loginlog 테이블에 insert
	public static void Login_in(String id) throws ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		try {
			psmt = con.prepareStatement("insert into loginlog (user_id) values ( ? )");
			psmt.setString(1, id);
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(psmt);
				DBConnection.close(con);
			} catch (Exception e2) {
			}
		}
	}
	
	// 채팅방 종료 시 loginlog 테이블의 longin 값 false 로 update
	public static void Login_out(String id) throws ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		try {
			
			psmt = con.prepareStatement("insert into loginlog (user_id, login) values ( ? , false )");
			psmt.setString(1, id);
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(psmt);
				DBConnection.close(con);
			} catch (Exception e2) {
			}
		}
	}
	
	// 중복 로그인 방지 -- loginlog 의 login 값의 상태를 반환 
	public static boolean LoginConnectionChk(String user_id) throws ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		
		try {
			psmt = con.prepareStatement("select login from loginlog where user_id =?"
					//  ResultSet is FORWARD_ONLY 오류로 인해 아래 추가
					, ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
			psmt.setString(1, user_id);

			rs = psmt.executeQuery();

			rs.last();
			return rs.getBoolean("login");
			// 마지막 로그인 상태 확인으로 가야하기에 isLast 사용
//			if (rs.isLast()) {
//				return rs.getBoolean("login");
//			} return false;
//			
			
		} catch (Exception e) {
			e.printStackTrace();

		} finally {
			try {
				DBConnection.close(rs);
				DBConnection.close(psmt);
				DBConnection.close(con);
			} catch (Exception e2) {

			}
		}
		return false;
		
		
		
	}


// ------------------------ chatlog 테이블 관련 ----------------------------------	
	// 전채 채팅 진행 시 Chatlog 테이블에 insert
	public static void ChatEvery(String name, String contens) throws ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		try {
			psmt = con.prepareStatement("insert into chatlog (sender, contents) values (? , ?)");
			psmt.setString(1, name);
			psmt.setString(2, contens);
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(psmt);
				DBConnection.close(con);
			} catch (Exception e2) {

			}
		}
	}
	
	// 귓말 - Chatlog 테이블에 insert
	public static void ChatWhisper (String name, String receiver, String contents) throws ClassNotFoundException {
		Connection con = DBConnection.getConnection();
		try {
			psmt = con.prepareStatement("insert into chatlog (sender, receiver, contents) values (? , ?, ?)");
			psmt.setString(1, name);
			psmt.setString(2, receiver);
			psmt.setString(3, contents);
			psmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DBConnection.close(psmt);
				DBConnection.close(con);
			} catch (Exception e2) {

			}
		}
	}
	
	// admin 페이지에서의 채팅 히스토리 - chatlog 테이블 관리용 
	public static void ChatSelect () {
		
	}
}
