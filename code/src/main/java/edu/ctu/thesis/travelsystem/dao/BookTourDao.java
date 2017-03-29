package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;

public interface BookTourDao {
	public void saveBookTour(BookTour bookTour, int idTour);

	public List<BookTour> bookTourList();

	public List<BookTour> listBookTourById(int idTour);

	public BookTour searchById(int idBT);

	public void editBookTour(BookTour bookTour);

	public List<BookTour> registrationListByValue(String value, int idTour);

	public Integer getNumBTBySearch(String value, int idTour);

	public int getNumTicketBooked(int idTour);

	public int getNumTicketAvailability(int idTour);

	public List<BookTour> registrationInfoByValue(String value, int idTour);

	public void cancelBookTour(int idBT);

	public List<BookTour> listTourByYear(int year);

	public int listBookTourByMonth(int month, List<BookTour> list);

	public void addFiledOption(String name, String type);

	public void dropFiledOption(String name);
}
