package edu.ctu.thesis.travelsystem.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.controller.ManageUserController;
import edu.ctu.thesis.travelsystem.extra.EncoderPassword;
import edu.ctu.thesis.travelsystem.model.Role;
import edu.ctu.thesis.travelsystem.model.User;

@Service
public class UserDaoImpl extends AbstractDao implements UserDao {
	EncoderPassword ep = new EncoderPassword();

	private static final Logger logger = Logger.getLogger(ManageUserController.class);

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
				// Encoded password user
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
	public int getRoleUser(User user) {
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

	@Override
	public List<User> userListByValue(String value) {
		System.out.println(value.contains(value));
		Session session = getCurrentSession();
		String hql = "FROM User WHERE FULL_NAME LIKE :value OR EMAIL LIKE :value OR PHONE LIKE :value OR USER_NAME LIKE :value";
		Query query = session.createQuery(hql);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<User> userList = query.list();
		return userList;
	}

	@Override
	public int getNumUserByValue(String value) {
		int numUser = userListByValue(value).size();
		logger.info("Total user: " + numUser);
		return numUser;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> userList() {
		Session session = getCurrentSession();
		String hql = "FROM User";
		List<User> userList = session.createQuery(hql).list();
		for (User user : userList) {
			logger.info("User List:" + user);
		}
		return userList;
	}

	@Override
	public int getNumUser() {
		Integer numUser = userList().size();
		logger.info("Total user: " + numUser);
		return numUser;
	}

	@Override
	public User searchUserById(int idUser) {
		Session session = getCurrentSession();
		User user = new User();
		logger.info("Information of user have ID is: " + idUser);
		String hql = "FROM User WHERE idUser = ?";
		try {
			Query query = session.createQuery(hql);
			query.setParameter(0, idUser);
			user = (User) query.uniqueResult();
		} catch (Exception e) {
			logger.error("Occured ex", e);
		}
		return user;
	}

	@Override
	public void deleteUser(int idUser) {
		Session session = getCurrentSession();
		User user = (User) session.load(User.class, new Integer(idUser));
		String hql = "DELETE FROM User WHERE ID_USER = :idUser";
		Query query = session.createQuery(hql);
		query.setParameter("idUser", idUser);
		if (user != null) {
			session.delete(user);
			session.flush();
			logger.info("Delete user successfully!");
		}
	}

	@Override
	public void editUser(User user) {
		Session session = getCurrentSession();
		if (user != null) {
			try {
				session.update(user);
				session.flush();
				logger.info("Update information of user successfully, user detail: " + user);
			} catch (Exception e) {
				logger.error("Occured ex", e);
			}
		}
	}
}