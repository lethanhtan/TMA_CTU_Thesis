package edu.ctu.thesis.travelsystem.dto;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;

public class SubBookTourVO {
	private List<BookTourInfoVO> info;
	private BookTour bookTour;
	
	public List<BookTourInfoVO> getInfo() {
		return info;
	}
	public void setInfo(List<BookTourInfoVO> info) {
		this.info = info;
	}
	public BookTour getBookTour() {
		return bookTour;
	}

	public void setBookTour(BookTour bookTour) {
		this.bookTour = bookTour;
	}
}
