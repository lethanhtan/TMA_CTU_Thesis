package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Relationship;

public interface RegInfoDao {
	public List<BookTour> registrationList(int idTour);
	
	public void deleteBookTour(int idBT, int idTour);
	
	public List<BookTour> cancelList(int idTour);
	
	public List<BookTour> cancelListByValue(String value, int idTour);
	
	public void undoCancel(int idBT);
	
	public BookTour getFirstElement(int relationship);
	
	public void cancelAllBookTour(int idBT, int relationship);
	
	public List<Relationship> relationshipList();
	
	public void saveRelationship(Relationship relationship);
	
	public void deleteRelationship(int id);
}
