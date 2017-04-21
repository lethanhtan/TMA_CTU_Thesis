package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.User;

public interface UserDao {

	public void saveUser(User user);

	public void loadUser(User user);

	public User loginUser(User user);

	public int getRoleUser(User user);

	public User findUserByUserName(String userName);

	public List<User> userListByValue(String value);

	public List<User> userList();

	public User searchUserById(int idUser);

	public void deleteUser(int idUser);

	public void editUser(User user);

	public List<BookTour> myRegListByValue(String value, int idUser);

	public List<BookTour> myRegList(int idUser);

	public List<BookTour> myCancelListByValue(String value, int idUser);

	public List<BookTour> myCancelList(int idUser);

	public void undoCancel(int idBT);

	public List<BookTour> myBookTourListByValue(String value, int idUser);

	public List<BookTour> myBookTourList(int idUser);
	
	public int findIdByUserName(String userName);
}