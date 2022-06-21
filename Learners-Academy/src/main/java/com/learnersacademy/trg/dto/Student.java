package com.learnersacademy.trg.dto;





import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


import javax.persistence.Table;

@Entity
@Table(name="Students")
public class Student {
	@Id
	@Column(name="Student_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int  student_id;
	@Column(name="student_name",nullable=false)
	private String studentname;
	@Column(name="class_in")
	private String class_in;
	
	public Student() {}
	

	public Student(String studentname, String class_in) {
		super();
		this.studentname = studentname;
		this.class_in = class_in;
	}


	public int getStudent_id() {
		return student_id;
	}


	public void setStudent_id(int student_id) {
		this.student_id = student_id;
	}


	public String getStudentname() {
		return studentname;
	}


	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}


	public String getClass_in() {
		return class_in;
	}


	public void setClass_in(String classinfo) {
		this.class_in = classinfo;
	}


	@Override
	public String toString() {
		return "Student [student_id=" + student_id + ", studentname=" + studentname + ", classinfo=" + class_in + "]";
	}

	
}
