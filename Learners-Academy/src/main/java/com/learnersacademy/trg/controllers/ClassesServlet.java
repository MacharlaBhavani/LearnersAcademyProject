package com.learnersacademy.trg.controllers;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.trg.dao.ClassesDao;
import com.learnersacademy.trg.dao.ClassesDaoImpl;
import com.learnersacademy.trg.dto.Classes;

@WebServlet("/ClassesServlet")
public class ClassesServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Class=request.getParameter("class");
   		ClassesDao dao1=new ClassesDaoImpl();
		boolean sucess=dao1.validClass(Class);
		if(!sucess) {
			  Classes classes=new Classes(Class);
			  ClassesDao dao=new ClassesDaoImpl();
			  Integer s_no=dao.addClasses(classes);
		   if(s_no>0) {
			   response.sendRedirect("classadded.html");
		    }
		}else {
			   response.sendRedirect("classnotadded.html");
	}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
