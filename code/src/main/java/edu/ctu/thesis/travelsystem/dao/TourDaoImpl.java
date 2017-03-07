package edu.ctu.thesis.travelsystem.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.extra.GenerateId;
import edu.ctu.thesis.travelsystem.model.Tour;

@Service
public class TourDaoImpl implements TourDao {
	GenerateId gid = new GenerateId();

	// Fill the fields automatically
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(TourDaoImpl.class);

	// Create tour
	@Override
	public void saveTour(Tour tour) {
		Session session = this.sessionFactory.getCurrentSession();
		if (tour != null) {
			try {
				logger.info("Save tour be called!");
				tour.setIdTour(gid.generateIdTour());
				session.save(tour);
				session.close();
			} catch (Exception e) {
				logger.info("Exception when call save tour!");
				session.close();
				e.printStackTrace();
			}
		}
	}

	@Override
	public Tour findId(String idTour) {
		Session session = this.sessionFactory.getCurrentSession();
		Tour tour = (Tour) session.load(Tour.class, new String(idTour));
		logger.info("Tour finded successfully!");
		return tour;
	}

	@Override
	public Tour findName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Tour tour = (Tour) session.load(Tour.class, new String(name));
		logger.info("Tour loaded successfully!");
		return tour;
	}

	@Override
	public void updateTour(Tour tour) {
		Session session = this.sessionFactory.getCurrentSession();
		if (tour != null) {
			try {
				session.update(tour);
				logger.info("Tour updated successfully, Tour details = " + tour);
				session.close();
			} catch (Exception e) {
				logger.info("Exception when update tour!");
				session.close();
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteTour(String idTour) {
		Session session = this.sessionFactory.getCurrentSession();
		Tour tour = (Tour) session.load(Tour.class, new String(idTour));
		if (tour != null) {
			session.delete(tour);
			logger.info("Tour deleted successfully!");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> listTour() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from edu.ctu.thesis.travelsystem.model.Tour";
		List<Tour> tourList = session.createQuery(hql).list();
		for(Tour tour : tourList){
			logger.info("Tour List:" + tour);
		}
		return tourList;
	}

	@Override
	public List<Tour> listTourByValue(String value) {
		List<Tour> newTourList = new ArrayList<Tour>();
		for (Tour tour : listTour()) {
			if (value.equals(tour.getIdTour().substring(0, value.length()))) {
				newTourList.add(tour);
			} else if (value.equals(tour.getName().substring(0, value.length()))) {
				newTourList.add(tour);
			} else {
				logger.info("Not find tour input!");
			}
		}
		return newTourList;
	}

	@Override
	public Integer getNumTour() {
		Integer numTour = listTour().size();
		logger.info("Number of tour is: " + numTour);
		return numTour;
	}

	@Override
	public Integer getNumTourBySearch(String value) {
		Integer numTour = listTourByValue(value).size();
		logger.info("Number of tour is: " + numTour);
		return numTour;
	}
}
