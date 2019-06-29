package com.revature.services;

import javax.servlet.http.HttpSession;

import com.revature.dao.ReimburseDaoImpl;
import com.revature.pojo.ReimburseForm;

public class ReimburseServiceImpl implements ReimburseService {
	
	private static ReimburseDaoImpl rdi = new ReimburseDaoImpl();

	@Override
	public void createReimburseForm(ReimburseForm r) {
		
//		HttpSession sess = req.getSession(false);
		rdi.insertForm(r);


	}

}
