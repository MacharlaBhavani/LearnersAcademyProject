package com.learnersacademy.trg.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.learnersacademy.trg.dao.TeacherDao;
import com.learnersacademy.trg.dao.TeacherDaoImpl;
import com.learnersacademy.trg.dto.Teachers;

@WebServlet("/TeacherServlet")
public class TeacherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String TeacherName=request.getParameter("tname");
		
		Teachers  teacher=new Teachers(TeacherName);
		TeacherDao dao=new TeacherDaoImpl();
		Integer id_no=dao.addTeacher(teacher);
		if(id_no>0) {
			response.sendRedirect("teacheradded.html");
		}else {
			response.sendRedirect("teachernotadded.html");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
