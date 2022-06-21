package com.learnersacademy.trg.dao;


import java.util.List;


import com.learnersacademy.trg.dto.Student;

public interface StudentDao {
	public Integer addStudent(Student student);
	public List<Student> findAllStudents();
    public  List<Student> specific(String class_in);
}
