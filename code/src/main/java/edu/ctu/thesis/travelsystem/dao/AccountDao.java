package edu.ctu.thesis.travelsystem.dao;

import edu.ctu.thesis.travelsystem.entity.Account;

public interface AccountDao {

	public void save(Account account);
	public void update(Account account);
	public void delete(Account account);
	
}
