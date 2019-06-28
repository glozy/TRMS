package com.revature.dao;

import java.util.ArrayList;

import com.revature.pojo.Employee;

public interface EmployeeDao {
	
	public void createUser(Employee u);
	
	//public void updateCustomer(User u);
	
	//public void deleteCustomer(User u);
	
	//public User getCustomerById(Integer id);
	
	//public User getCustomerByUsername(String username);
	
	public ArrayList<Employee> getAllUser();
	
	//public ArrayList<Car> viewCars(String userName);

	//void preparedUpdateCustomer(Customer c);
}
