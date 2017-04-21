package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.Promotion;

public interface PromotionDao {
	
	public void savePromotion(Promotion promotion);
	
	public void deletePromotion(int id);
	
	public List<Promotion> listPromotion();
}
