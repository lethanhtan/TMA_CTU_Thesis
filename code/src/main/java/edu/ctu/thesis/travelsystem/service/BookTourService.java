package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;

public interface BookTourService {
	public void saveBookTour(BookTour bookTour, String idTour);
	
	public List<BookTour> registrationList(String idTour);
	
	public BookTour searchById(String idBT);
	
	public void editBookTour(BookTour bookTour);

	public void deleteBookTour(String idBT, String idTour);
	
	public BookTour searchByName(String cusName);
	
	public BookTour searchByEmail(String cusEmail);
	
	public BookTour searchByPhone(String cusPhone);
	
	public Integer getNumBookTour(String idTour);
	
	public List<BookTour> registrationListByValue(String value);
	
	public Integer getNumBTBySearch(String value);
	
	public Integer paginationX(Integer currentPage, Integer page);
	
	public Integer paginationY(Integer numOfPage, Integer currentPage, Integer page);
}