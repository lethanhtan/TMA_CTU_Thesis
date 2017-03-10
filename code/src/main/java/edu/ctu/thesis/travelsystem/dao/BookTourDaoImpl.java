package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.extra.GenerateId;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;

@Service
public class BookTourDaoImpl implements BookTourDao {
	GenerateId gid = new GenerateId();

	// Fill the fields automatically
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(BookTourDaoImpl.class);

	/*
	 * public void setSessionfactory(SessionFactory sessionFactory) {
	 * this.sessionFactory = sessionFactory; }
	 */

	// Save book tour form when have id tour
	@Override
	public void saveBookTour(BookTour bookTour, String idTour) {
		Session session = this.sessionFactory.getCurrentSession();
		if (bookTour != null) {
			try {
				bookTour.setIdBT(gid.generateIdBT());
				Query query = session.createQuery("update BookTour set ID_TOUR = :idTour where ID_BT = :idBT");
				logger.info(idTour);
				query.setParameter("idTour",idTour);
				logger.info("L2:" +  bookTour.getIdBT());
				query.setParameter("idBT", bookTour.getIdBT());
				session.persist(bookTour);
				session.flush();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// Display registration list by Id tour
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> registrationList(String idTour) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM edu.ctu.thesis.travelsystem.model.BookTour WHERE ID_TOUR = :idTour";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		List<BookTour> registrationList = query.list();
		for (BookTour bookTour : registrationList) {
			logger.info("Registration List:" + bookTour);
		}
		return registrationList;
	}

	// Search id of customer booked tour
	@Override
	public BookTour searchId(String idBT) {
		Session session = this.sessionFactory.getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new String(idBT));
		logger.info("Search Customer booked tour successfully!" + bookTour.getIdBT());
		return bookTour;
	}

	// Edit information of customer after booked tour
	@Override
	public void editBookTour(BookTour bookTour) {
		Session session = this.sessionFactory.getCurrentSession();
		if (bookTour != null) {
			try {
				session.update(bookTour);
				session.flush();
				logger.info("Edit information of customer booked tour successfully: " + bookTour);
			} catch (Exception e) {
				logger.info("Exception when edit information of customer!");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteBookTour(String idBT, String idTour) {
		Session session = this.sessionFactory.getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new String(idBT));
		if (bookTour != null) {
			Query query = session.createQuery("update BookTour set ID_TOUR = null where ID_BT = :idBT");
			query.setParameter("idBT", bookTour.getIdBT());
			query.executeUpdate();
			session.delete(bookTour);
			session.flush();
			logger.info("Delete customer success!");
		}
	}
}
