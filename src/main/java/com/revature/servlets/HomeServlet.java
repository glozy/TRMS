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

public class HomeServlet extends HttpServlet{

	private static final long serialVersionUID = 1L;
	private EmployeeService es = new EmployeeServiceImpl();


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		HttpSession sess = req.getSession(false);
		if (sess == null || sess.getAttribute("employee") == null) {
			req.getRequestDispatcher("login").forward(req, resp);
			return;
		}
		Employee employee = (Employee) sess.getAttribute("employee");
		
		String username = employee.getUsername();
		String password = employee.getPassword();
		System.out.println("username " + username + " password: " + password);

		if (employee != null) {
			//resp.setStatus(401);
			resp.getWriter().write("<h1>Welcome " + employee.getUsername() + " </h1><br><a href=\"logout\"/>logout</a>");
		} 
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws IOException, ServletException {
		doGet(req, resp);
	}
}
