package edu.ctu.thesis.travelsystem.service;

import edu.ctu.thesis.travelsystem.model.User;

public interface UserService {
	
	public void saveUser(User user);

	public User loginUser(User user);
	
	public Integer getRoleUser(User user);
	
	public String findFullName(String userName);
}