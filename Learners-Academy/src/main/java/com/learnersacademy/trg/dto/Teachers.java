package com.learnersacademy.trg.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="teachers")
public class Teachers {
	@Id
	@Column(name="teacher_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int teacher_id;
	@Column(name="teacher_name",nullable=false)
	private String teacher_name;
	
	
	public Teachers(){}
	
	
	
	public Teachers(String teacher_name ) {
		
		this.teacher_name = teacher_name;
	   		
	}

	public int getTeacher_id() {
		return teacher_id;
	}

	public void setTeacher_id(int teacher_id) {
		this.teacher_id = teacher_id;
	}

	
	public String getTeacher_name() {
		return teacher_name;
	}
	public void setTeacher_name(String teacher_name) {
		this.teacher_name = teacher_name;
	}



	@Override
	public String toString() {
		return "Teachers [teacher_id=" + teacher_id + ", teacher_name=" + teacher_name + "]";
	}
	

	

	

}
