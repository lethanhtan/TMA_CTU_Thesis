package edu.ctu.thesis.travelsystem.dao;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Relationship;
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

	// Delete booked tour
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

	// Display cancel registration list match with keyword administrator typed
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

	// Undo registration information was canceled
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

	// Get the first element in group by relationship
	@Override
	public BookTour getFirstElement(int relationship) {
		Session session = getCurrentSession();
		Query query = session.createQuery(
				"FROM BookTour o WHERE o.relationship = :relationship GROUP BY o.relationship HAVING o.idBT = MIN(o.idBT)");
		query.setParameter("relationship", relationship);
		BookTour bookTour = (BookTour) query.uniqueResult();
		return bookTour;
	}

	// Cancel all booked tour when have the same relationship
	@Override
	public void cancelAllBookTour(int idBT, int relationship) {
		Session session = getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new Integer(idBT));
		if (bookTour != null) {
			Query query = session.createQuery("UPDATE BookTour o SET " + "o.ticketCancel = :ticketCancel,"
					+ "o.cusCancel = true," + "o.cusNumOfTicket = 0" + "WHERE o.relationship = :relationship");
			query.setParameter("relationship", relationship);
			query.setParameter("ticketCancel", bookTour.getCusNumOfTicket());
			query.executeUpdate();
			session.saveOrUpdate(bookTour);
			session.flush();
			logger.info("Delete customer success!");
		}
	}

	// Display registration list by Id tour
	@SuppressWarnings("unchecked")
	@Override
	public List<Relationship> relationshipList() {
		Session session = getCurrentSession();
		Query query = session.createQuery("FROM Relationship");
		List<Relationship> relationshipList = query.list();
		return relationshipList;
	}

	// Save relationship
	@Override
	public void saveRelationship(Relationship relationship) {
		Session session = getCurrentSession();
		if (relationship != null) {
			try {
				session.saveOrUpdate(relationship);
				session.flush();
			} catch (Exception e) {
				logger.error("Occured ex", e);
			}
		}
	}

	// Delete relationship
	@Override
	public void deleteRelationship(int id) {
		Session session = getCurrentSession();
		Relationship relationship = (Relationship) session.load(Relationship.class, new Integer(id));
		if (relationship != null) {
			Query query = session.createQuery("FROM Relationship WHERE Id = :id");
			query.setParameter("id", relationship.getId());
			session.delete(relationship);
			session.flush();
			logger.info("Delete customer success!");
		}
	}
}
