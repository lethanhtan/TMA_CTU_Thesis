package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.apache.log4j.Logger;
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

}
