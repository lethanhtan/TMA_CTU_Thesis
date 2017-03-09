package edu.ctu.thesis.travelsystem.service;

import edu.ctu.thesis.travelsystem.model.Tour;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.TourDao;

@Service
public class TourServiceImpl implements TourService {
	
	@Autowired
	private TourDao tourDao;
	
	@Override
	@Transactional
	public void saveTour(Tour tour) {
		this.tourDao.saveTour(tour);
	}

	@Override
	@Transactional
	public Tour findId(String idTour) {
		return this.tourDao.findId(idTour);
	}

	@Override
	@Transactional
	public Tour findName(String name) {
		return this.tourDao.findName(name);
	}

	@Override
	@Transactional
	public void updateTour(Tour tour) {
		this.tourDao.updateTour(tour);
	}

	@Override
	@Transactional
	public void deleteTour(String idTour) {
		this.tourDao.deleteTour(idTour);
	}

	@Override
	@Transactional
	public List<Tour> listTour() {
		return this.tourDao.listTour();
	}

	@Override
	@Transactional
	public Integer getNumTour() {
		return this.tourDao.getNumTour();
	}

	@Override
	@Transactional
	public List<Tour> listTourById(String value) {
		return this.tourDao.listTourByValue(value);
	}

	@Override
	@Transactional
	public Integer getNumTourByValue(String value) {
		return this.tourDao.getNumTourBySearch(value);
	}
}
