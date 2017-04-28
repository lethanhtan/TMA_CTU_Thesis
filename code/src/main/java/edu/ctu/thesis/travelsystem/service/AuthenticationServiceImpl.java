package edu.ctu.thesis.travelsystem.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.dao.AuthenticationDao;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {
	
	@Autowired
	AuthenticationDao authenticationDao;

	@Override
	public boolean authenticationUser(String uri, int idRole) {
		return this.authenticationDao.authenticationUser(uri, idRole);
	}

}
