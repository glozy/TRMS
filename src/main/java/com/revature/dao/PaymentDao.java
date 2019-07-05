package com.revature.dao;

public interface PaymentDao {
	
	public void setPending(Double pending, Integer employeeid);
	
	public void setAvailable(Double available, Integer employeeid);
	
	public Double getAvailable(Integer employeeid);
	
	public Double getPending(Integer employeeid);
	
	public Double getAward(Integer employeeid);
	
	public void setAward(Integer employeeid, Double award);
	
	public void setFinalPending(Double pending, Integer employeeid);

}
