package com.learnersacademy.trg.controllers;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/AdministratorServlet")
public class AdministratorServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String Name=request.getParameter("aname");
		String Password=request.getParameter("pword");
		if(Name.equals("admin")&&Password.equals("Admin@123")) {
			response.sendRedirect("validadministrator.html");
		}else {
			response.sendRedirect("invalidadministrator.html");
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
