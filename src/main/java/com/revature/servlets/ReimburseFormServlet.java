package com.revature.servlets;

import java.io.IOException;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.revature.dao.ReimburseDao;
import com.revature.dao.ReimburseDaoImpl;
import com.revature.pojo.Employee;
import com.revature.pojo.ReimburseForm;
import com.revature.services.EmployeeService;
import com.revature.services.EmployeeServiceImpl;
import com.revature.services.ReimburseService;
import com.revature.services.ReimburseServiceImpl;

public class ReimburseFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReimburseDao rd = new ReimburseDaoImpl();
	private ReimburseServiceImpl rsi = new ReimburseServiceImpl();
	private ReimburseForm rf = new ReimburseForm();
	

	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		//resp.sendRedirect("reimbursement-form.html");
		resp.sendRedirect("rform.html");
	}


	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String events = req.getParameter("events");
		String address = req.getParameter("address");
		Double cost = Double.parseDouble(req.getParameter("cost"));
		String gradeFormat = req.getParameter("grade-format");
		String grade = req.getParameter("grade");
		String description = req.getParameter("description");
		Date startdate = Date.valueOf(req.getParameter("startdate"));
		Date enddate = Date.valueOf(req.getParameter("enddate"));
		String justification = req.getParameter("justification");
		
		HttpSession sess = req.getSession(false);
		ReimburseForm reimburseForm = new ReimburseForm((Integer)sess.getAttribute("employeeid"), startdate, enddate, events, address, description, cost, gradeFormat, grade, justification);
		rsi.createReimburseForm(reimburseForm);
		
		
//		HttpSession sess = req.getSession(false);
		//rd.insertForm(new ReimburseForm((Integer)sess.getAttribute("employeeid"), startdate, enddate, events, address, description, cost, gradeFormat, grade, justification));
		//rd.insertForm(new ReimburseForm(rf.getEmployeeID(), startdate, enddate, events, address, description, cost, gradeFormat, grade, justification));

	}

}