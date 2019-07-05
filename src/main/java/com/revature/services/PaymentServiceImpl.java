package com.revature.services;

import com.revature.dao.EmployeeDaoImpl;
import com.revature.dao.PaymentDaoImpl;

public class PaymentServiceImpl implements PaymentService {
	
	private PaymentDaoImpl pdi = new PaymentDaoImpl();
	private EmployeeDaoImpl edi = new EmployeeDaoImpl();

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
		return pdi.getPending(employeeid);
	}

	@Override
	public void setPending(Double pending, Integer employeeid) {
		Double newPend = pending + pdi.getPending(employeeid);
		pdi.setPending(newPend, employeeid);
	}

	@Override
	public void setFinalPending(Double pending, Integer employeeid) {
		pdi.setFinalPending(pending, employeeid);
	}

	@Override
	public Double getAvailable(Integer employeeid) {
		return pdi.getAvailable(employeeid);
	}

	@Override
	public void setAvailable(Double pending, Integer employeeid) {
		Double available;
		Double getPending = getPending(employeeid);
		Double getAward = getAward(employeeid); 
		available = 1000 - getPending - getAward;
		pdi.setAvailable(available, employeeid);
	}

	@Override
	public Double getAward(Integer employeeid) {
		return pdi.getAward(employeeid);
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
		pdi.setAvailable(newAvailable, employeeid);
		pdi.setAward(employeeid, award);
	}
}
