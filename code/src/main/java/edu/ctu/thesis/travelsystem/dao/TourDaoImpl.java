package edu.ctu.thesis.travelsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ctu.thesis.travelsystem.extra.GenerateId;
import edu.ctu.thesis.travelsystem.model.Tour;

public class TourDaoImpl implements TourDao {
	GenerateId gid = new GenerateId();
	
	//Fill the fields automatically
	@Autowired
	private SessionFactory sessionFactory;
	
	public static final Logger logger = LoggerFactory.getLogger(TourDaoImpl.class);
	
	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//Create tour
	@Override
	public void saveTour(Tour tour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(tour != null) {
			try {
				logger.info("Save tour be called!");
				tour.setIdTour(gid.generateIdTour());
				session.save(tour);
				tx.commit();
				session.close();
			} catch (Exception e) {
				logger.info("Exception when call save tour!");
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
	}

	@Override
	public Tour findByIdTour(String idTour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Tour tour =(Tour) session.load(Tour.class, new String(idTour));
		tx.commit();
		logger.info("Tour finded successfully!");
		return tour;
	}

	@Override
	public Tour findByNameTour(String nameTour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Tour tour =(Tour) session.load(Tour.class, new String(nameTour));
		tx.commit();
		logger.info("Tour loaded successfully!");
		return tour;
	}

	@Override
	public void updateTour(Tour tour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(tour != null) {
			try {
				session.update(tour);
				tx.commit();
				logger.info("Tour updated successfully, Tour details = " + tour);
				session.close();
			} catch (Exception e) {
				logger.info("Exception when update tour!");
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteTour(String idTour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Tour tour =(Tour) session.load(Tour.class, new String(idTour));
		if (tour != null) {
			session.delete(tour);
			logger.info("Tour deleted successfully!");
		}
		tx.commit();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> listTour() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from edu.ctu.thesis.travelsystem.model.Tour";
		List<Tour> tourList = session.createQuery(hql).list();
		for(Tour tour : tourList){
			logger.info("Tour List:" + tour);
		}
		tx.commit();
		return tourList;
	}
	
	@Override
	public List<Tour> listTourByValue(String value) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		List<Tour> newTourList = new ArrayList<Tour>();
		for (Tour tour : listTour()) {
				if (value.equals(tour.getIdTour().substring(0, value.length()))) {
					newTourList.add(tour);
				}
				else if(value.equals(tour.getTourName().substring(0, value.length()))) {
					newTourList.add(tour);
				}
				else {
					logger.info("Not find tour input!");
				}
		}
		
		tx.commit();
		return newTourList;
	}

	@Override
	public Integer getNumTour() {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Integer numTour = listTour().size();
		logger.info("Number of tour is: " + numTour);
		tx.commit();
		return numTour;
	}

	@Override
	public Integer getNumTourBySearch(String value) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Integer numTour = listTourByValue(value).size();
		logger.info("Number of tour is: " + numTour);
		tx.commit();
		return numTour;
	}
	
	@Override
	public Integer startIndex(Integer numPage, Integer curPage) {
		for (int i=0; i < numPage; i++) {
			Integer startNum = 0;
		}
		return null;
	}

	@Override
	public Integer endIndex(Integer numPage, Integer startNum, Integer curPage) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
