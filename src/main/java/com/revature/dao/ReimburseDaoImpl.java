package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.revature.pojo.ReimburseForm;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class ReimburseDaoImpl implements ReimburseDao {
	
	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void insertForm(ReimburseForm r) {
		try {
			conn.setAutoCommit(false);
			String query = "insert into reimbursement_trms(address_location,"
					+ "description,course_cost,grading_format,events,startdate, enddate, employeeid) values"
					+ "(?,?,?,?,?,?,?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
		
			pstmt.setString(1, r.getAddress());
			pstmt.setString(2, r.getDescription());
			pstmt.setDouble(3, r.getCourse_cost());
			pstmt.setString(4, r.getGrading_format());
			pstmt.setString(5, r.getEvents());
			pstmt.setDate(6, (Date) r.getStartDate());
			pstmt.setDate(7, (Date) r.getEndDate());
			pstmt.setInt(8, r.getEmployeeID());

			pstmt.execute();
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Submitted a form");
		} catch (SQLException e) {
			LoggingUtil.info("SQLException");
			e.printStackTrace();
		}

	}
	
	@Override
	public List<ReimburseForm> viewFormBySupervisorId(Integer id) {
		ArrayList<ReimburseForm> formList = new ArrayList<>();
		
		String sql = "select * from reimbursement_trms where status = 'pending'";
		Statement stmt;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				formList.add(new ReimburseForm(rs.getInt("formid"),rs.getInt("employeeid"), rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("form_time"),
						rs.getString("address_location"), rs.getString("description"), rs.getDouble("course_cost"), rs.getString("status"),
						rs.getString("grading_format"), rs.getString("events"), rs.getString("work_justify")));
			}
			conn.commit();
			conn.setAutoCommit(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return formList;
	}
	
	@Override
	public ReimburseForm getFormById(Integer reimburseid) {
		ReimburseForm ret = null;

		String sql = "select * from reimbursement_trms where formid =" + reimburseid;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				ret = new ReimburseForm(rs.getInt("formid"),rs.getInt("employeeid"), rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("form_time"),
						rs.getString("address_location"), rs.getString("description"), rs.getDouble("course_cost"), rs.getString("status"),
						rs.getString("grading_format"), rs.getString("events"), rs.getString("work_justify"));


			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}
	
	@Override
	public void supervisorApproveForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update reimbursement_trms set status = 'pending-head' where formid = ?");
			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	@Override
	public void supervisorDenyForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update reimbursement_trms set status = 'denied-supervisor' where formid = ?");
			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
//	public static void main(String[] args) {
//		ReimburseDao rd = new ReimburseDaoImpl();
//		System.out.println(rd.viewFormBySupervisorId(1));
//		System.out.println(rd.getFormById(1));
//		rd.supervisorApproveForm(1);
//	}

	

}
