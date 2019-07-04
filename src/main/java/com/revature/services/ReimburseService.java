package com.revature.services;

import java.util.List;

import com.revature.pojo.ReimburseForm;

public interface ReimburseService {
	
	public void createReimburseForm(ReimburseForm r);
	
	public List<ReimburseForm> viewFormBySupervisorId(Integer employeeid);
	
	public List<ReimburseForm> viewFormByBenco(Integer employeeid);
	
	public List<ReimburseForm> viewFormByHod(Integer employeeid);
	
	public List<ReimburseForm> viewFormByEmployeeId(Integer employeeid);
	
	public List<ReimburseForm> viewFinalFormByBenco(Integer employeeid);
	
	public ReimburseForm getFormById(Integer formid);
	
	public void supervisorApproveForm(Integer formid);
	
	public void supervisorDenyForm(Integer formid);
	
	public void hodApproveForm(Integer formid);
	
	public void hodDenyForm(Integer formid);
	
	public void bencoApproveForm(Integer formid);
	
	public void bencoDenyForm(Integer formid);

	public void updateGrade(Integer formid, String grade);
	
	public void bencoFinalApproveForm(Integer formid);
	
	public void bencoFinalDenyForm(Integer formid);
	
}
