package edu.ctu.thesis.travelsystem.dao;

import edu.ctu.thesis.travelsystem.model.User;

public interface UserDao {
	
	public void saveUser(User user);
	
	public void loadUser(User user);

	public User loginUser(User user);
	
	public int getRoleUser(User user);
	
	public String findFullName(String userName);
}