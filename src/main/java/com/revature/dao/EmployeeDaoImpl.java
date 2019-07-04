package com.revature.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.ArrayList;

import com.revature.pojo.Employee;
import com.revature.util.ConnectionFactory;
import com.revature.util.LoggingUtil;

public class EmployeeDaoImpl implements EmployeeDao {

	private static Connection conn = ConnectionFactory.getConnection();

	@Override
	public void createEmployee(Employee em) {
		try {
			conn.setAutoCommit(false);
			String query = "insert into user_trms(username,password) values (?,?)";
			PreparedStatement pstmt = conn.prepareStatement(query);
			pstmt.setString(1, em.getUsername());
			pstmt.setString(2, em.getPassword());
			Savepoint sp = conn.setSavepoint("Before Create");
			boolean check = pstmt.execute();
			if (check) {
				conn.rollback(sp);
				LoggingUtil.error("User was not added. Rolling back");
			}
			conn.commit();
			conn.setAutoCommit(true);
			LoggingUtil.info("Creating a User");
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}


	@Override
	public ArrayList<Employee> getAllEmployees() {
		ArrayList<Employee> userList = new ArrayList<Employee>();
		String sql = "select username,password from user_trms";

		Statement stmt;
		try {
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				userList.add(new Employee(rs.getString(1), rs.getString(2)));
			}

		} catch (SQLException e) {
			LoggingUtil.error("SQLException\nFailed to get all users");
			e.printStackTrace();
		}

		return userList;
	}


	@Override
	public Employee getEmployeeByName(String username) {
		String sql = "select * from user_trms where username = '" +  username +  "'";
		Employee ret = null;
		Statement stmt;
		
		try {
			conn.setAutoCommit(false);
			stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				ret = new Employee();
			
				ret.setEmployeeId(rs.getInt("employeeid"));
				ret.setUsername((rs.getString("username")));
				ret.setPassword(rs.getString("password"));
				ret.setFirstname(rs.getString("firstname"));
				ret.setLastname(rs.getString("lastname"));
				ret.setEmail(rs.getString("email"));
				ret.setPhone(rs.getString("phone"));
				ret.setAward(rs.getDouble("award"));
				ret.setEmployeeType(rs.getString("employeetype"));
				ret.setAvailable(rs.getDouble("available"));
				ret.setAward(rs.getDouble("award"));
				ret.setPending(rs.getDouble("pending"));
			}
			
			conn.commit();
			conn.setAutoCommit(true);
		} catch(SQLException e) {
			e.printStackTrace();
		}
		
		return ret;
	}


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
	public Employee getEmployeebyformId(Integer formid) {
		Employee ret = null;
		try {
			PreparedStatement pstmt = conn.prepareStatement("select * from user_trms where employeeid in (select employeeid from reimbursement_trms where formid = ?)");
			pstmt.setInt(1, formid);
			ResultSet rs = pstmt.executeQuery();

			if (rs.next()) {
				ret = new Employee();
				ret.setEmployeeId(rs.getInt("employeeid"));
				ret.setUsername((rs.getString("username")));
				ret.setPassword(rs.getString("password"));
				ret.setFirstname(rs.getString("firstname"));
				ret.setLastname(rs.getString("lastname"));
				ret.setEmail(rs.getString("email"));
				ret.setPhone(rs.getString("phone"));
				ret.setAward(rs.getDouble("award"));
				ret.setEmployeeType(rs.getString("employeetype"));
				ret.setAvailable(rs.getDouble("available"));
				ret.setAward(rs.getDouble("award"));
				ret.setPending(rs.getDouble("pending"));
				
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
