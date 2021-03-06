package com.revature.servlets;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.ReimburseForm;
import com.revature.services.ReimburseService;
import com.revature.services.ReimburseServiceImpl;

public class FormUpdateServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private ReimburseService rs = new ReimburseServiceImpl();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		if (sess == null || sess.getAttribute("employee") == null) {
			response.sendRedirect("login");
			return;
		}
		String name = request.getPathInfo();
		
		if (name == null || name.substring(1) == "") {

			
			Integer employeeid = (Integer) sess.getAttribute("employeeid");
		
			List<ReimburseForm> formList = rs.viewFormByEmployeeId(employeeid);

			String result = "";

			for (ReimburseForm r : formList) {
				result +="<i><b>form number:</i></b> " + r.getFormId() + " " + "<br>";
			}
			response.getWriter().append(result);
			return;
		}
		Integer id = Integer.parseInt(name.substring(1));
		ReimburseForm a = rs.getFormById(id);

		ObjectMapper om = new ObjectMapper();
		
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		om.setDateFormat(df);

		String formString = om.writeValueAsString(a);

		response.getWriter().write(formString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		if (sess == null || sess.getAttribute("employee") == null) {
			response.sendRedirect("login");
			return;
		}
		
		String grade = request.getParameter("grade");
		String formid = request.getParameter("formid");
		
		Integer fid =Integer.parseInt(formid);
	
		rs.updateGrade(fid, grade);
		response.sendRedirect("associate.html");
	}

}
