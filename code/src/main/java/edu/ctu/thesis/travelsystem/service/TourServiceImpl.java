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
	public Tour findTourById(int idTour) {
		return this.tourDao.findTourById(idTour);
	}

	@Override
	@Transactional
	public Tour findTourByName(String name) {
		return this.tourDao.findTourByName(name);
	}

	@Override
	@Transactional
	public void updateTour(Tour tour) {
		this.tourDao.updateTour(tour);
	}

	@Override
	@Transactional
	public void deleteTour(int idTour) {
		this.tourDao.deleteTour(idTour);
	}

	@Override
	@Transactional
	public List<Tour> listTour() {
		return this.tourDao.listTour();
	}

	@Override
	@Transactional
	public int getNumTour() {
		return this.tourDao.getNumTour();
	}

	@Override
	@Transactional
	public List<Tour> listTourByValue(String value) {
		return this.tourDao.listTourByValue(value);
	}

	@Override
	@Transactional
	public int getNumTourByValue(String value) {
		return this.tourDao.getNumTourByValue(value);
	}

	@Override
	public Integer paginationX(Integer currentPage, Integer page) {
		return this.tourDao.paginationX(currentPage, page);
	}

	@Override
	public Integer paginationY(Integer numOfPage, Integer currentPage, Integer page) {
		return this.tourDao.paginationY(numOfPage, currentPage, page);
	}

	@Override
	@Transactional
	public List<Tour> showTourList() {
		return this.tourDao.showTourList();
	}

	@Override
	@Transactional
	public int getNumTourList() {
		return this.tourDao.getNumTourList();
	}

	@Override
	@Transactional
	public List<Tour> tourListByValue(String value) {
		return this.tourDao.tourListByValue(value);
	}

	@Override
	public List<Tour> listTourByYear(int year) {
		return this.tourDao.listTourByYear(year);
	}
}
