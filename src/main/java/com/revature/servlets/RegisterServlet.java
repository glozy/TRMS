package com.revature.servlets;

import java.io.IOException;
import java.rmi.ServerException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.revature.pojo.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;

public class RegisterServlet extends HttpServlet{
	
	private static final long serialVersionUID = 1L;
	private EmployeeService es = new EmployeeServiceImpl();
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServerException, IOException {
		//if someone sends a get request
		resp.sendRedirect("register.html");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//getting form data. Gets the value of the input
		String username = req.getParameter("username"); 
		String password = req.getParameter("password");
		
		if (username  == null || password == null) {
			resp.setStatus(401);
			resp.getWriter().write("Failed registration");
		} else {
			resp.getWriter().write("Successful registration");
			//req.getRequestDispatcher("home").forward(req, resp);
		}
		es.createEmployee(username, password);
		resp.sendRedirect("login.html");
//		if (user == null) {
//			resp.setStatus(401);
//			resp.getWriter().write("Failed registration");
//		} else {
//			resp.getWriter().write("Successful registration");
//			//req.getRequestDispatcher("home").forward(req, resp);
//		}
	}

}
