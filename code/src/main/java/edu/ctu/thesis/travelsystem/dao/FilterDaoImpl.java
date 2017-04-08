package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.BookTour;

@Service
public class FilterDaoImpl extends AbstractDao implements FilterDao {
	private static final Logger logger = Logger.getLogger(FilterDaoImpl.class);

	// Display registration list when filter by sex
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> regListByFilterSex(String filterSex, int idTour) {
		Session session = getCurrentSession();
		String hql = "FROM BookTour WHERE ID_TOUR = :idTour AND CUS_CANCEL = false AND CUS_SEX = :filterSex";
		Query query = session.createQuery(hql);
		query.setParameter("idTour", idTour);
		query.setParameter("filterSex", filterSex);
		return query.list();
	}

	// Get number of register when filter by sex
	@Override
	public Integer getNumRegFilterSex(String filterSex, int idTour) {
		Integer numRegFilterSex = regListByFilterSex(filterSex, idTour).size();
		logger.info("Number of registration are: " + numRegFilterSex);
		return numRegFilterSex;
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

	// Get number of register when filter by number of ticket
	@Override
	public Integer getNumRegFilterTicket(int filterTicket, int idTour) {
		Integer numRegFilterTicket = regListByFilterTicket(filterTicket, idTour).size();
		logger.info("Number of registration are: " + numRegFilterTicket);
		return numRegFilterTicket;
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

	// Get number of cancel register when filter by sex
	@Override
	public Integer getNumCancelFilterSex(String filterSex, int idTour) {
		Integer numCancelFilterSex = cancelListByFilterSex(filterSex, idTour).size();
		logger.info("Number of registration are: " + numCancelFilterSex);
		return numCancelFilterSex;
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

	// Get number of cancel register when filter by number of ticket
	@Override
	public Integer getNumCancelFilterTicket(int filterTicket, int idTour) {
		Integer numCancelFilterTicket = cancelListByFilterTicket(filterTicket, idTour).size();
		logger.info("Number of registration are: " + numCancelFilterTicket);
		return numCancelFilterTicket;
	}
}
