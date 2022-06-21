package com.learnersacademy.trg.dao;

import java.util.List;

import com.learnersacademy.trg.dto.ClassDetails;

public interface ClassDetailsDao {
	public Integer addClassDetails(ClassDetails classDetails);
	public boolean validTeacher(int teacher);
	public boolean validSubject(String subject);
	public List<ClassDetails> classReport(String class_in);
	

}
