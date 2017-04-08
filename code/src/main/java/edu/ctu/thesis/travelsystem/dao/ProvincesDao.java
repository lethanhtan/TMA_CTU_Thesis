package edu.ctu.thesis.travelsystem.dao;

import edu.ctu.thesis.travelsystem.model.Province;

public interface ProvincesDao {
	
	public void saveProvinces(Province province);
	
	public void updateProvinces(int id);
	
	public void deleteProvinces(int id);
}
