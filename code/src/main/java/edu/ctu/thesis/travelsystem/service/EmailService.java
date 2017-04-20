package edu.ctu.thesis.travelsystem.service;

import edu.ctu.thesis.travelsystem.model.Email;

public interface EmailService {

	public void saveEmail(Email email);
	
	public void deleteEmail(int id);
	
	public boolean getEmailStatus(int id);
	
}
