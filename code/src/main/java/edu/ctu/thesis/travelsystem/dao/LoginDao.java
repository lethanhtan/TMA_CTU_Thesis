package edu.ctu.thesis.travelsystem.dao;

import edu.ctu.thesis.travelsystem.entity.Account;

public interface LoginDao {

	public void save(Account account);
	public void update(Account account);
	public void delete(Account account);
	
	public boolean checkLogin(String idAcc, String passAcc);
	
}
