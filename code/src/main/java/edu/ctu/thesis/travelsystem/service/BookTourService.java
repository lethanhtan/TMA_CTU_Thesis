package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.RegistrationInfo;

public interface BookTourService {
	public void saveBookTour(BookTour bookTour, int idTour);
	
	public List<BookTour> listBookTour();
	
	public List<BookTour> registrationList(int idTour);
	
	public BookTour searchById(int idBT);
	
	public void editBookTour(BookTour bookTour);

	public void deleteBookTour(int idBT, int idTour);
	
	public BookTour searchByName(String cusName);
	
	public BookTour searchByEmail(String cusEmail);
	
	public BookTour searchByPhone(String cusPhone);
	
	public Integer getNumBookTour(int idTour);
	
	public List<BookTour> registrationListByValue(String value);
	
	public Integer getNumBTBySearch(String value);
	
	public Integer paginationX(Integer currentPage, Integer page);
	
	public Integer paginationY(Integer numOfPage, Integer currentPage, Integer page);
	
	public int getNumTicketBooked(int idTour);
	
	public int getNumTicketAvailability(int idTour);
}