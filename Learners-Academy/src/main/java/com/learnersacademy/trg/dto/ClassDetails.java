package com.learnersacademy.trg.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class ClassDetails {
	@Id
	@Column(name="s_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int s_no;
	@Column(name="class_in",nullable=false)
	private String class_in;
	@Column(name="teacher",nullable=false)
	private int teacher_id;
	@Column(name="subject",nullable=false)
	private String subject;
	
	public ClassDetails() {}
	
    

	public ClassDetails(String class_in, int teacher_id, String subject) {
		super();
		this.class_in = class_in;
		this.teacher_id = teacher_id;
		this.subject = subject;
	}



	public String getClass_in() {
		return class_in;
	}



	public void setClass_in(String class_in) {
		this.class_in = class_in;
	}



	public int getTeacher_id() {
		return teacher_id;
	}



	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}



	public String getSubject() {
		return subject;
	}



	public void setSubject(String subject) {
		this.subject = subject;
	}



	@Override
	public String toString() {
		return "ClassDetails [s_no=" + s_no + ", class_in=" + class_in + ", teacher_id=" + teacher_id + ", subject="
				+ subject + "]";
	}



	

	}
