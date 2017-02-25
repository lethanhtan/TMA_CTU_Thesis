package edu.ctu.thesis.travelsystem.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ctu.thesis.travelsystem.model.User;

public class UserDaoImpl implements UserDao {
	
	//Auto inject fields
	@Autowired
	private SessionFactory sessionFactory;
	
	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	//Using for register
	@Override
	public void saveUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(user!=null){
			try {
				session.save(user);
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}

	}
	
	//Using for login
	@Override
	public User loginUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		String hql = "from edu.ctu.thesis.travelsystem.model.User as u where u.userName =? and u.password =?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getUserName());
			query.setParameter(1, user.getPassword());
			user = (User) query.uniqueResult();
			tx.commit();
			session.close();
		} catch (Exception e) {
			tx.rollback();
			session.close();
			e.printStackTrace();
		}
		return user;
	}

}
