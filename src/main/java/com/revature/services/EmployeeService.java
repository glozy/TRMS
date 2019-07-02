package com.revature.services;

import com.revature.pojo.Employee;

public interface EmployeeService {
	
	public Employee loginEmployee(String username, String password);
	
	public Employee createUser(String username, String password);
	
	public Employee getAllUsers(String username);

}
