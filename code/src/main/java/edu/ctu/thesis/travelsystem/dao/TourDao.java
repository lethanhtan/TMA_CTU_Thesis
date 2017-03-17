package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.Tour;

public interface TourDao {
	
	public void saveTour(Tour tour);
	
	public Tour findTourById(Integer idTour);
	
	public Tour findTourByName(String name);
	
	public void updateTour(Tour tour);
	
	public void deleteTour(Integer idTour);
	
	public List<Tour> listTour();
	
	public Integer getNumTour();
	
	public Integer getNumTourBySearch(String value);

	public List<Tour> listTourByValue(String value);
	
	public Integer paginationX(Integer currentPage, Integer page);
	
	public Integer paginationY(Integer numOfPage, Integer currentPage, Integer page);
}
