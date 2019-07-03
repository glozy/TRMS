package com.revature.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.EmployeeDao;
import com.revature.dao.EmployeeDaoImpl;
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
		if (sess != null && sess.getAttribute("user") != null) {
			//user is logged in already
			//resp.sendRedirect("home");
			resp.sendRedirect("approve");
		} else {
			//if someone sends a get request
			resp.sendRedirect("login.html");
		}	

	}	

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		//getting form data. Gets the value of the input
		String username = req.getParameter("username"); 
		String password = req.getParameter("password");
		Employee employee = employeeService.loginEmployee(username, password);

		//EmployeeDao ed = new EmployeeDaoImpl();
		//Employee e = ed.getUserByName(username);
		Employee e = employeeService.getAllUsers(username);
		
		if (employee == null) {
			resp.setStatus(401);
			resp.getWriter().write("Failed login");
		} else {
			//using session
			HttpSession sess = req.getSession(true);
			sess.setAttribute("employee", employee);
			sess.setAttribute("employeeid", e.getEmployeeId());
			//resp.sendRedirect("home");
			//resp.sendRedirect("register.html");
			if (e.getEmployeeType().contains("associate")) {
				resp.getWriter().write("<h1>Welcome " +  e.getEmployeeType() + " </h1><br><a href=\"formfind.html\">view forms</a><br><a href=\"logout\">logout</a>");			
			} else {
				resp.getWriter().write("<h1>Welcome " +  e.getEmployeeType() + " </h1><br><a href=\"formfind.html\">view forms</a><br><a href=\"logout\">logout</a>");			
			}
		}
	}

}
