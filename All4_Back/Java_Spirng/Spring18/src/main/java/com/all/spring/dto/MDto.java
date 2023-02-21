package com.all.spring.dto;

public class MDto {
	
	private String user_id;
	private String user_pw;
	private String email;
	private String user_name;
	
	private String regi_num_front;
	private String regi_num_back;
	private String user_year;
	private String user_month;
	private String user_day;
	
	
	private String interest;
	private String introduce;
	
	public MDto() {
		
	}
	
	public MDto(String user_id, String user_pw, String email, String user_name, String regi_num_front,
			String regi_num_back, String user_year, String user_month, String user_day, String interest,
			String introduce) {
		super();
		this.user_id = user_id;
		this.user_pw = user_pw;
		this.email = email;
		this.user_name = user_name;
		this.regi_num_front = regi_num_front;
		this.regi_num_back = regi_num_back;
		this.user_year = user_year;
		this.user_month = user_month;
		this.user_day = user_day;
		this.interest = interest;
		this.introduce = introduce;
	}

	private String pw_chk;

	public String getPw_chk() {
		return pw_chk;
	}

	public void setPw_chk(String pw_chk) {
		this.pw_chk = pw_chk;
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

	public String getUser_name() {
		return user_name;
	}

	public void setUser_name(String user_name) {
		this.user_name = user_name;
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

	public String getUser_year() {
		return user_year;
	}

	public void setUser_year(String user_year) {
		this.user_year = user_year;
	}

	public String getUser_month() {
		return user_month;
	}

	public void setUser_month(String user_month) {
		this.user_month = user_month;
	}

	public String getUser_day() {
		return user_day;
	}

	public void setUser_day(String user_day) {
		this.user_day = user_day;
	}

	public String getInterest() {
		return interest;
	}

	public void setInterest(String interest) {
		this.interest = interest;
	}

	public String getIntroduce() {
		return introduce;
	}

	public void setIntroduce(String introduce) {
		this.introduce = introduce;
	}
	
	
	
	
	
}
