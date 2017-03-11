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

@Service
public class BookTourDaoImpl implements BookTourDao {
	GenerateId gid = new GenerateId();

	// Fill the fields automatically
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = Logger.getLogger(BookTourDaoImpl.class);

	// Save book tour form when have id tour
	@Override
	public void saveBookTour(BookTour bookTour, String idTour) {
		Session session = this.sessionFactory.getCurrentSession();
		// Tour tour = (Tour) session.load(Tour.class, new String(idTour));
		if (bookTour != null) {
			try {
				bookTour.setIdBT(gid.generateIdBT());
				session.saveOrUpdate(bookTour);
				// Query query = session.createQuery("from BookTour where ID_BT
				// = :idBT");
				Query query = session.createQuery("update BookTour set ID_TOUR = :idTour where ID_BT = :idBT");
				query.setParameter("idTour", idTour);
				logger.info(idTour);
				query.setParameter("idBT", bookTour.getIdBT());
				logger.info(bookTour.getIdBT());
				query.executeUpdate();
				session.saveOrUpdate(bookTour);
				session.flush();
				logger.info("Save book tour once");
				Query query2 = session.createQuery("update BookTour set ID_TOUR = :idTour where ID_BT = :idBT");
				query2.executeUpdate();
				session.saveOrUpdate(bookTour);
				session.flush();
				logger.info("Save book tour twice");
			} catch (Exception e) {
				logger.info("Error");
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

	// Search information of customer booked tour by Id
	@Override
	public BookTour searchById(String idBT) {
		Session session = this.sessionFactory.getCurrentSession();
		BookTour bookTour = new BookTour();
		logger.info("Information of customer have ID: " + idBT);
		String hql = "FROM edu.ctu.thesis.travelsystem.model.BookTour WHERE idBT = ?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, idBT);
			bookTour = (BookTour) query.uniqueResult();
		} catch (Exception e) {
			logger.info("Exception when find tour!");
		}
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

	// Search information of customer booked tour by Name
	@Override
	public BookTour searchByName(String cusName) {
		Session session = this.sessionFactory.getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new String(cusName));
		logger.info("Information of customer have: " + cusName);
		return bookTour;
	}

	// Search information of customer booked tour by Email
	@Override
	public BookTour searchByEmail(String cusEmail) {
		Session session = this.sessionFactory.getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new String(cusEmail));
		logger.info("Information of customer have: " + cusEmail);
		return bookTour;
	}

	// Search information of customer booked tour by Phone
	@Override
	public BookTour searchByPhone(String cusPhone) {
		Session session = this.sessionFactory.getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new String(cusPhone));
		logger.info("Information of customer have: " + cusPhone);
		return bookTour;
	}

	@Override
	public List<BookTour> registrationListByValue(String value) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "FROM edu.ctu.thesis.travelsystem.model.BookTour WHERE idBT like :value or cusName like :value or cusEmail like :value or cusPhone like :value";
		Query query = session.createQuery(hql);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<BookTour> registrationList = query.list();
		return registrationList;
	}

	@Override
	public Integer getNumBookTour(String idTour) {
		Integer numBookTour = registrationList(idTour).size();
		logger.info("Number of registration are: " + numBookTour);
		return numBookTour;
	}

	@Override
	public Integer getNumBTBySearch(String value) {
		Integer numBookTour = registrationListByValue(value).size();
		logger.info("Number of registration are: " + numBookTour);
		return numBookTour;
	}

	@Override
	public Integer paginationX(Integer currentPage, Integer page) {
		return currentPage * page - page;
	}

	@Override
	public Integer paginationY(Integer numOfPage, Integer currentPage, Integer page) {
		Integer y = 0;
		if (numOfPage < currentPage * page) {
			y = numOfPage % 10;
			if (y > page) {
				y = paginationX(currentPage, page) + (y - page);
			} else {
				y = paginationX(currentPage, page) + y;
			}
		} else {
			y = paginationX(currentPage, page) + page;
		}
		return y;
	}
}
