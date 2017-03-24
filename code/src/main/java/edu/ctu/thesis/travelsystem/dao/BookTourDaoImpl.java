package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;

@Service
public class BookTourDaoImpl extends AbstractDao implements BookTourDao {
	// Fill the fields automatically
	private static final Logger logger = Logger.getLogger(BookTourDaoImpl.class);
	private TourDao tourDao;

	// Save book tour form when have id tour
	@Override
	public void saveBookTour(BookTour bookTour, int idTour) {
		Session session = getCurrentSession();
		if (bookTour != null) {
			try {
				logger.info("Save book tour be called!");
				session.saveOrUpdate(bookTour);
				session.flush();
			} catch (Exception e) {
				logger.error("Occured ex", e);
			}
		}
	}

	// Search information of customer booked tour by Id
	@Override
	public BookTour searchById(int idBT) {
		Session session = getCurrentSession();
		BookTour bookTour = new BookTour();
		logger.info("Information of customer have ID: " + idBT);
		String hql = "FROM BookTour WHERE idBT = ?";
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
		Session session = getCurrentSession();
		if (bookTour != null) {
			try {
				session.update(bookTour);
				session.flush();
				logger.info("Edit information of customer booked tour successfully: " + bookTour);
			} catch (Exception e) {
				logger.error("Occured ex", e);
			}
		}
	}

	@Override
	public List<BookTour> registrationListByValue(String value, int idTour) {
		System.out.println(value.contains(value));
		Session session = getCurrentSession();
		String hql = "FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = false AND (cusName LIKE :value OR cusEmail LIKE :value OR cusPhone LIKE :value OR cusIdCard LIKE :value)";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<BookTour> registrationList = query.list();
		return registrationList;
	}

	@Override
	public Integer getNumBTBySearch(String value, int idTour) {
		Integer numBookTour = registrationListByValue(value, idTour).size();
		logger.info("Number of registration are: " + numBookTour);
		return numBookTour;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> listBookTour() {
		Session session = getCurrentSession();
		String hql = "FROM BookTour";
		List<BookTour> bookTourList = session.createQuery(hql).list();
		for (BookTour bookTour : bookTourList) {
			logger.info("Tour List:" + bookTour);
		}
		return bookTourList;
	}

	@Override
	public int getNumTicketBooked(int idTour) {
		int numTicketBooked = 0;
		Session session = getCurrentSession();
		String hql = "SELECT SUM(o.cusNumOfTicket) FROM BookTour o WHERE o.tour.id = :idTour";
		logger.info(session);
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		Object obj = query.uniqueResult();
		try {
			if (obj != null) {
				numTicketBooked = ((Long) obj).intValue();
				logger.info("Total ticket booked: " + numTicketBooked);
			}
		} catch (Exception e) {
			logger.error("Occured ex", e);
		}
		logger.info("Number of Ticket are booked: " + numTicketBooked);
		return numTicketBooked;
	}

	@Override
	public int getNumTicketAvailability(int idTour) {
		int numTicketBooked = getNumTicketBooked(idTour);
		logger.info("Number of ticket are booked: " + numTicketBooked);
		Tour tour = tourDao.findTourById(idTour);
		int numTicketAvailability = tour.getQuantum();
		int quantum = tour.getQuantum();
		logger.info("Total Ticket: " + quantum);
		for (int i = 0; i <= quantum; i++) {
			numTicketAvailability = quantum - numTicketBooked;
		}
		return numTicketAvailability;
	}

	@Override
	public List<BookTour> registrationInfoByValue(String value, int idTour) {
		System.out.println(value.contains(value));
		Session session = getCurrentSession();
		String hql = "FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = false AND (CUS_EMAIL = :value OR CUS_PHONE = :value OR CUS_IDCARD = :value)";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		query.setParameter("value", value);
		@SuppressWarnings("unchecked")
		List<BookTour> registrationInfo = query.list();
		return registrationInfo;
	}

	@Override
	public void cancelBookTour(int idBT, int idTour) {
		Session session = getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new Integer(idBT));
		if (bookTour != null) {
			Query query = session.createQuery("UPDATE BookTour SET " + "TICKET_CANCEL = :ticketCancel,"
					+ "CUS_CANCEL = true," + "CUS_NUMOFTICKET = 0" + "WHERE ID_BT = :idBT");
			query.setParameter("idBT", bookTour.getIdBT());
			query.setParameter("ticketCancel", bookTour.getCusNumOfTicket());
			query.executeUpdate();
			session.saveOrUpdate(bookTour);
			session.flush();
			logger.info("Delete customer success!");
		}
	}
}
