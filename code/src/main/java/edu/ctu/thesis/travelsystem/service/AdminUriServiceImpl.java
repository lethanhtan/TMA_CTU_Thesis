package edu.ctu.thesis.travelsystem.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.dao.AdminUriDao;
import edu.ctu.thesis.travelsystem.model.AdminUri;

@Service
public class AdminUriServiceImpl implements AdminUriService {
	
	@Autowired
	AdminUriDao adminUriDao;

	@Override
	@Transactional
	public void saveAdminUri(AdminUri adminUri) {
		this.adminUriDao.saveAdminUri(adminUri);
	}

	@Override
	@Transactional
	public void updateAdminUri(AdminUri adminUri) {
		this.adminUriDao.updateAdminUri(adminUri);
	}

	@Override
	@Transactional
	public void deleteAdminUri(int id) {
		this.adminUriDao.deleteAdminUri(id);
	}

	@Override
	@Transactional
	public List<AdminUri> listAdminUri() {
		return this.adminUriDao.listAdminUri();
	}

	@Override
	public boolean findUri(String uri) {
		return this.adminUriDao.findUri(uri);
	}

}
