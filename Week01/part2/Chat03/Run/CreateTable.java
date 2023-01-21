package Chat03.Run;

import java.sql.Connection;
import java.sql.SQLException;

import Chat03.db.DBConnection;
/* Database Table 생성하는 클래스
   로컬에 DB 가 없을경우 서버 실행 전 본 코드 실행 필수  */
public class CreateTable {

	public static void main(String[] args) throws ClassNotFoundException {
		Connection con = null;
		try {
			con = DBConnection.getConnection();
			String usersTable = "create table users ("
					+ "    id serial primary key,"
					+ "   email varchar(50) default 'no-email',"
					+ "    name varchar(20) not null,"
					+ "   user_id varchar(50) not null unique,"
					+ "   user_pw varchar(50) not null,"
					+ "   isAdmin boolean default false);"
					// 관리자 2명 추가 
					+ "insert into users (name, user_id, user_pw, isAdmin) "
					+ "values ('관리자', 'admin', 'admin', true);"
					+ "insert into users (name, user_id, user_pw, isAdmin) "
					+ "values ('관리자2', 'ADMIN', 'ADMIN', true);";
			
			String loginlogTable = "create table loginlog ("
					+ "   id serial primary key,"
					+ "   user_id varchar(50) references users(user_id) not null,"
					+ "   login boolean default true,"
					+ "   in_out_time timestamp DEFAULT CURRENT_TIMESTAMP not null);";
			
			String chatlogTable = "create table chatlog("
					+ "   id serial primary key,"
					+ "   sender varchar(50) references users(user_id) not null,"
					+ "   receiver varchar(50) default 'all',"
					+ "   contents varchar(200),"
					+ "   created_at timestamp DEFAULT CURRENT_TIMESTAMP not null);";
			
			con.createStatement().execute(usersTable);
			con.createStatement().execute(loginlogTable);
			con.createStatement().execute(chatlogTable);
			System.out.println("테이블 생성 성공 ");
			
		} catch (SQLException e) {
			System.out.println("테이블 이미 존재");
		}finally {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
