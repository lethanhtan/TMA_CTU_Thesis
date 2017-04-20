package edu.ctu.thesis.travelsystem.dao;

import edu.ctu.thesis.travelsystem.model.Email;

public interface EmailDao {
	
	public void saveEmail(Email email);
	
	public void deleteEmail(int id);
	
	public boolean getEmailStatus(int id);
	
}
