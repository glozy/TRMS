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
	public List<ReimburseForm> viewFormByHod(Integer id) {
		ArrayList<ReimburseForm> formList = new ArrayList<>();

		String sql = "select * from reimbursement_trms where status = 'pending-supervisor'";
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
	public List<ReimburseForm> viewFormByBenco(Integer id) {
		ArrayList<ReimburseForm> formList = new ArrayList<>();

		String sql = "select * from reimbursement_trms where status = 'pending-hod'";
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
	public ReimburseForm getFormById(Integer formid) {
		ReimburseForm ret = null;
//check
		String sql = "select * from reimbursement_trms where formid =" + formid;
		try {
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			if (rs.next()) {
				ret = new ReimburseForm(rs.getInt("formid"),rs.getInt("employeeid"), rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("form_time"),
						rs.getString("address_location"), rs.getString("description"), rs.getDouble("course_cost"), rs.getString("status"),
						rs.getString("grading_format"), rs.getString("events"), rs.getString("work_justify"), rs.getString("grade"));

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
			PreparedStatement pstmt = conn.prepareStatement("update reimbursement_trms set status = 'pending-supervisor' where formid = ?");
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

	@Override
	public void hodApproveForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update reimbursement_trms set status = 'pending-hod' where formid = ?");
			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void hodDenyForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update reimbursement_trms set status = 'denied-hod' where formid = ?");
			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void bencoApproveForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update reimbursement_trms set status = 'pending-benco' where formid = ?");
			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void bencoDenyForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update reimbursement_trms set status = 'denied-benco' where formid = ?");
			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ReimburseForm> viewFormByEmployeeId(Integer id) {
		ArrayList<ReimburseForm> formList = new ArrayList<>();

		String sql = "select * from reimbursement_trms where status = 'pending-benco' and employeeid = " + id;

		Statement stmt;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				formList.add(new ReimburseForm(rs.getInt("formid"), rs.getInt("employeeid"),
						rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("form_time"),
						rs.getString("address_location"), rs.getString("description"), rs.getDouble("course_cost"),
						rs.getString("status"), rs.getString("grading_format"), rs.getString("events"),
						rs.getString("work_justify"), rs.getString("grade")));
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
	public void updateGrade(Integer formid, String grade) {
		try {
			PreparedStatement pstmt = conn
					.prepareStatement("update reimbursement_trms set grade = ? where formid = ?");

			pstmt.setString(1, grade);
			pstmt.setInt(2, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public List<ReimburseForm> viewFinalFormByBenco(Integer employeeid) {
		ArrayList<ReimburseForm> formList = new ArrayList<>();

		String sql = "select * from reimbursement_trms where status = 'pending-benco'";

		Statement stmt;
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {
				formList.add(new ReimburseForm(rs.getInt("formid"), rs.getInt("employeeid"),
						rs.getDate("startdate"), rs.getDate("enddate"), rs.getString("form_time"),
						rs.getString("address_location"), rs.getString("description"), rs.getDouble("course_cost"),
						rs.getString("status"), rs.getString("grading_format"), rs.getString("events"),
						rs.getString("work_justify"), rs.getString("grade")));
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
	public void bencoFinalApproveForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update reimbursement_trms set status = 'approved-benco' where formid = ?");
			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void bencoFinalDenyForm(Integer formid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update reimbursement_trms set status = 'final-denied-benco' where formid = ?");
			pstmt.setInt(1, formid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
