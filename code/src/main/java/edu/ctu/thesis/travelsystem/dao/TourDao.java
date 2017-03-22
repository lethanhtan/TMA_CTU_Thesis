package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.Tour;

public interface TourDao {
	
	public void saveTour(Tour tour);
	
	public Tour findTourById(int idTour);
	
	public Tour findTourByName(String name);
	
	public void updateTour(Tour tour);
	
	public void deleteTour(int idTour);
	
	public List<Tour> listTour();
	
	public int getNumTour();
	
	public int getNumTourBySearch(String value);

	public List<Tour> listTourByValue(String value);
	
	public Integer paginationX(Integer currentPage, Integer page);
	
	public Integer paginationY(Integer numOfPage, Integer currentPage, Integer page);
	
	public List<Tour> showTourList();
	
	public int getNumTourList();
}
