package edu.ctu.thesis.travelsystem.dao;

import java.util.Date;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.controller.UserController;
import edu.ctu.thesis.travelsystem.extra.EncoderPassword;
import edu.ctu.thesis.travelsystem.model.Role;
import edu.ctu.thesis.travelsystem.model.User;

@Service
public class UserDaoImpl extends AbstractDao implements UserDao {

	EncoderPassword ep = new EncoderPassword();

	private static final Logger logger = Logger.getLogger(UserController.class);

	// Using for register
	@Override
	public void saveUser(User user) {
		Session session = getCurrentSession();
		Role role = new Role();
		role.setId(1);
		role.setDescription("role_user");
		if (user != null) {
			try {
				logger.info("Save User Object! With encoded password!");
				user.setRole(role); // set default role for register account
				user.setPassword(ep.enCoded(user.getPassword())); 
				user.setPasswordConfirm(user.getPassword()); 
				Date now = new Date();
				user.setResTime(now);
				session.save(user);
				session.flush();
			} catch (Exception e) {
				logger.error("Occured ex", e);
			}
		}
	}

	// Using for login
	@Override
	public User loginUser(User user) {
		Session session = getCurrentSession();
		String hql = "from edu.ctu.thesis.travelsystem.model.User as u where u.userName =? and u.password =?";
		try {
			logger.info("Load user to login!");
			Query query = session.createQuery(hql);
			query.setParameter(0, user.getUserName());
			query.setParameter(1, ep.enCoded(user.getPassword()));
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			logger.error("Occured ex", e);
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
		Session session = getCurrentSession();
		if (user != null) {
			try {
				logger.info("Loaded user!");
				session.get(User.class, new Integer(2));
			} catch (Exception e) {
				logger.error("Occured ex", e);
			}
		}
	}

	@Override
	public String findFullName(String userName) {
		String result = "";
		Session session = getCurrentSession();
		String hql = "select u.fullName edu.ctu.thesis.travelsystem.model.User as u where u.userName = ?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, userName);
			result = (String) query.uniqueResult();
		} catch (Exception e) {
			logger.error("Occured ex", e);
		}
		return result;
	}
}