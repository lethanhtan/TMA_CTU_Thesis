package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.BookTour;

@Service
public class FilterDaoImpl extends AbstractDao implements FilterDao {

	// Display registration list when filter by sex
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> regListByFilterSex(String filterSex, int idTour) {
		Session session = getCurrentSession();
		String hql = null;
		Query query = 	null;
		if (filterSex.equals("Nam") || filterSex.equals("Nữ")) {
		hql = "FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = false AND CUS_SEX = :filterSex";
		query = session.createQuery(hql);
		query.setParameter("filterSex", filterSex);
		} else {
			hql = "FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = false";
			query = session.createQuery(hql);
		}
		query.setParameter("idTour", idTour);
		return query.list();
	}

	// Display registration list when filter by number of ticket
	@Override
	public List<BookTour> regListByFilterTicket(int filterTicket, int idTour) {
		Session session = getCurrentSession();
		String hql = "FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = false AND CUS_NUMOFTICKET = :filterTicket";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		query.setParameter("filterTicket", filterTicket);
		@SuppressWarnings("unchecked")
		List<BookTour> regListByFilterTicket = query.list();
		return regListByFilterTicket;
	}

	// Display cancel list when filter by sex
	@Override
	public List<BookTour> cancelListByFilterSex(String filterSex, int idTour) {
		Session session = getCurrentSession();
		String hql = "FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = true AND CUS_SEX = :filterSex";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		query.setParameter("filterSex", filterSex);
		@SuppressWarnings("unchecked")
		List<BookTour> cancelListByFilterSex = query.list();
		return cancelListByFilterSex;
	}

	// Display cancel list when filter by number of ticket
	@Override
	public List<BookTour> cancelListByFilterTicket(int filterTicket, int idTour) {
		Session session = getCurrentSession();
		String hql = "FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = true AND TICKET_CANCEL = :filterTicket";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		query.setParameter("filterTicket", filterTicket);
		@SuppressWarnings("unchecked")
		List<BookTour> cancelListByFilterTicket = query.list();
		return cancelListByFilterTicket;
	}
}
