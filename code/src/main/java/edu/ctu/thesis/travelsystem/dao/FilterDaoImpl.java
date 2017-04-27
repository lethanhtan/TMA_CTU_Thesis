package edu.ctu.thesis.travelsystem.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Promotion;
import edu.ctu.thesis.travelsystem.model.Tour;
import edu.ctu.thesis.travelsystem.service.TourService;

@Service
public class FilterDaoImpl extends AbstractDao implements FilterDao {
	@Autowired
	TourService tourService;

	private static final String SEPARATOR = ", ";

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
		StringBuilder listOfTourId = new StringBuilder();
		String separator = "";
		switch (filterPrice) {
		case "All": {
			query = session.createQuery("FROM Tour");
			break;
		}
		case "5": {
			for (Tour tour : tourList) {
				int price = Integer.parseInt(tour.getPrice().replaceAll(",", ""));
				if (price < 500000) {
					listOfTourId.append(separator);
					listOfTourId.append(tour.getIdTour());
					separator = SEPARATOR;
				}
			}
			query = session.createQuery("FROM Tour WHERE Id_Tour IN (" + listOfTourId + ")");
			break;
		}
		case "10": {
			for (Tour tour : tourList) {
				int price = Integer.parseInt(tour.getPrice().replaceAll(",", ""));
				if (price >= 500000 && price < 1000000) {
					listOfTourId.append(separator);
					listOfTourId.append(tour.getIdTour());
					separator = SEPARATOR;
				}
			}
			query = session.createQuery("FROM Tour WHERE Id_Tour IN (" + listOfTourId + ")");
			break;
		}
		case "20": {
			for (Tour tour : tourList) {
				int price = Integer.parseInt(tour.getPrice().replaceAll(",", ""));
				if (price >= 1000000 && price < 2000000) {
					listOfTourId.append(separator);
					listOfTourId.append(tour.getIdTour());
					separator = SEPARATOR;
				}
			}
			query = session.createQuery("FROM Tour WHERE Id_Tour IN (" + listOfTourId + ")");
			break;
		}
		default: {
			for (Tour tour : tourList) {
				int price = Integer.parseInt(tour.getPrice().replaceAll(",", ""));
				if (price >= 2000000) {
					listOfTourId.append(separator);
					listOfTourId.append(tour.getIdTour());
					separator = SEPARATOR;
				}
			}
			query = session.createQuery("FROM Tour WHERE Id_Tour IN (" + listOfTourId + ")");
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
		Query query1 = null;
		switch (filterSale) {
		case "All": {
			query = session.createQuery("FROM Tour");
			break;
		}
		case "10": {
			query1 = session.createQuery("FROM Promotion WHERE Percent = 10");
			List<Promotion> promotionList = query1.list();
			for (Promotion promotion : promotionList) {
				int id = promotion.getTour().getIdTour();
				query = session.createQuery("FROM Tour WHERE Id_Tour = :idTour");
				query.setParameter("idTour", promotion.getTour().getIdTour());
			}
			break;
		}
		case "20": {
			query1 = session.createQuery("FROM Promotion WHERE Percent = 20");
			List<Promotion> promotionList = query1.list();
			for (Promotion promotion : promotionList) {
				// int id = promotion.getTour().getIdTour();
				query = session.createQuery("FROM Tour WHERE Id_Tour = :idTour");
				query.setParameter("idTour", promotion.getTour());
			}
			break;
		}
		case "30": {
			query1 = session.createQuery("FROM Promotion WHERE Percent = 30");
			List<Promotion> promotionList = query1.list();
			for (Promotion promotion : promotionList) {
				query = session.createQuery("FROM Tour WHERE Id_Tour = :idTour");
				query.setParameter("idTour", promotion.getTour().getIdTour());
			}
			break;
		}
		default: {
			query1 = session.createQuery("FROM Promotion WHERE Percent = 50");
			List<Promotion> promotionList = query1.list();
			for (Promotion promotion : promotionList) {
				query = session.createQuery("FROM Tour WHERE Id_Tour = :idTour");
				query.setParameter("idTour", promotion.getTour().getIdTour());
			}
		}
			break;
		}
		return query.list();
	}
}
