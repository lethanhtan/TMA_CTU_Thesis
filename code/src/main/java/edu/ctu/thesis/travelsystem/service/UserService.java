package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;
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

	public List<BookTour> myRegListByValue(String value, int idUser);

	public Integer getMyNumBTBySearch(String value, int idUser);

	public List<BookTour> myRegList(int idUser);

	public Integer getMyNumBT(int idUser);

	public List<BookTour> myCancelListByValue(String value, int idUser);

	public Integer getMyNumCancelBySearch(String value, int idUser);

	public List<BookTour> myCancelList(int idUser);

	public Integer getMyNumCancelReg(int idUser);
	
	public void undoCancel(int idBT, int idTour);
	
	public List<BookTour> myBookTourListByValue(String value, int idUser);

	public Integer getMyNumBookTourBySearch(String value, int idUser);

	public List<BookTour> myBookTourList(int idUser);

	public Integer getMyNumBookTour(int idUser);
}