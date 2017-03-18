package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;

public interface BookTourService {
	public void saveBookTour(BookTour bookTour, Integer idTour);
	
	public List<BookTour> listBookTour();
	
	public List<BookTour> registrationList(Integer idTour);
	
	public BookTour searchById(Integer idBT);
	
	public void editBookTour(BookTour bookTour);

	public void deleteBookTour(Integer idBT, Integer idTour);
	
	public BookTour searchByName(String cusName);
	
	public BookTour searchByEmail(String cusEmail);
	
	public BookTour searchByPhone(String cusPhone);
	
	public Integer getNumBookTour(Integer idTour);
	
	public List<BookTour> registrationListByValue(String value);
	
	public Integer getNumBTBySearch(String value);
	
	public Integer paginationX(Integer currentPage, Integer page);
	
	public Integer paginationY(Integer numOfPage, Integer currentPage, Integer page);
}