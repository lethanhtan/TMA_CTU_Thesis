package edu.ctu.thesis.travelsystem.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.TourService;

@Service
public class FilterDaoImpl extends AbstractDao implements FilterDao {
	@Autowired
	TourService tourService;

	private static final String SEPARATOR = ", ";
	private static StringBuilder listOfTourId = new StringBuilder();
	private static String separator = "";

	// Display registration list when filter by sex
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> regListByFilterSex(String filterSex, int idTour) {
		Session session = getCurrentSession();
		Query query = null;
		if (filterSex.equals("Nam") || filterSex.equals("Nữ")) {
			query = session.createQuery(
					"FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = false AND Cus_Sex = :filterSex");
			query.setParameter("filterSex", filterSex);
		} else {
			query = session.createQuery("FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = false");
		}
		query.setParameter("idTour", idTour);
		return query.list();
	}

	// Display cancel list when filter by sex
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> cancelListByFilterSex(String filterSex, int idTour) {
		Session session = getCurrentSession();
		Query query = null;
		if (filterSex.equals("Nam") || filterSex.equals("Nữ")) {
			query = session.createQuery(
					"FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = true AND Cus_Sex = :filterSex");
			query.setParameter("filterSex", filterSex);
		} else {
			query = session.createQuery("FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = true");
		}
		query.setParameter("idTour", idTour);
		return query.list();
	}

	// Display registration list when filter by age
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> regListByFilterAge(String filterAge, int idTour) {
		Session session = getCurrentSession();
		Query query = null;
		int now = Calendar.getInstance().get(Calendar.YEAR);
		switch (filterAge) {
		case "All": {
			query = session.createQuery("FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = false");
			break;
		}
		case "18": {
			query = session.createQuery(
					"FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = false AND Cus_YearOfBirth > :yearOfBirth");
			query.setParameter("yearOfBirth", now - 18);
			break;
		}
		case "40": {
			query = session.createQuery("FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = false "
					+ "AND Cus_YearOfBirth <= :min AND Cus_YearOfBirth >= :max");
			query.setParameter("min", now - 18);
			query.setParameter("max", now - 40);
			break;
		}
		case "60": {
			query = session.createQuery("FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = false "
					+ "AND Cus_YearOfBirth <= :min AND Cus_YearOfBirth >= :max");
			query.setParameter("min", now - 41);
			query.setParameter("max", now - 60);
			break;
		}
		default: {
			query = session.createQuery(
					"FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = false AND Cus_YearOfBirth < :yearOfBirth");
			query.setParameter("yearOfBirth", now - 60);
		}
		}
		query.setParameter("idTour", idTour);
		return query.list();
	}

	// Display cancel list when filter by age
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> cancelListByFilterAge(String filterAge, int idTour) {
		Session session = getCurrentSession();
		Query query = null;
		int now = Calendar.getInstance().get(Calendar.YEAR);
		switch (filterAge) {
		case "All": {
			query = session.createQuery("FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = true");
			break;
		}
		case "18": {
			query = session.createQuery(
					"FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = true AND Cus_YearOfBirth > :yearOfBirth");
			query.setParameter("yearOfBirth", now - 18);
			break;
		}
		case "40": {
			query = session.createQuery("FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = true "
					+ "AND Cus_YearOfBirth <= :min AND Cus_YearOfBirth >= :max");
			query.setParameter("min", now - 18);
			query.setParameter("max", now - 40);
			break;
		}
		case "60": {
			query = session.createQuery("FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = true "
					+ "AND Cus_YearOfBirth <= :min AND Cus_YearOfBirth >= :max");
			query.setParameter("min", now - 41);
			query.setParameter("max", now - 60);
			break;
		}
		default: {
			query = session.createQuery(
					"FROM BookTour WHERE Id_Tour = :idTour AND Cus_Cancel = true AND Cus_YearOfBirth < :yearOfBirth");
			query.setParameter("yearOfBirth", now - 60);
		}
		}
		query.setParameter("idTour", idTour);
		return query.list();
	}

