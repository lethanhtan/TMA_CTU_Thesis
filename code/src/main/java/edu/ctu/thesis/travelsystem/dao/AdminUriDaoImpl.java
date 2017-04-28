package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.AdminUri;

@Service
public class AdminUriDaoImpl extends AbstractDao implements AdminUriDao {
	
	private final static Logger logger = Logger.getLogger(AdminUriDaoImpl.class);

	@Override
	public void saveAdminUri(AdminUri adminUri) {
		Session session = getCurrentSession();
		try {
			logger.info("Saving admin uri object!");
			session.save(adminUri);
			session.flush();
		} catch (NullPointerException e) {
			logger.info("Null adminUri object for save!");
		}
	}

	@Override
	public void updateAdminUri(AdminUri adminUri) {
		Session session = getCurrentSession();
		try {
			logger.info("Updating admin uri object!");
			session.update(adminUri);
			session.flush();
		} catch (NullPointerException e) {
			logger.info("Null adminUri object for update!");
		}
	}

	@Override
	public void deleteAdminUri(int id) {
		
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<AdminUri> listAdminUri() {
		logger.info("Listing admin uri object!");
		Session session = getCurrentSession();
		Query query = session.createQuery("from AdminUri");
		return (List<AdminUri>) query.list();
	}

	@Override
	public boolean findUri(String uri) {
		boolean result = false;
		for (AdminUri adminUri : listAdminUri()) {
			if (adminUri.getUri().equals(uri)) {
				result = true;
			} else {
				result = false;
			}
		}
		return result;
	}

}
