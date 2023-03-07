package com.all.test.member.dto;

public class MemberDto {
	private String member_id;
	private String member_pw;
	private String member_name;
	private String member_email;
	private String member_pnumber;
	private String member_favorite;
	private String member_introduce;
	private String member_year;
	private String member_month;
	private String member_day;
	private String member_address;
	private String member_postcode;
	
	public MemberDto() {
	}
	
	public MemberDto(String member_id, String member_pw, String member_name, String member_email, String member_pnumber,
			String member_favorite, String member_introduce, String member_year, String member_month, String member_day,
			String member_address, String member_postcode) {
		super();
		this.member_id = member_id;
		this.member_pw = member_pw;
		this.member_name = member_name;
		this.member_email = member_email;
		this.member_pnumber = member_pnumber;
		this.member_favorite = member_favorite;
		this.member_introduce = member_introduce;
		this.member_year = member_year;
		this.member_month = member_month;
		this.member_day = member_day;
		this.member_address = member_address;
		this.member_postcode = member_postcode;
	}
	
	public String getMember_id() {
		return member_id;
	}
	public void setMember_id(String member_id) {
		this.member_id = member_id;
	}
	public String getMember_pw() {
		return member_pw;
	}
	public void setMember_pw(String member_pw) {
		this.member_pw = member_pw;
	}
	public String getMember_name() {
		return member_name;
	}
	public void setMember_name(String member_name) {
		this.member_name = member_name;
	}
	public String getMember_email() {
		return member_email;
	}
	public void setMember_email(String member_email) {
		this.member_email = member_email;
	}
	public String getMember_pnumber() {
		return member_pnumber;
	}
	public void setMember_pnumber(String member_pnumber) {
		this.member_pnumber = member_pnumber;
	}
	public String getMember_favorite() {
		return member_favorite;
	}
	public void setMember_favorite(String member_favorite) {
		this.member_favorite = member_favorite;
	}
	public String getMember_introduce() {
		return member_introduce;
	}
	public void setMember_introduce(String member_introduce) {
		this.member_introduce = member_introduce;
	}
	public String getMember_year() {
		return member_year;
	}
	public void setMember_year(String member_year) {
		this.member_year = member_year;
	}
	public String getMember_month() {
		return member_month;
	}
	public void setMember_month(String member_month) {
		this.member_month = member_month;
	}
	public String getMember_day() {
		return member_day;
	}
	public void setMember_day(String member_day) {
		this.member_day = member_day;
	}
	public String getMember_address() {
		return member_address;
	}
	public void setMember_address(String member_address) {
		this.member_address = member_address;
	}
	public String getMember_postcode() {
		return member_postcode;
	}
	public void setMember_postcode(String member_postcode) {
		this.member_postcode = member_postcode;
	}
}
