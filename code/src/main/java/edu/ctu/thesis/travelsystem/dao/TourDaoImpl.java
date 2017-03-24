package edu.ctu.thesis.travelsystem.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.RegistrationInfo;
import edu.ctu.thesis.travelsystem.model.Tour;

@Service
public class TourDaoImpl extends AbstractDao implements TourDao {
	@Autowired
	private BookTourDao bookTourDao;
	// Fill the fields automatically
	private static final Logger logger = LoggerFactory.getLogger(TourDaoImpl.class);

	// Create tour
	@Override
	public void saveTour(Tour tour) {
		Session session = getCurrentSession();
		if (tour != null) {
			try {
				logger.info("Save tour be called!");
				if (tour.getTicketAvailability() == null) {
					tour.setTicketAvailability(tour.getQuantum());
				}
				tour.setFullOrNot(false);
				tour.setRegOrNot(true);
				RegistrationInfo regInfo = new RegistrationInfo();
				regInfo.setFieldName(true);
				regInfo.setFieldSex(true);
				regInfo.setFieldEmail(true);
				regInfo.setFieldPhone(true);
				regInfo.setFieldAddress(true);
				regInfo.setFieldIdCard(false);
				regInfo.setFieldNumOfTicket(true);
				tour.setRegInfo(regInfo);
				Date d = new Date();
				Calendar ca = Calendar.getInstance();
				ca.setTime(d);
				tour.setYear(ca.get(Calendar.YEAR));
				tour.setMonth(ca.get(Calendar.MONTH));
				regInfo.setTour(tour);
				session.saveOrUpdate(tour);
				session.flush();
			} catch (Exception e) {
				logger.error("Occured ex", e);
			}
		}
	}

	@Override
	public Tour findTourById(int idTour) {
		Session session = getCurrentSession();
		Tour tour = new Tour();
		logger.info("Tour infor: " + idTour);
		String hql = "from Tour as t where t.idTour =?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, idTour);
			tour = (Tour) query.uniqueResult();
		} catch (Exception e) {
			logger.error("Occured ex", e);
		}
		return tour;
	}

	@Override
	public Tour findTourByName(String name) {
		Session session = getCurrentSession();
		Tour tour = (Tour) session.load(Tour.class, new String(name));
		logger.info("Tour loaded successfully!");
		return tour;
	}

	@Override
	public void updateTour(Tour tour) {
		Session session = getCurrentSession();
		if (tour != null) {
			try {
				session.update(tour);
				session.flush();
				logger.info("Tour updated successfully, Tour details = " + tour);
			} catch (Exception e) {
				logger.error("Occured ex", e);
			}
		}
	}

	@Override
	public void deleteTour(int idTour) {
		Session session = getCurrentSession();
		Tour tour = (Tour) session.load(Tour.class, new Integer(idTour));
		String hql = "DELETE FROM BookTour WHERE ID_TOUR = :idTour";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		if (tour != null) {
			session.delete(tour);
			session.flush();
			logger.info("Tour deleted successfully!");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> listTour() {
		Session session = getCurrentSession();
		String hql = "from Tour";
		List<Tour> tourList = session.createQuery(hql).list();
		for (Tour tour : tourList) {
			logger.info("Tour List:" + tour);
		}
		return tourList;
	}

	@Override
	public List<Tour> listTourByValue(String value) {
		Session session = getCurrentSession();
		String hql = "from Tour as t where t.name like :value";
		Query query = session.createQuery(hql);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<Tour> tourList = query.list();
		return tourList;
	}

	@Override
	public int getNumTour() {
		Integer numTour = listTour().size();
		logger.info("Number of tour is: " + numTour);
		return numTour;
	}

	@Override
	public int getNumTourBySearch(String value) {
		int numTour = listTourByValue(value).size();
		logger.info("Number of tour is: " + numTour);
		return numTour;
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

	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> showTourList() {
		Session session = getCurrentSession();
		String hql = "FROM Tour WHERE full_or_not = false AND reg_or_not = true";
		List<Tour> showTourList = session.createQuery(hql).list();
		for (Tour tour : showTourList) {
			// Sync noTicketAvailability
			Integer numTicketBooked = bookTourDao.getNumTicketBooked(tour.getIdTour());
			Integer newAvailability = tour.getQuantum() - numTicketBooked;
			if (tour.getTicketAvailability() != newAvailability) {
				tour.setTicketAvailability(newAvailability);
			}
			if (tour.getTicketAvailability() == 0) {
				tour.setFullOrNot(true);
			} else {
				tour.setFullOrNot(false);
			}
			if (tour.getDateAllowReg().before(Calendar.getInstance().getTime())) {
				tour.setRegOrNot(false);
			} else {
				tour.setRegOrNot(true);
			}
			if (tour.getDateAllowCancel().before(Calendar.getInstance().getTime())) {
				tour.setCancelOrNot(false);
			} else {
				tour.setCancelOrNot(true);
			}
			updateTour(tour);
			logger.info("Tour List:" + tour);
		}
		return showTourList;
	}
	/*
	 * if (tour != null && tour.getTicketAvailability() == 0) {
	 * tour.setFullOrNot(true); logger.info("Full or not: " +
	 * tour.getFullOrNot()); updateTour(tour); } else {
	 * tour.setFullOrNot(false); logger.info("Full or not: " +
	 * tour.getFullOrNot()); updateTour(tour); } if (tour != null &&
	 * tour.getDateAllowReg().before(Calendar.getInstance().getTime())) {
	 * tour.setRegOrNot(false); logger.info("Reg or not: " +
	 * tour.getRegOrNot()); updateTour(tour); } else { tour.setRegOrNot(true);
	 * logger.info("Reg or not: " + tour.getRegOrNot()); updateTour(tour); } if
	 * (tour != null &&
	 * tour.getDateAllowCancel().before(Calendar.getInstance().getTime())) {
	 * tour.setCancelOrNot(false); logger.info("Reg or not: " +
	 * tour.getCancelOrNot()); updateTour(tour); } else {
	 * tour.setCancelOrNot(true); logger.info("Cancel or not: " +
	 * tour.getCancelOrNot()); updateTour(tour); }
	 */

	@Override
	public int getNumTourList() {
		Integer numTourList = showTourList().size();
		logger.info("Number of tour is: " + numTourList);
		return numTourList;
	}

	@Override
	public List<Tour> tourListByValue(String value) {
		Session session = getCurrentSession();
		String hql = "FROM Tour WHERE full_or_not = false AND reg_or_not = true AND name LIKE :value";
		Query query = session.createQuery(hql);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<Tour> tourList = query.list();
		return tourList;
	}

	@Override
	public List<Tour> listTourByYear(int year) {
		System.out.println(year);
		Session session = getCurrentSession();
		String hql = "from Tour as t where t.year = ?";
		Query query = session.createQuery(hql);
		query.setParameter(0, year);
		@SuppressWarnings("unchecked")
		List<Tour> tourList = query.list();
		for (Tour tour : tourList) {
			logger.info("Tour List:" + tour);
		}
		return tourList;
	}
}
