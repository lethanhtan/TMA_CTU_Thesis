package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ctu.thesis.travelsystem.model.Tour;

public class TourDaoImpl implements TourDao {
	
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
				session.save(tour);
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
	}

	@Override
	public Tour findByIdTour(Integer idTour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Tour tour =(Tour) session.load(Tour.class, new Integer(idTour));
		tx.commit();
		logger.info("Tour loaded successfully!");
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
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteTour(Integer idTour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		Tour tour =(Tour) session.load(Tour.class, new Integer(idTour));
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
			logger.info("Tour List::" + tour);
		}
		tx.commit();
		return tourList;
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
}
