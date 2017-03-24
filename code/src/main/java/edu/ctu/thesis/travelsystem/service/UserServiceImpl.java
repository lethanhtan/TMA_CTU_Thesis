package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.UserDao;
import edu.ctu.thesis.travelsystem.model.User;

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
	public int getRoleUser(User user) {
		return this.userDao.getRoleUser(user);
	}
	
	@Override
	public String findFullName(String userName) {
		return this.userDao.findFullName(userName);
	}
	
	@Override
	@Transactional
	public List<User> userListByValue(String value) {
		return this.userDao.userListByValue(value);
	}

	@Override
	@Transactional
	public int getNumUserByValue(String value) {
		return this.userDao.getNumUserByValue(value);
	}
	
	@Override
	@Transactional
	public List<User> userList() {
		return this.userDao.userList();
	}
	
	@Override
	@Transactional
	public int getNumUser() {
		return this.userDao.getNumUser();
	}
	
	@Override
	@Transactional
	public User searchUserById(int idUser) {
		return this.userDao.searchUserById(idUser);
	}
	
	@Override
	@Transactional
	public void deleteUser(int idUser) {
		this.userDao.deleteUser(idUser);
	}
	
	@Override
	@Transactional
	public void editUser(User user) {
		this.userDao.editUser(user);
	}
}