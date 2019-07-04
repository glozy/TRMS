package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojo.Employee;

public interface EmployeeDao {
	
	public void createEmployee(Employee em);
	
	public Employee getEmployeeByName(String username);
	
	public ArrayList<Employee> getAllEmployees();
	
	public void setPending(Double pending, Integer employeeid);
	
	public void setAvailable(Double available, Integer employeeid);
	
	public Double getAvailable(Integer employeeid);
	
	public Double getPending(Integer employeeid);
	
	public Double getAward(Integer employeeid);
	
	public Employee getEmployeebyformId(Integer formid);
	
	public void setAward(Integer employeeid, Double award);
	
	public void setFinalPending(Double pending, Integer employeeid);
	
}
