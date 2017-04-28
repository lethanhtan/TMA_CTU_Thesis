package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.AdminUri;

public interface AdminUriDao {

	public void saveAdminUri(AdminUri adminUri);
	
	public void updateAdminUri(AdminUri adminUri);
	
	public void deleteAdminUri(int id);
	
	public List<AdminUri> listAdminUri();
	
	public boolean findUri(String uri);
	
}
