package com.revature.servlets;

import javax.servlet.http.HttpServlet;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.pojo.ReimburseForm;
import com.revature.services.ReimburseService;
import com.revature.services.ReimburseServiceImpl;
import com.revature.util.LoggingUtil;

public class ApproveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ReimburseService rs = new ReimburseServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		if (sess == null || sess.getAttribute("employee") == null) {
			response.sendRedirect("login");
			return;
		}
		String name = request.getPathInfo();
		String type = (String) sess.getAttribute("employeetype");
		
		
		if (name == null || name.substring(1) == "") {
			List<ReimburseForm> formList = null;
			Integer userid = (Integer) sess.getAttribute("employeeid");
			switch(type) {
			case "BENCO" :
				formList = rs.viewFormByBenco(userid);
				break;
			case "HOD" :
				formList = rs.viewFormByHod(userid);
				break;
			case "supervisor" :
				formList = rs.viewFormBySupervisorId(userid);
				break;
			}

			String result = "";

			for (ReimburseForm r : formList) {
				result +="form number: " + r.getFormId() + " ";
			}
			response.getWriter().append(result);
			return;
		}
		
		System.out.println(name.substring(1));
		Integer id = Integer.parseInt(name.substring(1));
		ReimburseForm a = rs.getFormById(id);

		
		ObjectMapper om = new ObjectMapper();
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		om.setDateFormat(df);
		String formString = om.writeValueAsString(a);
		response.getWriter().write(formString);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession sess = request.getSession(false);
		if (sess == null || sess.getAttribute("employee") == null) {
			response.sendRedirect("login");
			return;
		}
		String type = (String) sess.getAttribute("employeetype");
		
		String approve = "approve";
		
		String formid = request.getParameter("formid");
		Integer fid = Integer.parseInt(formid);
		
		String status = request.getParameter("status");
		
		if (status.equals(approve)) {
			switch(type) {
			case "BENCO" :
				rs.bencoApproveForm(fid);
				response.getWriter().write("Form approved");
				LoggingUtil.info("BENCO approved form");
				break;
			case "HOD" :
				rs.hodApproveForm(fid);
				response.getWriter().write("Form approved");
				LoggingUtil.info("HOD approved form");
				break;
			case "supervisor" :
				rs.supervisorApproveForm(fid);
				response.getWriter().write("Form approved");
				LoggingUtil.info("supervisor approved form");
				break;
			}
		} else {
			switch(type) {
			case "BENCO" :
				rs.bencoDenyForm(fid);
				response.getWriter().write("Form denied");
				LoggingUtil.info("BENCO denied form");
				break;
			case "HOD" :
				rs.hodDenyForm(fid);
				response.getWriter().write("Form denied");
				LoggingUtil.info("HOD denied form");
				break;
			case "supervisor" :
				rs.supervisorDenyForm(fid);
				response.getWriter().write("Form denied");
				LoggingUtil.info("supervisor denied form");
				break;
			}
		}
		
//		if (status.equals(ap)) {
//			rs.supervisorApproveForm(fid);
//			response.getWriter().write("Form approved");
//			LoggingUtil.info("Form approved");
//		} else {
//			rs.supervisorDenyForm(fid);
//			response.getWriter().write("Form denied");
//			LoggingUtil.info("Form denied");
//		}
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
//		String name = request.getPathInfo();
//		System.out.println(name.substring(1));
	//	Integer id = Integer.parseInt(name.substring(1));
		//ReimburseForm a = rd.getFormById(id);
		
		//updateForm(a);
		
		
		
//		String body = request.getReader().readLine();
//		System.out.println(body);
	//	ObjectMapper om = new ObjectMapper();
	//	Animal a = om.readValue(body, Animal.class);
	//	a.setOwner((User)sess.getAttribute("user"));
	//	as.createAnimal(a);
	//	response.getWriter().write("Animal successfuly created");
	}



}
