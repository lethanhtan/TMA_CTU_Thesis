package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.BookTourDao;
import edu.ctu.thesis.travelsystem.model.BookTour;

@Service
public class BookTourServiceImpl implements BookTourService {
	@Autowired
	private BookTourDao bookTourDao;

	@Override
	@Transactional
	public void saveBookTour(BookTour bookTour, int idTour) {
		this.bookTourDao.saveBookTour(bookTour, idTour);
	}

	@Override
	@Transactional
	public BookTour searchById(int idBT) {
		return this.bookTourDao.searchById(idBT);
	}

	@Override
	@Transactional
	public void editBookTour(BookTour bookTour) {
		this.bookTourDao.editBookTour(bookTour);
	}

	@Override
	@Transactional
	public List<BookTour> registrationListByValue(String value, int idTour) {
		return this.bookTourDao.registrationListByValue(value, idTour);
	}

	@Override
	@Transactional
	public Integer getNumBTBySearch(String value, int idTour) {
		return this.bookTourDao.getNumBTBySearch(value, idTour);
	}

	@Override
	@Transactional
	public List<BookTour> bookTourList() {
		return this.bookTourDao.bookTourList();
	}

	@Override
	public int getNumTicketBooked(int idTour) {
		return this.bookTourDao.getNumTicketBooked(idTour);
	}

	@Override
	public int getNumTicketAvailability(int idTour) {
		return this.bookTourDao.getNumTicketAvailability(idTour);
	}

	@Override
	@Transactional
	public List<BookTour> registrationInfoByValue(String value, int idTour) {
		return this.bookTourDao.registrationInfoByValue(value, idTour);
	}

	@Override
	@Transactional
	public void cancelBookTour(int idBT) {
		this.bookTourDao.cancelBookTour(idBT);
	}

	@Override
	public List<BookTour> listTourByYear(int year) {
		return this.bookTourDao.listTourByYear(year);
	}

	@Override
	public int listBookTourByMonth(int month, List<BookTour> list) {
		return this.bookTourDao.listBookTourByMonth(month, list);
	}

	@Override
	public List<BookTour> listBookTourById(int idTour) {
		return this.bookTourDao.listBookTourById(idTour);
	}
}