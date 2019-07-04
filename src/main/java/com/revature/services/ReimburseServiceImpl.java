package com.revature.services;

import java.util.List;

import com.revature.dao.ReimburseDaoImpl;
import com.revature.pojo.ReimburseForm;

public class ReimburseServiceImpl implements ReimburseService {
	
	private static ReimburseDaoImpl rdi = new ReimburseDaoImpl();

	@Override
	public void createReimburseForm(ReimburseForm r) {
		rdi.insertForm(r);
	}

	@Override
	public List<ReimburseForm> viewFormBySupervisorId(Integer employeeid) {
		return rdi.viewFormBySupervisorId(employeeid);
	}
	
	@Override
	public List<ReimburseForm> viewFormByBenco(Integer employeeid) {
		return rdi.viewFormByBenco(employeeid);
	}

	@Override
	public List<ReimburseForm> viewFormByHod(Integer employeeid) {
		return rdi.viewFormByHod(employeeid);
	}

	@Override
	public ReimburseForm getFormById(Integer formid) {
		return rdi.getFormById(formid);
	}

	@Override
	public void supervisorApproveForm(Integer formid) {
		rdi.supervisorApproveForm(formid);
	}

	@Override
	public void supervisorDenyForm(Integer formid) {
		rdi.supervisorDenyForm(formid);
	}

	@Override
	public void hodApproveForm(Integer formid) {
		rdi.hodApproveForm(formid);
	}

	@Override
	public void hodDenyForm(Integer formid) {
		rdi.hodDenyForm(formid);
	}

	@Override
	public void bencoApproveForm(Integer formid) {
		rdi.bencoApproveForm(formid);
	}

	@Override
	public void bencoDenyForm(Integer formid) {
		rdi.bencoDenyForm(formid);
	}

	@Override
	public List<ReimburseForm> viewFormByEmployeeId(Integer employeeid) {
		return rdi.viewFormByEmployeeId(employeeid);
	}

	@Override
	public List<ReimburseForm> viewFinalFormByBenco(Integer employeeid) {
		return rdi.viewFinalFormByBenco(employeeid);
	}

	@Override
	public void updateGrade(Integer formid, String grade) {
		rdi.updateGrade(formid, grade);
	}

	@Override
	public void bencoFinalApproveForm(Integer formid) {
		rdi.bencoFinalApproveForm(formid);
	}

	@Override
	public void bencoFinalDenyForm(Integer formid) {
		rdi.bencoFinalDenyForm(formid);
	}

}
