package edu.ctu.thesis.travelsystem.dto;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.Tour;

public class SubBookTourVO {
	private List<BookTourInfoVO> info;
	private Tour tour;
	
	public List<BookTourInfoVO> getInfo() {
		return info;
	}
	public void setInfo(List<BookTourInfoVO> info) {
		this.info = info;
	}
	public Tour getTour() {
		return tour;
	}

	public void setTour(Tour tour) {
		this.tour = tour;
	}
}
