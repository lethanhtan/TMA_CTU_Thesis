package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.RegInfoDao;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Relationship;

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
	public BookTour getFirstElement(int relationship) {
		return this.regInfoDao.getFirstElement(relationship);
	}
	
	@Override
	@Transactional
	public void cancelAllBookTour(int idBT, int relationship) {
		this.regInfoDao.cancelAllBookTour(idBT, relationship);
	}
	
	@Override
	@Transactional
	public List<Relationship> relationshipList() {
		return this.regInfoDao.relationshipList();
	}
	
	@Override
	@Transactional
	public void saveRelationship(Relationship relationship) {
		this.regInfoDao.saveRelationship(relationship);
	}
	
	@Override
	@Transactional
	public void deleteRelationship(int id) {
		this.regInfoDao.deleteRelationship(id);
	}
	
	@Override
	@Transactional
	public void undoAllCancel(int idBT, int relationship) {
		this.regInfoDao.undoAllCancel(idBT, relationship);
	}
	
	@Override
	@Transactional
	public void deleteAllBookTour(int idBT, int relationship) {
		this.regInfoDao.deleteAllBookTour(idBT, relationship);
	}
}