package com.learnersacademy.trg.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.trg.dao.ClassesDao;
import com.learnersacademy.trg.dao.ClassesDaoImpl;
import com.learnersacademy.trg.dao.StudentDao;
import com.learnersacademy.trg.dao.StudentDaoImpl;
import com.learnersacademy.trg.dto.Classes;
import com.learnersacademy.trg.dto.Student;

@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	 String StudentName=request.getParameter("sname");
	 String class_of=request.getParameter("class");
	 Classes classes=new Classes();
	 ClassesDao dao=new ClassesDaoImpl();
	 boolean result=dao.validClass(class_of);
	 
	 if(result) {
      Student student=new Student(StudentName,class_of);
	      StudentDao dao1= new StudentDaoImpl();
	      Integer  admission_no=dao1.addStudent(student);
	      if(admission_no>0) {
		      response.sendRedirect("studentadded.html");
	      }else {
		       response.sendRedirect("studentnotadded.html");
	      }
	  }else {
		response.sendRedirect("unvalidclass.html");
	}
	}
		
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
