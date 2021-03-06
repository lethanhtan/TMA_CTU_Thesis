package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;

public interface BookTourService {
	
	public void saveBookTours(List<BookTour> bookTours, int idTour);

	public List<BookTour> bookTourList();
	
	public List<BookTour> listBookTourById(int idTour);

	public BookTour searchById(int idBT);

	public void editBookTour(BookTour bookTour);

	public List<BookTour> registrationListByValue(String value, int idTour);

	public int getNumTicketBooked(int idTour);

	public int getNumTicketAvailability(int idTour);

	public List<BookTour> registrationInfoByValue(String value, int idTour);

	public void cancelBookTour(int idBT);

	public List<BookTour> listTourByYear(int year);

	public int listBookTourByMonth(int month, List<BookTour> list);
	
	public int getMaxValue();
	
	public List<BookTour> bookTourListByRelationship(int relationship);
	
	public void saveBookTour(BookTour bookTour, int idTour);
}