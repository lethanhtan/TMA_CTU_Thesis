package edu.ctu.thesis.travelsystem.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.dao.LoginDao;
import edu.ctu.thesis.travelsystem.service.LoginService;

//@Service("loginService")
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private LoginDao loginDao;
	
	public void setLoginDao(LoginDao loginDao) {
		this.loginDao = loginDao;
	}

	@Override
	public boolean checkLogin(String idAcc, String passAcc) {
		System.out.println("In service class... Check login");
		
		return loginDao.checkLogin(idAcc, passAcc);
	}

}
