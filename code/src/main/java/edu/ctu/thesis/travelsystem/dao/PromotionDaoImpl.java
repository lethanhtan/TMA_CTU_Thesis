package edu.ctu.thesis.travelsystem.dao;

import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.Promotion;

@Service
public class PromotionDaoImpl extends AbstractDao implements PromotionDao {

	private static final Logger logger = Logger.getLogger(PromotionDaoImpl.class);
	
	@Override
	public void savePromotion(Promotion promotion) {
		Session session = getCurrentSession();
		try {
			Date date = new Date();
			promotion.setCreateDate(date);
			promotion.setCreateTime(date);
			session.save(promotion);
			session.flush();
		} catch (NullPointerException e) {
			logger.info("Null promotion object!");
		}
	}

	@Override
	public void deletePromotion(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Promotion> listPromotion() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Promotion findPromotion(int idTour) {
		Session session = getCurrentSession();
		Query query = session.createQuery("from Promotion as p where p.tour.idTour = :idTour");
		query.setParameter("idTour", idTour);
		return (Promotion) query.uniqueResult();
	}

	@Override
	public void updatePromotion(Promotion promotion) {
		Session session = getCurrentSession();
		try {
			session.update(promotion);
			session.flush();
		} catch (NullPointerException e) {
			logger.info("Null promotion object for update Promotion!");
		}
	}

}
