package com.revature.services;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.pojo.Employee;
import com.revature.util.LoggingUtil;

public class EmployeeServiceImpl implements EmployeeService {

	private static EmployeeDaoImpl edi = new EmployeeDaoImpl();

	public Employee loginEmployee(String username, String password) {
		LoggingUtil.trace("username: " + username);
		LoggingUtil.trace("password: " + password);


		Employee user = null;

		for (Employee emp : edi.getAllEmployees()) {
			if(emp.getUsername().equals(username) && emp.getPassword().equals(password)) {
				user = emp;
				break;
			}
		}
		return user;
	}

	@Override
	public void createEmployee(String username, String password) {
		LoggingUtil.trace("username: " + username);
		LoggingUtil.trace("password: " + password);
		edi.createEmployee(new Employee(username, password));

	}

	@Override
	public Employee getAllEmployees(String username) {
		return edi.getEmployeeByName(username);
	}

	@Override
	public Employee getEmployeeByName(String username) {
		return edi.getEmployeeByName(username);
	}

	@Override
	public Employee getEmployeebyformId(Integer formid) {
		return edi.getEmployeebyformId(formid);
	}

	@Override
	public Double calculatePending(Double cost, String events) {
		Double pending = null;
		switch (events) {
		case "university-courses":
			pending = 0.8 * cost;
			break;
		case "certification-prep-classes":
			pending = 0.75 * cost;
			break;
		case "certification":
			pending = cost;
			break;
		case "technical-training":
			pending = 0.9 * cost;
			break;
		case "seminars":
			pending = 0.6 * cost;
			break;
		case "others":
			pending = 0.3 * cost;
			break;
		}
		return pending;
	}

	@Override
	public Double getPending(Integer employeeid) {
		return edi.getPending(employeeid);
	}

	@Override
	public void setPending(Double pending, Integer employeeid) {
		Double newPend = pending + edi.getPending(employeeid);
		edi.setPending(newPend, employeeid);
	}

	@Override
	public void setFinalPending(Double pending, Integer employeeid) {
		edi.setFinalPending(pending, employeeid);
	}

	@Override
	public Double getAvailable(Integer employeeid) {
		return edi.getAvailable(employeeid);
	}

	@Override
	public void setAvailable(Double pending, Integer employeeid) {
		Double available;
		Double getPending = getPending(employeeid);
		Double getAward = getAward(employeeid); 
		available = 1000 - getPending - getAward;
		edi.setAvailable(available, employeeid);
	}

	@Override
	public Double getAward(Integer employeeid) {
		return edi.getAward(employeeid);
	}

	@Override
	public void setAward(Integer formid) {
		Double award = edi.getEmployeebyformId(formid).getAward();
		Double pending = edi.getEmployeebyformId(formid).getPending();
		Double available = edi.getEmployeebyformId(formid).getAvailable();
		Integer employeeid = edi.getEmployeebyformId(formid).getEmployeeId();
		if (pending >= available) {
			award += available;
		} else {
			award += pending;
		}
		Double newPending = 1000 - available - award;
		setFinalPending(newPending, employeeid);
		Double newAvailable = 1000 - award - newPending;
		edi.setAvailable(newAvailable, employeeid);
		edi.setAward(employeeid, award);
	}
}
