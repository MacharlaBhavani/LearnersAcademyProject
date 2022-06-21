package com.learnersacademy.trg.dto;


import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="subjects")
public class Subjects{
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sub_id")
    private int sub_id;
    @Column(name="sub_name",unique=true,length=32,nullable=false)
    private String sub_name;
    
    public Subjects() {}

	public Subjects(String sub_name) {
		
		this.sub_name = sub_name;
	}

	public int getSub_id() {
		return sub_id;
	}

	public void setSub_id(int sub_id) {
		this.sub_id = sub_id;
	}

	public String getSub_name() {
		return sub_name;
	}

	public void setSub_name(String sub_name) {
		this.sub_name = sub_name;
	}

	@Override
	public String toString() {
		return "Subjects [sub_id=" + sub_id + ", sub_name=" + sub_name + "]";
	}
    
    
}
