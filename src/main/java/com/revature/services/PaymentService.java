package com.revature.services;

public interface PaymentService {
	
	public Double calculatePending(Double cost, String events);
	
	public Double getPending(Integer employeeid);
	
	public void setPending(Double pending, Integer employeeid);
	
	public void setFinalPending(Double pending, Integer employeeid);
	
	public Double getAvailable(Integer employeeid);
	
	public void setAvailable(Double pending, Integer employeeid);
	
	public Double getAward(Integer employeeid);
	
	public void setAward(Integer formid);

}
