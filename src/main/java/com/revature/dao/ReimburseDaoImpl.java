package com.revature.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

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

	

}
