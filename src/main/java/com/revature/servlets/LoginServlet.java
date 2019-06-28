package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojo.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;

public class LoginServlet extends HttpServlet{

	private EmployeeService userService = new EmployeeServiceImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//if someone sends a get request
		resp.sendRedirect("login.html");
		
	}	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//getting form data. Gets the value of the input
		String username = req.getParameter("username"); 
		String password = req.getParameter("password");
		Employee user = userService.loginEmployee(username, password);

		if (user == null) {
			resp.setStatus(401);
			resp.getWriter().write("Failed login");
		} else {
			resp.getWriter().write("Successful Login");
			//req.getRequestDispatcher("home").forward(req, resp);
			resp.sendRedirect("register.html");
		}
	}

}
