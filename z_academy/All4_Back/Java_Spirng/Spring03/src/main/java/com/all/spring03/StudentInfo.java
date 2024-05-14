package com.all.spring03;

public class StudentInfo {
	
	private Student student;

	// 레퍼런스 참조만 되게끔
	// 생성자에서 객체 주입을 안한다.
	public StudentInfo() {
	}

	// setter 에서 객체를 대입해야 함 
	public void setStudent(Student student) {
		this.student = student;
	}
	
	public Student getStudent() {
		return student;
	}

	

}
