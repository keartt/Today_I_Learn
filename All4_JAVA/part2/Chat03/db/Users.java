package Chat03.db;

// users 테이블의 내용 가져오기 위한 클래스 
public class Users {
	private int id; 
	private String name; 
	private String email;
	private String user_id;
	private String user_pw;
	private boolean isAdmin;
	
//	생성자
	public Users(int id, String name, String email, String user_id, String user_pw, boolean isAdmin) {
	super();
	this.id = id;
	this.name = name;
	this.email = email;
	this.user_id = user_id;
	this.user_pw = user_pw;
	this.isAdmin = isAdmin;
}


	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_pw() {
		return user_pw;
	}
	public void setUser_pw(String user_pw) {
		this.user_pw = user_pw;
	}
	public boolean isAdmin() {
		return isAdmin;
	}
	public void setAdmin(boolean isAdmin) {
		this.isAdmin = isAdmin;
	}
	
}
