package edu.ctu.thesis.travelsystem.dao;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import edu.ctu.thesis.travelsystem.controller.UserController;
import edu.ctu.thesis.travelsystem.extra.EncoderPassword;
import edu.ctu.thesis.travelsystem.extra.GenerateId;
import edu.ctu.thesis.travelsystem.model.Role;
import edu.ctu.thesis.travelsystem.model.User;

@Repository
public class UserDaoImpl implements UserDao {

	EncoderPassword ep = new EncoderPassword();

	GenerateId gid = new GenerateId();
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	//@Autowired
	private SessionFactory sessionFactory;
	
	@Autowired
	public void setSessionfactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	// Using for register
	@Override
	public void saveUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		Role role = new Role();
		role.setId(1);
		role.setDescription("role_user");
		if (user != null) {
			try {
				logger.info("Save User Object! With encoded password!");
				user.setRole(role); //set default role for register account
				user.setPassword(ep.enCoded(user.getPassword())); //encoded password user
				user.setPasswordConfirm(user.getPassword()); //encoded password confirm user
				user.setId(gid.generateIdUser(user.getUserName())); //generate user id
				session.save(user);
				session.close();
			} catch (Exception e) {
				logger.info("Exception when save user!");
				session.close();
				e.printStackTrace();
			}
		}

	}

	// Using for login
	@Override
	public User loginUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		String hql = "from edu.ctu.thesis.travelsystem.model.User as u where u.userName =? and u.password =?";
		try {
			logger.info("Load user to login!");
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getUserName());
			query.setParameter(1, ep.enCoded(user.getPassword()));
			user = (User) query.uniqueResult();
			session.close();
		} catch (Exception e) {
			logger.info("Exception when login user!");
			session.close();
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public Integer getRoleUser(User user) {
		logger.info("User role id be called!");
		return user.getRole().getId();
	}

	@Override
	public void loadUser(User user) {
		Session session = this.sessionFactory.getCurrentSession();
		if (user != null) {
			try {
				logger.info("Loaded user!");
				session.get(User.class, new Integer(2));
				session.close();
			} catch (Exception e) {
				logger.info("Exception when loaded user!");
				session.close();
				e.printStackTrace();
			}
		}
	}
}