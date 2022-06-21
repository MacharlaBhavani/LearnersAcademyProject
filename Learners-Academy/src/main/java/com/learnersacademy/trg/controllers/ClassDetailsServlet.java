package com.learnersacademy.trg.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.trg.dao.ClassDetailsDao;
import com.learnersacademy.trg.dao.ClassDetailsDaoImpl;
import com.learnersacademy.trg.dao.ClassesDao;
import com.learnersacademy.trg.dao.ClassesDaoImpl;
import com.learnersacademy.trg.dto.ClassDetails;
import com.learnersacademy.trg.dto.Classes;
import com.learnersacademy.trg.dto.Subjects;
import com.learnersacademy.trg.dto.Teachers;


@WebServlet("/ClassDetailsServlet")
public class ClassDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Class=request.getParameter("class");
	    int Teacher_id=Integer.parseInt(request.getParameter("teacher"));
		String Subject=request.getParameter("subject");
		Classes classes=new Classes();
		Teachers teacher=new Teachers();
		Subjects subjects=new Subjects();
		ClassesDao dao=new ClassesDaoImpl();
		ClassDetailsDao dao1=new ClassDetailsDaoImpl();
		
		boolean sucess=dao.validClass(Class);
		boolean sucess1=dao1.validTeacher(Teacher_id);
		boolean sucess2=dao1.validSubject(Subject);
		if(sucess&&sucess1&&sucess2) {
		
		    ClassDetails classDetails=new ClassDetails(Class,Teacher_id,Subject);
		    
		    Integer s_no=dao1.addClassDetails(classDetails);
		    if(s_no>0) {
		      response.sendRedirect("classdetailsadded.html");
		    	
		    }else {
		    	response.sendRedirect("classdetailsnotadded.html");
		    }
		
	   }else {
		   
		   response.sendRedirect("classdetailsnotadded.html");
	   }
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
