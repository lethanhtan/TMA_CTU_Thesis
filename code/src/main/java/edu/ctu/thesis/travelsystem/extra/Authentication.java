package edu.ctu.thesis.travelsystem.extra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.service.AdminUriService;

@Service
public class Authentication {
	
	@Autowired
	AdminUriService adminUriService;
	
	public boolean authenticationUser(String uri, int idRole) {
		boolean authen = false;
		if (idRole == 1) {
			authen = adminUriService.findUri(uri);
		}
		else if (idRole == 2) {
			authen = true;
		}
		
		return authen;
	}
}
