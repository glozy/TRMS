package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.revature.util.ConnectionFactory;

public class PaymentDaoImpl implements PaymentDao {
	
	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void setPending(Double pending, Integer employeeid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update user_trms set pending = ? where employeeid = ?;");
			pstmt.setDouble(1, pending);
			pstmt.setInt(2, employeeid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setAvailable(Double available, Integer employeeid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update user_trms set available = ? where employeeid = ?");
			pstmt.setDouble(1, available);
			pstmt.setInt(2, employeeid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}


	@Override
	public Double getAvailable(Integer employeeid) {
		Double ret = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement("select available from user_trms where employeeid = ?");
			pstmt.setInt(1, employeeid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				ret = rs.getDouble("available");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Double getPending(Integer employeeid) {
		Double ret = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement("select pending from user_trms where employeeid = ?");
			pstmt.setInt(1, employeeid);
			ResultSet rs = pstmt.executeQuery();
			if (rs.next()) {
				ret = rs.getDouble("pending");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ret;
	}

	@Override
	public Double getAward(Integer employeeid) {
		Double ret = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement("select award from user_trms where employeeid = ?");
			pstmt.setInt(1, employeeid);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				ret = rs.getDouble("award");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return ret;
	}

	@Override
	public void setAward(Integer employeeid, Double award) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update user_trms set award = ? where employeeid = ?");
			pstmt.setDouble(1, award);
			pstmt.setInt(2, employeeid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void setFinalPending(Double pending, Integer employeeid) {
		try {
			PreparedStatement pstmt = conn.prepareStatement("update user_trms set pending = ? where employeeid = ?");
			pstmt.setDouble(1, pending);
			pstmt.setInt(2, employeeid);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