	// Display tour list when filter by price
	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> tourListByFilterPrice(String filterPrice) {
		Session session = getCurrentSession();
		Query query = null;
		List<Tour> tourList = tourService.listTour();
		switch (filterPrice) {
		case "All": {
			query = session.createQuery("FROM Tour WHERE full_or_not = false AND reg_or_not = true");
			break;
		}
		case "5": {
			for (Tour tour : tourList) {
				int price = Integer.parseInt(tour.getPrice().replaceAll(",", ""));
				if (price < 500000) {
					separator = getMultiId(listOfTourId, separator, tour);
				}
			}
			query = session.createQuery(
					"FROM Tour WHERE Id_Tour IN (" + listOfTourId + ") AND full_or_not = false AND reg_or_not = true");
			break;
		}
		case "10": {
			for (Tour tour : tourList) {
				int price = Integer.parseInt(tour.getPrice().replaceAll(",", ""));
				if (price >= 500000 && price < 1000000) {
					separator = getMultiId(listOfTourId, separator, tour);
				}
			}
			query = session.createQuery(
					"FROM Tour WHERE Id_Tour IN (" + listOfTourId + ") AND full_or_not = false AND reg_or_not = true");
			break;
		}
		case "20": {
			for (Tour tour : tourList) {
				int price = Integer.parseInt(tour.getPrice().replaceAll(",", ""));
				if (price >= 1000000 && price < 2000000) {
					separator = getMultiId(listOfTourId, separator, tour);
				}
			}
			query = session.createQuery(
					"FROM Tour WHERE Id_Tour IN (" + listOfTourId + ") AND full_or_not = false AND reg_or_not = true");
			break;
		}
		default: {
			for (Tour tour : tourList) {
				int price = Integer.parseInt(tour.getPrice().replaceAll(",", ""));
				if (price >= 2000000) {
					separator = getMultiId(listOfTourId, separator, tour);
				}
			}
			query = session.createQuery(
					"FROM Tour WHERE Id_Tour IN (" + listOfTourId + ") AND full_or_not = false AND reg_or_not = true");
		}
		}
		return query.list();
	}

	// Display tour list when filter by sale
	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> tourListByFilterSale(String filterSale) {
		Session session = getCurrentSession();
		Query query = null;
		List<Tour> tourList = tourService.listTour();
		switch (filterSale) {
		case "All": {
			query = session.createQuery("FROM Tour WHERE full_or_not = false AND reg_or_not = true");
			break;
		}
		case "10": {
			for (Tour tour : tourList) {
				int percent = tour.getPromotion().getPercent();
				if (percent == 10) {
					separator = getMultiId(listOfTourId, separator, tour);
				}
			}
			query = session.createQuery(
					"FROM Tour WHERE Id_Tour IN (" + listOfTourId + ") AND full_or_not = false AND reg_or_not = true");
			break;
		}
		case "20": {
			for (Tour tour : tourList) {
				int percent = tour.getPromotion().getPercent();
				if (percent == 20) {
					separator = getMultiId(listOfTourId, separator, tour);
				}
			}
			query = session.createQuery(
					"FROM Tour WHERE Id_Tour IN (" + listOfTourId + ") AND full_or_not = false AND reg_or_not = true");
			break;
		}
		case "30": {
			for (Tour tour : tourList) {
				int percent = tour.getPromotion().getPercent();
				if (percent == 30) {
					separator = getMultiId(listOfTourId, separator, tour);
				}
			}
			query = session.createQuery(
					"FROM Tour WHERE Id_Tour IN (" + listOfTourId + ") AND full_or_not = false AND reg_or_not = true");
			break;
		}
		default: {
			for (Tour tour : tourList) {
				int percent = tour.getPromotion().getPercent();
				if (percent == 50) {
					separator = getMultiId(listOfTourId, separator, tour);
				}
			}
			query = session.createQuery(
					"FROM Tour WHERE Id_Tour IN (" + listOfTourId + ") AND full_or_not = false AND reg_or_not = true");
		}
			break;
		}
		return query.list();
	}

	// Get tour list by IN clause to replace many OR conditions (Id tour)
	private String getMultiId(StringBuilder listOfTourId, String separator, Tour tour) {
		listOfTourId.append(separator);
		listOfTourId.append(tour.getIdTour());
		separator = SEPARATOR;
		return separator;
	}
}
