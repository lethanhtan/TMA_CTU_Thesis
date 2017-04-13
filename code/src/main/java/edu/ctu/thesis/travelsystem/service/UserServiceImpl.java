package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.UserDao;
import edu.ctu.thesis.travelsystem.model.BookTour;
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
	public List<User> userList() {
		return this.userDao.userList();
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

	@Override
	@Transactional
	public List<BookTour> myRegListByValue(String value, int idUser) {
		return this.userDao.myRegListByValue(value, idUser);
	}

	@Override
	@Transactional
	public List<BookTour> myRegList(int idUser) {
		return this.userDao.myRegList(idUser);
	}

	@Override
	@Transactional
	public List<BookTour> myCancelListByValue(String value, int idUser) {
		return this.userDao.myCancelListByValue(value, idUser);
	}

	@Override
	@Transactional
	public List<BookTour> myCancelList(int idUser) {
		return this.userDao.myCancelList(idUser);
	}
	
	@Override
	@Transactional
	public void undoCancel(int idBT, int relationship) {
		this.userDao.undoCancel(idBT, relationship);
	}
	
	@Override
	@Transactional
	public List<BookTour> myBookTourListByValue(String value, int idUser) {
		return this.userDao.myBookTourListByValue(value, idUser);
	}

	@Override
	@Transactional
	public List<BookTour> myBookTourList(int idUser) {
		return this.userDao.myBookTourList(idUser);
	}
}