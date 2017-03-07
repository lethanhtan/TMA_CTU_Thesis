package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;

public interface BookTourDao {
	public void saveBookTour(BookTour bookTour, String idTour);
	
	public List<BookTour> registrationList(String idTour);
}
