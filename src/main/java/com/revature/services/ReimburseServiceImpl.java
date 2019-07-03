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
	public List<ReimburseForm> viewFormBySupervisorId(Integer id) {
		return rdi.viewFormBySupervisorId(id);
	}
	
	@Override
	public List<ReimburseForm> viewFormByBenco(Integer id) {
		return rdi.viewFormByBenco(id);
	}

	@Override
	public List<ReimburseForm> viewFormByHod(Integer id) {
		return rdi.viewFormByHod(id);
	}

	@Override
	public ReimburseForm getFormById(Integer reimburseid) {
		return rdi.getFormById(reimburseid);
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

	

}
