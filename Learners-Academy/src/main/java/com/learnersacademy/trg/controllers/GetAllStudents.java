package com.learnersacademy.trg.controllers;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.trg.dao.StudentDao;
import com.learnersacademy.trg.dao.StudentDaoImpl;
import com.learnersacademy.trg.dto.Student;

@WebServlet("/GetAllStudents")
public class GetAllStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student=new Student();
		StudentDao dao=new StudentDaoImpl();
		List<Student> allStudents= dao.findAllStudents();
		
		if(allStudents.size()>0) {
		  request.setAttribute("allStudents", allStudents);
		  RequestDispatcher dispatcher=request.getRequestDispatcher("allstudent.jsp");
		  dispatcher.forward(request, response);
		}else {
			response.sendRedirect("nostudent.html");
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
