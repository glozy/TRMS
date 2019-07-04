package com.revature.dao;

import java.util.List;

import com.revature.pojo.ReimburseForm;

public interface ReimburseDao {
	
	public void insertForm(ReimburseForm r);
	
	public ReimburseForm getFormById(Integer formid);
	
	public List<ReimburseForm> viewFormBySupervisorId(Integer id);
	
	public List<ReimburseForm> viewFormByBenco(Integer id);
	
	public List<ReimburseForm> viewFormByHod(Integer id);
	
	public void supervisorApproveForm (Integer formid);
	
	public void supervisorDenyForm (Integer formid);
	
	public void hodApproveForm (Integer formid);
	
	public void hodDenyForm (Integer formid);
	
	public void bencoApproveForm (Integer formid);
	
	public void bencoDenyForm (Integer formid);
	
	public List<ReimburseForm> viewFormByEmployeeId(Integer id);
	
	public void updateGrade(Integer formid, String grade);
	
	public List<ReimburseForm> viewFinalFormByBenco(Integer id);
	
	public void bencoFinalApproveForm (Integer formid);
	
	public void bencoFinalDenyForm (Integer formid);
}
