package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;

public class HomeServlet extends HttpServlet{

	private EmployeeService us = new EmployeeServiceImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		String username = req.getParameter("username");
		String password = req.getParameter("password");
		System.out.println("username " + username + " password: " + password);
		Employee user = us.loginEmployee(username, password);

		if (user != null) {
			//resp.setStatus(401);
			resp.getWriter().write("<h1>Welicome " + user.getUsername() + "</h1>");
		} 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}
