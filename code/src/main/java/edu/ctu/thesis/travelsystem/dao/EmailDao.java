package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.Email;

public interface EmailDao {
	
	public void saveEmail(Email email);
	
	public void deleteEmail(int id);
	
	public boolean getEmailStatus(int id);
	
	public List<Email> listMail();
	
	public List<Email> listMailByStaus(boolean status);
}
