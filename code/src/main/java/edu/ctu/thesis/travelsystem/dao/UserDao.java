package edu.ctu.thesis.travelsystem.dao;

import edu.ctu.thesis.travelsystem.model.User;

public interface UserDao {
	
	public void saveUser(User user);

	public User loginUser(User user);
	
	public Integer authenticationUser(User user);
}
