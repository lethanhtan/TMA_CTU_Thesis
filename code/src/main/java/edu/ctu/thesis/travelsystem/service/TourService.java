package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.Tour;

public interface TourService {
	public void saveTour(Tour tour);

	public Tour findTourById(int idTour);

	public Tour findTourByName(String name);

	public void updateTour(Tour tour);

	public void deleteTour(int idTour);

	public List<Tour> listTour();

	public List<Tour> listTourByValue(String value);
	
	public List<Tour> showTourList();
	
	public List<Tour> tourListByValue(String value);
	
	public List<Tour> listTourByYear(int year);
	
	public void addView(Tour tour);
	
	public String searchImage(int idTour);
}
