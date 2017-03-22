package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.RegInfoDao;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.CancelRegistration;
import edu.ctu.thesis.travelsystem.model.RegistrationInfo;

@Service
public class RegInfoServiceImpl implements RegInfoService {
	@Autowired
	private RegInfoDao regInfoDao;
	
	@Override
	@Transactional
	public void saveRegInfoForm(RegistrationInfo regInfo, int idTour) {
		this.regInfoDao.saveRegInfoForm(regInfo, idTour);
	}
	
	@Override
	@Transactional
	public RegistrationInfo searchRegInfoById(int idTour) {
		return this.regInfoDao.searchRegInfoById(idTour);
	}
	
	@Override
	@Transactional
	public List<CancelRegistration> cancelList(int idTour) {
		return this.regInfoDao.cancelList(idTour);
	}
	
	@Override
	@Transactional
	public List<CancelRegistration> cancelListByValue(String value) {
		return this.regInfoDao.cancelListByValue(value);
	}

	@Override
	@Transactional
	public Integer getNumCancelReg(int idTour) {
		return this.regInfoDao.getNumCancelReg(idTour);
	}
	
	@Override
	@Transactional
	public Integer getNumCancelBySearch(String value) {
		return this.regInfoDao.getNumCancelBySearch(value);
	}
}