package com.learnersacademy.trg.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.trg.dao.ClassDetailsDao;
import com.learnersacademy.trg.dao.ClassDetailsDaoImpl;
import com.learnersacademy.trg.dao.SubjectsDao;
import com.learnersacademy.trg.dao.SubjectsDaoImpl;
import com.learnersacademy.trg.dto.Subjects;


@WebServlet("/AddSubject")
public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Subject=request.getParameter("subject");
		ClassDetailsDao dao1=new ClassDetailsDaoImpl();
		boolean sucess=dao1.validSubject(Subject);
		if(!sucess){
			
			Subjects subjects=new Subjects(Subject);
    		SubjectsDao dao=new SubjectsDaoImpl();
    		Integer sub_id=dao.addSubject(subjects);
					
	    	if(sub_id>0) {
	    		
		     	response.sendRedirect("subjectadded.html");
		  }
		}else {
			response.sendRedirect("subjectnotadded.html");
	}
}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
