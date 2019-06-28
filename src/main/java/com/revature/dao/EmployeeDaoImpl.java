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
		public void createEmployee(Employee u) {
			try {
				conn.setAutoCommit(false);
				String query = "insert into user_trms(username,password) values (?,?)";
				PreparedStatement pstmt = conn.prepareStatement(query);
				pstmt.setString(1, u.getUsername());
				pstmt.setString(2, u.getPassword());
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
}
