package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.User;

public interface UserService {

	public void saveUser(User user);

	public User loginUser(User user);

	public int getRoleUser(User user);

	public String findFullName(String userName);

	public List<User> userListByValue(String value);

	public int getNumUserByValue(String value);
	
	public List<User> userList();
	
	public int getNumUser();
	
	public User searchUserById(int idUser);
	
	public void deleteUser(int idUser);
	
	public void editUser(User user);
}