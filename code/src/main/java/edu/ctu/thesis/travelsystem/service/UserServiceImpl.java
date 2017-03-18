package edu.ctu.thesis.travelsystem.service;

import edu.ctu.thesis.travelsystem.model.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.UserDao;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserDao userDao;
	
	@Override
	@Transactional
	public void saveUser(User user) {
		this.userDao.saveUser(user);
	}

	@Override
	@Transactional
	public User loginUser(User user) {
		return this.userDao.loginUser(user);
	}

	@Override
	@Transactional
	public Integer getRoleUser(User user) {
		return this.userDao.getRoleUser(user);
	}

	@Override
	public String findFullName(String userName) {
		return this.userDao.findFullName(userName);
	}
}