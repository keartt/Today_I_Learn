package Chat03.db;

import java.security.Timestamp;

public class LoginLog {
	private int id;
	private String user_id;
	java.sql.Timestamp in_out_time;
	boolean login;
	
	
	public LoginLog(int id, String user_id, boolean login, java.sql.Timestamp in_out_time) {
		super();
		this.id = id;
		this.user_id = user_id;
		this.login = login;
		this.in_out_time = in_out_time;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public boolean isLogin() {
		return login;
	}
	public void setLogin(boolean login) {
		this.login = login;
	}
	public java.sql.Timestamp getIn_out_time() {
		return in_out_time;
	}
	public void setIn_out_time(java.sql.Timestamp in_out_time) {
		this.in_out_time = in_out_time;
	}
	
}
