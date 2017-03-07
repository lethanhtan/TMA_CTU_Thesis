package edu.ctu.thesis.travelsystem.service;

import edu.ctu.thesis.travelsystem.model.BookTour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import edu.ctu.thesis.travelsystem.dao.BookTourDao;

public class BookTourServiceImpl implements BookTourService {
	
	@Autowired
	private BookTourDao bookTourDao;
	
	public void setBookTourDao(BookTourDao bookTourDao) {
		this.bookTourDao = bookTourDao;
	}
	
	@Override
	public void saveBookTour(BookTour bookTour, String idTour) {
		this.bookTourDao.saveBookTour(bookTour, idTour);
	}
	
	@Override
	public List<BookTour> registrationList(String idTour) {
		return this.bookTourDao.registrationList(idTour);
	}
}