package com.learnersacademy.trg.dto;

import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javax.persistence.Table;


@Entity
@Table(name="classes")
public class Classes {
	@Id
	@Column(name="s_no")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int s_no;
	@Column(name="classof",unique=true,length=32,nullable=false)
	private String classof;
	
	public Classes() {}
	
	public Classes(String classinfo) {
		this.classof = classinfo;
	}
	public int getSno() {
		return s_no;
	}
	public void setSno(int sno) {
		this.s_no = sno;
	}
	public String getClassinfo() {
		return classof;
	}
	
	public Classes(int s_no, String classinfo) {
		super();
		this.s_no = s_no;
		this.classof = classinfo;
	}
	@Override
	public String toString() {
		return "Classes [sno=" + s_no + ", classinfo=" + classof + "]";
	}
		
   
   		    
    
}
