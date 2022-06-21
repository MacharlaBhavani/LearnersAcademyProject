package com.learnersacademy.trg.controllers;

import java.io.IOException;
import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.trg.dao.ClassDetailsDao;
import com.learnersacademy.trg.dao.ClassDetailsDaoImpl;
import com.learnersacademy.trg.dao.StudentDao;
import com.learnersacademy.trg.dao.StudentDaoImpl;
import com.learnersacademy.trg.dto.ClassDetails;
import com.learnersacademy.trg.dto.Student;


@WebServlet("/ClassReport")
public class ClassReport extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Class_in=request.getParameter("class");
		StudentDao dao1=new StudentDaoImpl();
       List<Student> list=dao1.specific(Class_in);
       System.out.println(list);
       ClassDetailsDao dao=new ClassDetailsDaoImpl();
       List<ClassDetails> list1=dao.classReport(Class_in);
       System.out.println(list1);
       if(list.size()>0 && list1.size()>0) {
    	   request.setAttribute("list", list);
    	   RequestDispatcher dispatcher=request.getRequestDispatcher("classreportjsp.jsp");
    	  
    	   request.setAttribute("list1", list1);
           RequestDispatcher dispatcher1=request.getRequestDispatcher("classreportjsp.jsp");
           dispatcher1.include(request, response);
           dispatcher.forward(request, response);
       	  
    	          
       }else {
    	   response.sendRedirect("classreportempty.html");
       }
	  

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
