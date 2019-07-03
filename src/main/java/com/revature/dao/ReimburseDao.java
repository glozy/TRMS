package com.revature.dao;

import java.util.List;

import com.revature.pojo.ReimburseForm;

public interface ReimburseDao {
	
	public void insertForm(ReimburseForm r);
	
	public ReimburseForm getFormById(Integer reimburseid);
	
	public List<ReimburseForm> viewFormBySupervisorId(Integer id);
	
	public void supervisorApproveForm (Integer formid);
	
	public void supervisorDenyForm (Integer formid);
	
}
