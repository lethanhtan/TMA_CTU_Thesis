package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.Tour;

public interface TourService {
	public void saveTour(Tour tour);

	public Tour findTourById(String idTour);

	public Tour findTourByName(String name);

	public void updateTour(Tour tour);

	public void deleteTour(String idTour);

	public List<Tour> listTour();

	public List<Tour> listTourByValue(String value);

	public Integer getNumTour();

	public Integer getNumTourByValue(String value);

	public Integer paginationX(Integer currentPage, Integer page);

	public Integer paginationY(Integer numOfPage, Integer currentPage, Integer page);
}
