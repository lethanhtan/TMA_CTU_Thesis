package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ctu.thesis.travelsystem.extra.GenerateId;
import edu.ctu.thesis.travelsystem.model.BookTour;

public class BookTourDaoImpl implements BookTourDao {
	GenerateId gid = new GenerateId();

	// Fill the fields automatically
	@Autowired
	private SessionFactory sessionFactory;

	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// Save book tour form when have id tour
	@Override
	public void saveBookTour(BookTour bookTour, String idTour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if (bookTour != null) {
			try {
				bookTour.setIdBT(gid.generateIdBT());
				session.save(bookTour);
				Query query = session.createQuery("update BookTour set ID_TOUR = :idTour where ID_BT = :idBT");
				query.setParameter("idTour", idTour);
				query.setParameter("idBT", bookTour.getIdBT());
				query.executeUpdate();
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> registrationList(String idTour) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "FROM edu.ctu.thesis.travelsystem.model.BookTour WHERE ID_TOUR = :idTour";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		List<BookTour> registrationList = query.list();
		tx.commit();
		return registrationList;
	}
}
