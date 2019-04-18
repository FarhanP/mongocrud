package com.mindtree.model;

public class Student 
{
	private int studentId;
	private String studentName;
	private int age;
	private String location;
	private String dateOfBirth;
//	
//	public Student(int studentId, String studentName, int age, String location, String dateOfBirth) {
//		this.studentId = studentId;
//		this.studentName = studentName;
//		this.age = age;
//		this.location = location;
//		this.dateOfBirth = dateOfBirth;
//		
//	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getDateOfBirth() {
		return dateOfBirth;
	}
	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	

}
