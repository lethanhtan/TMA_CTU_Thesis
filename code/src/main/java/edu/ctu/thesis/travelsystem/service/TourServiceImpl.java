package edu.ctu.thesis.travelsystem.service;

import edu.ctu.thesis.travelsystem.model.Tour;

import java.util.List;

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

	@Override
	public Tour findId(String idTour) {
		return this.tourDao.findId(idTour);
	}

	@Override
	public Tour findName(String name) {
		return this.tourDao.findName(name);
	}

	@Override
	public void updateTour(Tour tour) {
		this.tourDao.updateTour(tour);
	}

	@Override
	public void deleteTour(String idTour) {
		this.tourDao.deleteTour(idTour);
	}

	@Override
	public List<Tour> listTour() {
		return this.tourDao.listTour();
	}

	@Override
	public Integer getNumTour() {
		return this.tourDao.getNumTour();
	}

	@Override
	public List<Tour> listTourById(String value) {
		return this.tourDao.listTourByValue(value);
	}

	@Override
	public Integer getNumTourByValue(String value) {
		return this.tourDao.getNumTourBySearch(value);
	}
}
