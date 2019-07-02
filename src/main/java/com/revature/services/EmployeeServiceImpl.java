package com.revature.services;



import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojo.Employee;
import com.revature.util.LoggingUtil;

public class EmployeeServiceImpl implements EmployeeService {

	
	private static EmployeeDaoImpl udi = new EmployeeDaoImpl();

	public Employee loginEmployee(String username, String password) {
		LoggingUtil.trace("username: " + username);
		LoggingUtil.trace("password: " + password);


		Employee user = null;

		for (Employee check : udi.getAllEmployees()) {
			if(check.getUsername().equals(username) && check.getPassword().equals(password)) {
				user = check;
				break;
			}
		}
		return user;
	}

	@Override
	public Employee createUser(String username, String password) {
		System.out.println("username: " + username);
		System.out.println("password: " + password);
		//User user = null;
		
		 udi.createEmployee(new Employee(username, password));
		//return user;
		return null;

	}

	@Override
	public Employee getAllUsers(String username) {
		return udi.getUserByName(username);
	}



}
