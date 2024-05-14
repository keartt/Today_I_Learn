package join;

public class Users {
	private String user_id;
	private String user_pw;
	private String email;
	private String name;
	private String regi_num_front;
	private String regi_num_back;
	private String year;
	private String month;
	private String day;
	private String[] interest;
	private String introduce;
	
	public Users() {
		// 기본 생성자로 호출했을 때 관심사 배열 크기 5로 지정
		interest = new String[5];
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getRegi_num_front() {
		return regi_num_front;
	}
	public void setRegi_num_front(String regi_num_front) {
		this.regi_num_front = regi_num_front;
	}
	public String getRegi_num_back() {
		return regi_num_back;
	}
	public void setRegi_num_back(String regi_num_back) {
		this.regi_num_back = regi_num_back;
	}
	public String getYear() {
		return year;
	}
	public void setYear(String year) {
		this.year = year;
	}
	public String getMonth() {
		return month;
	}
	public void setMonth(String month) {
		this.month = month;
	}
	public String getDay() {
		return day;
	}
	public void setDay(String day) {
		this.day = day;
	}
	public String[] getInterest() {
		return interest;
	}
	public void setInterest(String[] interest) {
		this.interest = interest;
	}
	public String getIntroduce() {
		return introduce;
	}
	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
}
