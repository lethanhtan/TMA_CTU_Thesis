package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.Tour;

public interface TourDao {
	
	public void saveTour(Tour tour);
	
	public Tour findId(String idTour);
	
	public Tour findName(String name);
	
	public void updateTour(Tour tour);
	
	public void deleteTour(String idTour);
	
	public List<Tour> listTour();
	
	public Integer getNumTour();
	
	public Integer getNumTourBySearch(String value);

	public List<Tour> listTourByValue(String value);
	
}