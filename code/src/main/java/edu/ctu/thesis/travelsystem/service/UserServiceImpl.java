package edu.ctu.thesis.travelsystem.service;

import edu.ctu.thesis.travelsystem.model.User;

import org.springframework.beans.factory.annotation.Autowired;

import edu.ctu.thesis.travelsystem.dao.UserDao;

public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	public void setUserDao(UserDao userDao) {
		this.userDao = userDao;
	}

	@Override
	public void saveUser(User user) {
		this.userDao.saveUser(user);
	}

	@Override
	public User loginUser(User user) {
		return this.userDao.loginUser(user);
	}

	@Override
	public Integer getRoleUser(User user) {
		return this.userDao.getRoleUser(user);
	}
}