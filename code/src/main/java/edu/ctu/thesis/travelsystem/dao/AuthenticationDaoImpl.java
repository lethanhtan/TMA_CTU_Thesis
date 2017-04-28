package edu.ctu.thesis.travelsystem.dao;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.service.AdminUriService;

@Service
public class AuthenticationDaoImpl implements AuthenticationDao {
	
	private static final Logger logger = Logger.getLogger(AuthenticationDaoImpl.class);

	@Autowired
	AdminUriService adminUriService;

	@Override
	public boolean authenticationUser(String uri, int idRole) {
		logger.info("Authentication id role: " + idRole);
		boolean authen = false;
		if (idRole == 1 || idRole == 0) {
			logger.info("Authentication for none admin role: " + idRole);
			if (adminUriService.findUri(uri)) {
				authen = false;
			} else {
				authen = true;
			}
		} else if (idRole == 2) {
			logger.info("Authentication for admin role: " + idRole);
		}

		return authen;
	}

}
