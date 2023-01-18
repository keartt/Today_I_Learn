package Chat02;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// 데이터 DB 에 저장/조회 하는 클래스
public class DBRun {
	static ResultSet rs = null;
	static PreparedStatement psmt = null;

	// 중복 체크 -> 중복일 경우 false
	public static boolean duplicateCheck(String user_id) throws ClassNotFoundException {
		Connection con = DB.getConnection();
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
				DB.close(con);
				DB.close(rs);
				DB.close(psmt);
			} catch (Exception e2) {

			}
		}
		return false;
	}

	// 회원가입
	// 로그인 창에서 받은 값을 테이블에 삽입한다.
	public static void join(String name, String email, String user_id, String user_pw  ) throws ClassNotFoundException {
		Connection con = DB.getConnection();
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
				DB.close(con);
				DB.close(psmt);
			} catch (Exception e2) {

			}
		}

	}

	// 로그인 메소드
	// 아이디와 패스워드를 받는다
	// db에 저장된 값과 일치 여부를 확인한다.
	// 1 : 로그인 성공 , 2 : 비번 오류, 3: 아이디 부재, 0 : 오류
	public static int loginCheck(String user_id, String user_pw) throws ClassNotFoundException {
		Connection con = DB.getConnection();

		try {
			psmt = con.prepareStatement("select user_pw from users where user_id =?");
			psmt.setString(1, user_id);

			rs = psmt.executeQuery();
			// 아이디가 있으면
			if (rs.next()) {
				// 아이디에 해당하는 비밀번호 값을 가져와서 그게 이 메소드에 입력된 password 랑 같으면
				if (rs.getString("user_pw").equals(user_pw)) {
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
				DB.close(con);
				DB.close(rs);
				DB.close(psmt);
			} catch (Exception e2) {

			}
		}
		return 0;
	}

	// 아이디를 받아서 > 닉네임 반환
	public static String getName(String user_id) throws ClassNotFoundException {
		String name = "";
		Connection con = DB.getConnection();
		try {
			// 유저 테이블에서 아이디 가져오는 쿼리문
			psmt = con.prepareStatement("select name from users where user_id = ?");
			psmt.setString(1, user_id);
			ResultSet rs = psmt.executeQuery();

			if(rs.next()) {
				name = rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				DB.close(con);
				DB.close(rs);
				DB.close(psmt);
			} catch (Exception e2) {

			}
		}

		return name;
	}

}
