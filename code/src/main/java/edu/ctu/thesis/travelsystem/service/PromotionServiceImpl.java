package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.ctu.thesis.travelsystem.dao.PromotionDao;
import edu.ctu.thesis.travelsystem.model.Promotion;

@Service
public class PromotionServiceImpl implements PromotionService {
	
	@Autowired
	PromotionDao promotionDao;
	
	@Override
	@Transactional
	public void savePromotion(Promotion promotion) {
		this.promotionDao.savePromotion(promotion);
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
		return this.promotionDao.findPromotion(idTour);
	}

	@Override
	public void updatePromotion(Promotion promotion) {
		this.promotionDao.updatePromotion(promotion);
	}

}
