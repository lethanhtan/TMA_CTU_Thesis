package edu.ctu.thesis.travelsystem.dao;

import java.util.Calendar;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.RegistrationInfo;
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
		String hql = "FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = false";
		Query query = session.createQuery(hql);
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
	public Integer getNumBookTour(int idTour) {
		Integer numBookTour = registrationList(idTour).size();
		logger.info("Number of registration are: " + numBookTour);
		return numBookTour;
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

	// Save book tour form when have id tour
	@Override
	public void saveRegInfoForm(RegistrationInfo regInfo, int idTour) {
		Session session = getCurrentSession();
		if (regInfo != null) {
			try {
				logger.info("Update design form be called!");
				session.merge(regInfo);
				session.flush();
			} catch (Exception e) {
				logger.error("Occured ex", e);
			}
		}
	}

	@Override
	public RegistrationInfo searchRegInfoById(int idTour) {
		Session session = getCurrentSession();
		RegistrationInfo regInfo = new RegistrationInfo();
		logger.info("Registration infor: " + idTour);
		String hql = "FROM edu.ctu.thesis.travelsystem.model.RegistrationInfo WHERE idTour = ?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, idTour);
			regInfo = (RegistrationInfo) query.uniqueResult();
		} catch (Exception e) {
			logger.error("Occured ex", e);
		}
		return regInfo;
	}

	// Display registration list by Id tour
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> cancelList(int idTour) {
		Session session = getCurrentSession();
		String hql = "FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = true";
		Query query = session.createQuery(hql);
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
		String hql = "FROM BookTour WHERE ID_TOUR := idTour AND CUS_CANCEL = true AND (cusName LIKE :value OR cusEmail LIKE :value OR cusPhone LIKE :value OR cusIdCard LIKE :value)";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<BookTour> cancelList = query.list();
		return cancelList;
	}

	@Override
	public Integer getNumCancelReg(int idTour) {
		Integer numCancelReg = cancelList(idTour).size();
		logger.info("Number of registration are: " + numCancelReg);
		return numCancelReg;
	}

	@Override
	public Integer getNumCancelBySearch(String value, int idTour) {
		Integer numCancel = cancelListByValue(value, idTour).size();
		logger.info("Number of registration are: " + numCancel);
		return numCancel;
	}

	@Override
	public void undoCancel(int idBT, int idTour) {
		Session session = getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new Integer(idBT));
		if (bookTour != null) {
			Query query = session.createQuery("UPDATE BookTour SET " + "CUS_NUMOFTICKET = :cusNumOfTicket,"
					+ "CUS_CANCEL = false," + "TICKET_CANCEL = 0" + "WHERE ID_BT = :idBT");
			query.setParameter("idBT", bookTour.getIdBT());
			query.setParameter("cusNumOfTicket", bookTour.getTicketCancel());
			query.executeUpdate();
			session.saveOrUpdate(bookTour);
			session.flush();
			logger.info("Delete customer success!");
		}
	}
}
