package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;

public interface RegInfoService {
	public List<BookTour> registrationList(int idTour);
	
	public void deleteBookTour(int idBT, int idTour);

	public List<BookTour> cancelList(int idTour);

	public List<BookTour> cancelListByValue(String value, int idTour);

	public void undoCancel(int idBT);
	
	public void addFieldOption(String name, String type);

	public void dropFieldOption(String name);
	
	public BookTour getFirstElement(int relationship);
	
	public void cancelAllBookTour(int idBT, int relationship);
}