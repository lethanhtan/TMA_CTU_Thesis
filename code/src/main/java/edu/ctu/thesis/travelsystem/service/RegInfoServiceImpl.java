package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.RegInfoDao;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.RegistrationInfo;

@Service
public class RegInfoServiceImpl implements RegInfoService {
	@Autowired
	private RegInfoDao regInfoDao;

	@Override
	@Transactional
	public List<BookTour> registrationList(int idTour) {
		return this.regInfoDao.registrationList(idTour);
	}
	
	@Override
	@Transactional
	public Integer getNumBookTour(int idTour) {
		return this.regInfoDao.getNumBookTour(idTour);
	}

	@Override
	@Transactional
	public void deleteBookTour(int idBT, int idTour) {
		this.regInfoDao.deleteBookTour(idBT, idTour);
	}
	
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
	public List<BookTour> cancelList(int idTour) {
		return this.regInfoDao.cancelList(idTour);
	}
	
	@Override
	@Transactional
	public List<BookTour> cancelListByValue(String value, int idTour) {
		return this.regInfoDao.cancelListByValue(value, idTour);
	}

	@Override
	@Transactional
	public Integer getNumCancelReg(int idTour) {
		return this.regInfoDao.getNumCancelReg(idTour);
	}
	
	@Override
	@Transactional
	public Integer getNumCancelBySearch(String value, int idTour) {
		return this.regInfoDao.getNumCancelBySearch(value, idTour);
	}
	
	@Override
	@Transactional
	public void undoCancel(int idBT, int idTour) {
		this.regInfoDao.undoCancel(idBT, idTour);
	}
}