package edu.ctu.thesis.travelsystem.dao;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.BookTourService;

@Service
public class RegInfoDaoImpl extends AbstractDao implements RegInfoDao {
	@Autowired
	private BookTourService bookTourService;
	// Fill the fields automatically
	private static final Logger logger = Logger.getLogger(RegInfoDaoImpl.class);

	// Display registration list by Id tour
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> registrationList(int idTour) {
		Session session = getCurrentSession();
		Query query = session.createQuery("FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = false");
		query.setParameter("idTour", idTour);
		List<BookTour> registrationList = query.list();
		for (BookTour bookTour : registrationList) {
			if (bookTour.getTour().getDepartureDate().before(Calendar.getInstance().getTime())) {
				bookTour.setGoneOrNot(true);
			} else {
				bookTour.setGoneOrNot(false);
			}
			bookTourService.editBookTour(bookTour);
		}
		return registrationList;
	}

	@Override
	public void deleteBookTour(int idBT, int idTour) {
		Session session = getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new Integer(idBT));
		if (bookTour != null) {
			Query query = session.createQuery("UPDATE BookTour SET ID_TOUR = null WHERE ID_BT = :idBT");
			query.setParameter("idBT", bookTour.getIdBT());
			query.executeUpdate();
			session.delete(bookTour);
			session.flush();
			logger.info("Delete customer success!");
		}
	}

	// Display registration list by Id tour
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> cancelList(int idTour) {
		Session session = getCurrentSession();
		Query query = session.createQuery("FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = true");
		query.setParameter("idTour", idTour);
		List<BookTour> cancelList = query.list();
		for (BookTour bookTour : cancelList) {
			logger.info("Cancel registration list:" + bookTour);
		}
		return cancelList;
	}

	@Override
	public List<BookTour> cancelListByValue(String value, int idTour) {
		Session session = getCurrentSession();
		Query query = session.createQuery("FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = true "
				+ "AND (cusName LIKE :value OR cusEmail LIKE :value OR cusPhone LIKE :value OR cusIdCard LIKE :value)");
		query.setParameter("idTour", idTour);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<BookTour> cancelList = query.list();
		return cancelList;
	}

	@Override
	public void undoCancel(int idBT) {
		Session session = getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new Integer(idBT));
		if (bookTour != null) {
			Query query = session.createQuery("UPDATE BookTour SET " + "CUS_NUMOFTICKET = :cusNumOfTicket,"
					+ "CUS_CANCEL = false, TICKET_CANCEL = 0 WHERE id_BT = :idBT");
			query.setParameter("idBT", idBT);
			query.setParameter("cusNumOfTicket", bookTour.getTicketCancel());
			query.executeUpdate();
			session.saveOrUpdate(bookTour);
			session.flush();
			logger.info("Delete customer success!");
		}
	}

	// Add a new column to Tour table when design form
	@Override
	public void addFieldOption(String name, String type) {
		Session session = getCurrentSession();
		String sql = "ALTER TABLE BOOK_TOUR ADD " + name + " " + type;
		session.createSQLQuery(sql).addEntity(BookTour.class).executeUpdate();
		String sql2 = "ALTER TABLE TOUR ADD " + name + " " + "bit(1)";
		session.createSQLQuery(sql2).addEntity(Tour.class).executeUpdate();
		session.flush();
	}

	// Remove a column when design form
	@Override
	public void dropFieldOption(String name) {
		Session session = getCurrentSession();
		String sql = "ALTER TABLE BOOK_TOUR DROP " + name;
		session.createSQLQuery(sql).addEntity(BookTour.class).executeUpdate();
		String sql2 = "ALTER TABLE TOUR DROP " + name;
		session.createSQLQuery(sql2).addEntity(Tour.class).executeUpdate();
		session.flush();
	}

	@Override
	public BookTour getFirstElement(int relationship) {
		Session session = getCurrentSession();
		Query query = session.createQuery(
				"FROM BookTour WHERE Relationship = :relationship GROUP BY Relationship HAVING id_bt = MIN(id_bt)");
		query.setParameter("relationship", relationship);
		BookTour bookTour = (BookTour) query.uniqueResult();
		return bookTour;
	}

	@Override
	public void cancelAllBookTour(int idBT, int relationship) {
		Session session = getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new Integer(idBT));
		if (bookTour != null) {
			Query query = session.createQuery("UPDATE BookTour SET " + "TICKET_CANCEL = :ticketCancel,"
					+ "CUS_CANCEL = true," + "CUS_NUMOFTICKET = 0" + "WHERE Relationship = :relationship");
			query.setParameter("relationship", relationship);
			query.setParameter("ticketCancel", bookTour.getCusNumOfTicket());
			query.executeUpdate();
			session.saveOrUpdate(bookTour);
			session.flush();
			logger.info("Delete customer success!");
		}
	}
}
