package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;

public interface RegInfoDao {
	public List<BookTour> registrationList(int idTour);
	
	public Integer getNumBookTour(int idTour);
	
	public void deleteBookTour(int idBT, int idTour);
	
	public List<BookTour> cancelList(int idTour);
	
	public List<BookTour> cancelListByValue(String value, int idTour);
	
	public Integer getNumCancelReg(int idTour);
	
	public Integer getNumCancelBySearch(String value, int idTour);
	
	public void undoCancel(int idBT, int idTour);
	
	public void addFieldOption(String name, String type);

	public void dropFieldOption(String name);
}
