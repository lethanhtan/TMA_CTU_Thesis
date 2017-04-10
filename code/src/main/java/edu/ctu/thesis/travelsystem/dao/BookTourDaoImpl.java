package edu.ctu.thesis.travelsystem.dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.extra.ConfirmCode;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.BookTourNext;
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
				bookTour.setConfirmCode(ConfirmCode.generateCode(12));
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

	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> registrationListByValue(String value, int idTour) {
		Session session = getCurrentSession();
		String hql = "FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = false AND (cusName LIKE :value OR cusEmail LIKE :value OR cusPhone LIKE :value OR cusIdCard LIKE :value)";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		query.setParameter("value", "%" + value + "%");
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> bookTourList() {
		Session session = getCurrentSession();
		String hql = "FROM BookTour";
		List<BookTour> bookTourList = session.createQuery(hql).list();
		for (BookTour bookTour : bookTourList) {
			if (bookTour.getTour().getDepartureDate().before(Calendar.getInstance().getTime())) {
				bookTour.setGoneOrNot(true);
			} else {
				bookTour.setGoneOrNot(false);
			}
			// bookTourService.editBookTour(bookTour);
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
		int quantum = tour.getQuantum();
		int numTicketAvailability = quantum;
		logger.info("Total Ticket: " + quantum);
		for (int i = 0; i <= quantum; i++) {
			numTicketAvailability = quantum - numTicketBooked;
		}
		return numTicketAvailability;
	}

	@Override
	public List<BookTour> registrationInfoByValue(String value, int idTour) {
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
	public void cancelBookTour(int idBT) {
		Session session = getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new Integer(idBT));
		if (bookTour != null) {
			Query query = session.createQuery("UPDATE BookTour SET " + "TICKET_CANCEL = :ticketCancel,"
					+ "CUS_CANCEL = true," + "CUS_NUMOFTICKET = 0" + "WHERE ID_BT = :idBT");
			query.setParameter("idBT", idBT);
			query.setParameter("ticketCancel", bookTour.getCusNumOfTicket());
			query.executeUpdate();
			session.saveOrUpdate(bookTour);
			session.flush();
			logger.info("Delete customer success!");
		}
	}

	// List all booktour with specifices year
	@Override
	public List<BookTour> listTourByYear(int year) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Date d1 = new Date();
		try {
			d1 = sdf.parse("01/01/" + year);
		} catch (ParseException e) {
			logger.error("Occured ex", e);
		}
		Date d2 = new Date();
		try {
			d2 = sdf.parse("31/12/" + year);
		} catch (ParseException e) {
			logger.error("Occured ex", e);
		}
		List<BookTour> listBookTour = new ArrayList<BookTour>();
		for (BookTour bookTour : bookTourList()) {
			if (bookTour.getDateBook().after(d1) && bookTour.getDateBook().before(d2)) {
				listBookTour.add(bookTour);
				logger.info("Added success!");
			}
		}
		return listBookTour;
	}

	// List number of tour sales with a month
	@SuppressWarnings("deprecation")
	@Override
	public int listBookTourByMonth(int month, List<BookTour> list) {
		int sales = 0;
		for (BookTour bookTour : list) {
			if (bookTour.getDateBook().getMonth() + 1 == month) {
				sales += bookTour.getCusNumOfTicket();
			}
		}
		return sales;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> listBookTourById(int idTour) {
		Session session = getCurrentSession();
		String hql = "FROM BookTour WHERE ID_TOUR = :idTour";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		List<BookTour> bookTourList = query.list();
		for (BookTour bookTour : bookTourList) {
			logger.info("Book tour List:" + bookTour);
		}
		return bookTourList;
	}

	@Override
	public void saveBookTourNext(List<BookTourNext> bookTourNext, int idBT) {
		Session session = getCurrentSession();
		if (bookTourNext != null) {
			try {
				for (BookTourNext bookTour : bookTourNext) {
					logger.info("Save book tour be called!");
					session.saveOrUpdate(bookTour);
					session.flush();
				}
			} catch (Exception e) {
				logger.error("Occured ex", e);
			}
		}
	}
}
