package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.RegistrationInfo;

public interface RegInfoDao {
	public List<BookTour> registrationList(int idTour);
	
	public Integer getNumBookTour(int idTour);
	
	public void deleteBookTour(int idBT, int idTour);
	
	public void saveRegInfoForm(RegistrationInfo regInfo, int idTour);

	public RegistrationInfo searchRegInfoById(int idTour);
	
	public List<BookTour> cancelList(int idTour);
	
	public List<BookTour> cancelListByValue(String value, int idTour);
	
	public Integer getNumCancelReg(int idTour);
	
	public Integer getNumCancelBySearch(String value, int idTour);
	
	public void undoCancel(int idBT, int idTour);
}
