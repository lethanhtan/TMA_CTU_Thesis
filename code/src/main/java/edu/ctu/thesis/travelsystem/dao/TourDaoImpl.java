package edu.ctu.thesis.travelsystem.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ctu.thesis.travelsystem.model.Tour;

public class TourDaoImpl implements TourDao {
	
	//Fill the fields automatically
	@Autowired
	private SessionFactory sessionFactory;
	
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
}
