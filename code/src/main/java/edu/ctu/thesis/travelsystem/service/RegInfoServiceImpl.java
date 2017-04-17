package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.RegInfoDao;
import edu.ctu.thesis.travelsystem.model.BookTour;

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
	public void deleteBookTour(int idBT, int idTour) {
		this.regInfoDao.deleteBookTour(idBT, idTour);
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
	public void undoCancel(int idBT) {
		this.regInfoDao.undoCancel(idBT);
	}
	
	@Override
	@Transactional
	public void addFieldOption(String name, String type) {
		this.regInfoDao.addFieldOption(name, type);
	}

	@Override
	public void dropFieldOption(String name) {
		this.regInfoDao.dropFieldOption(name);
	}
	
	@Override
	@Transactional
	public BookTour getFirstElement(int relationship) {
		return this.regInfoDao.getFirstElement(relationship);
	}
}