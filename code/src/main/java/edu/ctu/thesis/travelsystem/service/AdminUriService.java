package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import edu.ctu.thesis.travelsystem.model.AdminUri;

public interface AdminUriService {

	public void saveAdminUri(AdminUri adminUri);

	public void updateAdminUri(AdminUri adminUri);

	public void deleteAdminUri(int id);

	public List<AdminUri> listAdminUri();
	
	public boolean findUri(String uri);

}
