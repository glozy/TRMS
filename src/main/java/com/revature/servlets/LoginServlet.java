package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.pojo.Employee;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;

public class LoginServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private EmployeeService employeeService = new EmployeeServiceImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//if they already have a session, grab it else return home
		HttpSession sess = req.getSession(false);
		
		
		if (sess != null && sess.getAttribute("employee") != null) {
			String type = (String) sess.getAttribute("employeetype");
			if (type.contains("associate")) {
				resp.sendRedirect("rform.html");
			} else {
			resp.sendRedirect("formfind.html");
			}
		} else {
			resp.sendRedirect("login.html");
		}	

	}	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//getting form data. Gets the value of the input
		String username = req.getParameter("username"); 
		String password = req.getParameter("password");
		Employee employee = employeeService.loginEmployee(username, password);

		Employee e = employeeService.getAllEmployees(username);
		
		if (employee == null) {
			resp.setStatus(401);
			resp.getWriter().write("Failed login");
		} else {
			//using session
			HttpSession sess = req.getSession(true);
			sess.setAttribute("employee", employee);
			sess.setAttribute("employeeid", e.getEmployeeId());
			sess.setAttribute("employeetype", e.getEmployeeType());
			//resp.sendRedirect("home");
			//resp.sendRedirect("register.html");
			if (e.getEmployeeType().contains("BENCO")) {
				resp.getWriter().write("<h1>Welcome " +  e.getEmployeeType() + " </h1><br><a href=\"formfind.html\">view forms</a><br><a href=\"finalbencoform.html\">view final approval forms</a><br><a href=\"logout\">logout</a>");			
			} else if (e.getEmployeeType().contains("HOD")) {
				resp.getWriter().write("<h1>Welcome " +  e.getEmployeeType() + " </h1><br><a href=\"formfind.html\">view forms</a><br><a href=\"logout\">logout</a>");			
			} else if (e.getEmployeeType().contains("supervisor")) {
				resp.getWriter().write("<h1>Welcome " +  e.getEmployeeType() + " </h1><br><a href=\"formfind.html\">view forms</a><br><a href=\"logout\">logout</a>");			
			} else {
				resp.getWriter().write("<h1>Welcome " +  e.getEmployeeType() + " </h1><br><a href=\"rform.html\">view forms</a><br><a href=\"formupdate.html\">Update Forms<br><a href=\"logout\">logout</a>");			
			}
		}
	}

}
