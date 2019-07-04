package com.revature.services;

import com.revature.pojo.Employee;

public interface EmployeeService {
	
	public Employee loginEmployee(String username, String password);
	
	public void createEmployee(String username, String password);
	
	public Employee getAllEmployees(String username);
	
	public Employee getEmployeeByName(String username); 
	
	public Employee getEmployeebyformId(Integer formid);
	
	public Double calculatePending(Double cost, String events);
	
	public Double getPending(Integer employeeid);
	
	public void setPending(Double pending, Integer employeeid);
	
	public void setFinalPending(Double pending, Integer employeeid);
	
	public Double getAvailable(Integer employeeid);
	
	public void setAvailable(Double pending, Integer employeeid);
	
	public Double getAward(Integer employeeid);
	
	public void setAward(Integer formid);
}
