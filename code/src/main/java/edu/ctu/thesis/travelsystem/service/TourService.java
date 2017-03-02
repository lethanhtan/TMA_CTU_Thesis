package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.Tour;

public interface TourService {
	public void saveTour(Tour tour);

	public Tour findByIdTour(Integer idTour);

	public Tour findByNameTour(String nameTour);

	public void updateTour(Tour tour);

	public void deleteTour(Integer idTour);

	public List<Tour> listTour();
	
	public Integer getNumTour();
}
