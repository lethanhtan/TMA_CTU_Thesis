package edu.ctu.thesis.travelsystem.service;

import edu.ctu.thesis.travelsystem.model.BookTour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.BookTourDao;

@Service
public class BookTourServiceImpl implements BookTourService {
	
	@Autowired
	private BookTourDao bookTourDao;
	
	@Override
	@Transactional
	public void saveBookTour(BookTour bookTour, String idTour) {
		this.bookTourDao.saveBookTour(bookTour, idTour);
	}
	
	@Override
	@Transactional
	public List<BookTour> registrationList(String idTour) {
		return this.bookTourDao.registrationList(idTour);
	}
	
	@Override
	@Transactional
	public BookTour searchId(String idBT) {
		return this.bookTourDao.searchId(idBT);
	}
	
	@Override
	@Transactional
	public void editBookTour(BookTour bookTour) {
		this.bookTourDao.editBookTour(bookTour);
	}

	@Override
	@Transactional
	public void deleteBookTour(String idBT, String idTour) {
		this.bookTourDao.deleteBookTour(idBT, idTour);
	}
}