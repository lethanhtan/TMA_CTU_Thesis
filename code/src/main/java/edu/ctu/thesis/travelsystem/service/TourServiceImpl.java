package edu.ctu.thesis.travelsystem.service;

import edu.ctu.thesis.travelsystem.model.Tour;

import org.springframework.beans.factory.annotation.Autowired;

import edu.ctu.thesis.travelsystem.dao.TourDao;

public class TourServiceImpl implements TourService {
	
	@Autowired
	private TourDao tourDao;
	
	public void setTourDao(TourDao tourDao) {
		this.tourDao = tourDao;
	}

	@Override
	public void saveTour(Tour tour) {
		this.tourDao.saveTour(tour);
	}
}
