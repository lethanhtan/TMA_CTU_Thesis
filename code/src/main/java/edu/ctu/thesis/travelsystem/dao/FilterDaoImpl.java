package edu.ctu.thesis.travelsystem.dao;

import java.util.Calendar;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.BookTour;

@Service
public class FilterDaoImpl extends AbstractDao implements FilterDao {
	private static final Logger logger = LoggerFactory.getLogger(FilterDaoImpl.class);

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
}
