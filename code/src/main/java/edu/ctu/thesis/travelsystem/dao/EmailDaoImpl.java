package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.jboss.logging.Logger;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.model.Email;

@Service
public class EmailDaoImpl extends AbstractDao implements EmailDao {
	
	private static final Logger logger = Logger.getLogger(EmailDaoImpl.class);
	
	@Override
	public void saveEmail(Email email) {
		Session session = getCurrentSession();
		try {
			logger.info("Saving data mail sent!");
			session.save(email);
			session.flush();
		} catch (NullPointerException e) {
			logger.debug("Had problem when saving data mail log!");
		}
	}

	@Override
	public void deleteEmail(int id) {
		logger.info("Processing for delete email log!");
		Session session = getCurrentSession();
		String hql = "from EMAIL where ID_EMAIL = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		Email email = (Email) query.list().get(0);
		try {
			if (email != null) {
				session.delete(email);
			}
		} catch (NullPointerException e) {
			logger.info("Nothing of email to delete!");
		}
	}

	@Override
	public boolean getEmailStatus(int id) {
		Session session = getCurrentSession();
		String hql = "select e.status from Email as e where id = :id";
		Query query = session.createQuery(hql);
		query.setParameter("id", id);
		return (boolean)query.uniqueResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Email> listMail() {
		Session session = getCurrentSession();
		String hql = "FROM Email";
		Query query = session.createQuery(hql);
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Email> listMailByStaus(boolean status) {
		Session session = getCurrentSession();
		String hql = "FROM Email as e where e.status = :status";
		Query query = session.createQuery(hql);
		query.setParameter("status", status);
		return query.list();
	}

}
