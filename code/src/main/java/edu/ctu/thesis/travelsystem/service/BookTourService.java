package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;

public interface BookTourService {
	public void saveBookTour(BookTour bookTour, String idTour);
	
	public List<BookTour> registrationList(String idTour);
}