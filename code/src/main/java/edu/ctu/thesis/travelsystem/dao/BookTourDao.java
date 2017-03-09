package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;

public interface BookTourDao {
	public void saveBookTour(BookTour bookTour, String idTour);
	
	public List<BookTour> registrationList(String idTour);
	
	public BookTour searchId(String idBT);
	
	public void editBookTour(BookTour bookTour);
	
	public void deleteBookTour(String idBT, String idTour);
}
