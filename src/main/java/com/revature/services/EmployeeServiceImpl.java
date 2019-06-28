package com.revature.services;

import java.util.ArrayList;
import java.util.List;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojo.Employee;
import com.revature.util.LoggingUtil;

public class EmployeeServiceImpl implements EmployeeService {

	private List<Employee> userDao;
	private static EmployeeDaoImpl udi = new EmployeeDaoImpl();

	public Employee loginEmployee(String username, String password) {
		LoggingUtil.trace("username: " + username);
		LoggingUtil.trace("password: " + password);
		//System.out.println("username: " + username);
		//System.out.println("password: " + password);

		Employee user = null;

		//for (User check : userDao) {
		//System.out.println(udi.getAllUser());
		for (Employee check : udi.getAllEmployees()) {
			if(check.getUsername().equals(username) && check.getPassword().equals(password)) {
				user = check;
				break;
			}
		}
		return user;
	}

	public EmployeeServiceImpl() {
		userDao = new ArrayList<Employee>();
		userDao.add(new Employee("mah", "123", "mohamad"));
		userDao.add(new Employee("dinosaur", "dev123", "donald"));
		//System.out.println(userDao);
		//List<User> u = new ArrayList<User>();
		//u = cdi.getAllUser();
		//System.out.println(u);
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



}
