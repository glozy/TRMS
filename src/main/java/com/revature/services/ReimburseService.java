package com.revature.services;

import java.util.List;

import com.revature.pojo.ReimburseForm;

public interface ReimburseService {
	
	public void createReimburseForm(ReimburseForm r);
	
	public List<ReimburseForm> viewFormBySupervisorId(Integer id);
	
	public ReimburseForm getFormById(Integer reimburseid);
	
	public void supervisorApproveForm(Integer formid);
	
	public void supervisorDenyForm(Integer formid);
	
	public void hodApproveForm(Integer formid);
	
	public void hodDenyForm(Integer formid);
	
	public void bencoApproveForm(Integer formid);
	
	public void bencoDenyForm(Integer formid);

}
