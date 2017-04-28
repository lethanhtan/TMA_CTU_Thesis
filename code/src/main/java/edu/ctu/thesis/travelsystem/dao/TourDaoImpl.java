package edu.ctu.thesis.travelsystem.dao;

import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.extra.DaysBetween;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;

@Service
public class TourDaoImpl extends AbstractDao implements TourDao {
	@Autowired
	private BookTourDao bookTourDao;
	DaysBetween daysBetween = new DaysBetween();
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
				tour.setHowLong(daysBetween.daysBetween(tour.getReturnDate(), tour.getDepartureDate()));
				tour.setPriceAfterSale(tour.getPrice());
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
		try {
			session.update(tour);
			session.flush();
			logger.info("Tour updated successfully, Tour details = " + tour);
		} catch (Exception e) {
			logger.error("Occured ex", e);
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteTour(int idTour) {
		Session session = getCurrentSession();
		Tour tour = (Tour) session.load(Tour.class, new Integer(idTour));
		Query query = session.createQuery("FROM Tour WHERE ID_TOUR = :idTour");
		query.setParameter("idTour", idTour);
		Query query2 = session.createQuery("FROM BookTour WHERE ID_TOUR = :idTour");
		query2.setParameter("idTour", idTour);
		List<BookTour> bookTourList = query2.list();
		for (BookTour bookTour : bookTourList) {
			session.delete(bookTour);
			logger.info("Delete book tour successfully!");
		}
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
		String hql = "FROM Tour ORDER BY ID_TOUR DESC";
		List<Tour> tourList = session.createQuery(hql).list();
		for (Tour tour : tourList) {
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
			Integer price = Integer.valueOf(tour.getPrice().replaceAll(",", ""));
			DecimalFormat formatter = new DecimalFormat("#,###");
			tour.setPriceAfterSale(formatter.format((price - (price * tour.getPromotion().getPercent() / 100))));
			updateTour(tour);
			logger.info("Tour List:" + tour);
		}
		return tourList;
	}

	@Override
	public List<Tour> listTourByValue(String value) {
		Session session = getCurrentSession();
		String hql = "from Tour as t where t.name like :value ORDER BY ID_TOUR DESC";
		Query query = session.createQuery(hql);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<Tour> tourList = query.list();
		return tourList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> showTourList() {
		Session session = getCurrentSession();
		String hql = "FROM Tour WHERE full_or_not = false AND reg_or_not = true ORDER BY view DESC";
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
			Integer price = Integer.valueOf(tour.getPrice().replaceAll(",", ""));
			DecimalFormat formatter = new DecimalFormat("#,###");
			tour.setPriceAfterSale(formatter.format((price - (price * tour.getPromotion().getPercent() / 100))));
			updateTour(tour);
			logger.info("Tour List:" + tour);
		}
		return showTourList;
	}

	@Override
	public List<Tour> tourListByValue(String value) {
		System.out.println(value.contains(value));
		Session session = getCurrentSession();
		String hql = "FROM Tour WHERE full_or_not = false AND reg_or_not = true AND name LIKE :value ORDER BY ID_TOUR DESC";
		Query query = session.createQuery(hql);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<Tour> tourList = query.list();
		return tourList;
	}

	@Override
	public List<Tour> listTourByYear(int year) {
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

	@Override
	public void addView(Tour tour) {
		Session session = getCurrentSession();
		tour.setView(tour.getView() + 1);
		logger.info("Update tour view!");
		updateTour(tour);
		session.flush();
	}
}
