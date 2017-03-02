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
	public Tour findByIdTour(Integer idTour) {
		return this.tourDao.findByIdTour(idTour);
	}

	@Override
	public Tour findByNameTour(String nameTour) {
		return this.tourDao.findByNameTour(nameTour);
	}

	@Override
	public void updateTour(Tour tour) {
		this.tourDao.updateTour(tour);
	}

	@Override
	public void deleteTour(Integer idTour) {
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
}
