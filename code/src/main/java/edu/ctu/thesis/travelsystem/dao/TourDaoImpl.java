package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.extra.GenerateId;
import edu.ctu.thesis.travelsystem.model.Tour;

@Service
public class TourDaoImpl implements TourDao {
	GenerateId gid = new GenerateId();

	// Fill the fields automatically
	@Autowired
	private SessionFactory sessionFactory;

	private static final Logger logger = LoggerFactory.getLogger(TourDaoImpl.class);

	// Create tour
	@Override
	public void saveTour(Tour tour) {
		Session session = this.sessionFactory.getCurrentSession();
		if (tour != null) {
			try {
				logger.info("Save tour be called!");
				tour.setIdTour(gid.generateIdTour());
				session.saveOrUpdate(tour);
				session.flush();
			} catch (Exception e) {
				logger.info("Exception when call save tour!");
				e.printStackTrace();
			}
		}
	}

	@Override
	public Tour findTourById(String idTour) {
		Session session = this.sessionFactory.getCurrentSession();
		Tour tour = new Tour();
		logger.info("Tour infor: " + idTour);
		String hql = "from edu.ctu.thesis.travelsystem.model.Tour as t where t.idTour =?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, idTour);
			tour = (Tour) query.uniqueResult();
		} catch (Exception e) {
			logger.info("Exception when find tour!");
			//e.printStackTrace();
		}
		return tour;
	}

	@Override
	public Tour findTourByName(String name) {
		Session session = this.sessionFactory.getCurrentSession();
		Tour tour = (Tour) session.load(Tour.class, new String(name));
		logger.info("Tour loaded successfully!");
		return tour;
	}

	@Override
	public void updateTour(Tour tour) {
		Session session = this.sessionFactory.getCurrentSession();
		if (tour != null) {
			try {
				session.update(tour);
				session.flush();
				logger.info("Tour updated successfully, Tour details = " + tour);
			} catch (Exception e) {
				logger.info("Exception when update tour!");
				e.printStackTrace();
			}
		}
	}

	@Override
	public void deleteTour(String idTour) {
		Session session = this.sessionFactory.getCurrentSession();
		Tour tour = (Tour) session.load(Tour.class, new String(idTour));
		if (tour != null) {
			session.delete(tour);
			session.flush();
			logger.info("Tour deleted successfully!");
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Tour> listTour() {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from edu.ctu.thesis.travelsystem.model.Tour";
		List<Tour> tourList = session.createQuery(hql).list();
		for(Tour tour : tourList){
			logger.info("Tour List:" + tour);
		}
		return tourList;
	}

	@Override
	public List<Tour> listTourByValue(String value) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from edu.ctu.thesis.travelsystem.model.Tour as t where t.idTour like :value "
				+ "or t.name like :value ";
		Query query = session.createQuery(hql);
		query.setParameter("value", "%"+value+"%");
		@SuppressWarnings("unchecked")
		List<Tour> tourList = query.list();
		return tourList;
	}

	@Override
	public Integer getNumTour() {
		Integer numTour = listTour().size();
		logger.info("Number of tour is: " + numTour);
		return numTour;
	}

	@Override
	public Integer getNumTourBySearch(String value) {
		Integer numTour = listTourByValue(value).size();
		logger.info("Number of tour is: " + numTour);
		return numTour;
	}

	@Override
	public Integer paginationX(Integer currentPage, Integer page) {
		return currentPage*page - page;
	}

	@Override
	public Integer paginationY(Integer numOfPage, Integer currentPage, Integer page) {
		Integer y = 0;
		if (numOfPage < currentPage * page){
			y = numOfPage % 10;
			if (y > page) {
				y = paginationX(currentPage,page) + (y - page);
			}
			else{
				y = paginationX(currentPage,page) + y;
			}
		}
		else{
			y = paginationX(currentPage,page) + page;
		}
		
		return y;
	}

}
