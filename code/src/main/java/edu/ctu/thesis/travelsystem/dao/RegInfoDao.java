package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.CancelRegistration;
import edu.ctu.thesis.travelsystem.model.RegistrationInfo;

public interface RegInfoDao {
	public void saveRegInfoForm(RegistrationInfo regInfo, int idTour);
	
	public RegistrationInfo searchRegInfoById(int idTour);
	
	public List<CancelRegistration> cancelList(int idTour);
	
	public List<CancelRegistration> cancelListByValue(String value);
	
	public Integer getNumCancelReg(int idTour);
	
	public Integer getNumCancelBySearch(String value);
}
