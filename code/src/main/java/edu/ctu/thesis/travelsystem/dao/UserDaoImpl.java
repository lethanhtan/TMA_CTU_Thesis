package edu.ctu.thesis.travelsystem.dao;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.ctu.thesis.travelsystem.extra.EncoderPassword;
import edu.ctu.thesis.travelsystem.model.BookTour;
import edu.ctu.thesis.travelsystem.model.Role;
import edu.ctu.thesis.travelsystem.model.User;
import edu.ctu.thesis.travelsystem.service.BookTourService;

@Service
public class UserDaoImpl extends AbstractDao implements UserDao {
	@Autowired
	private BookTourService bookTourService;

	EncoderPassword ep = new EncoderPassword();

	private static final Logger logger = Logger.getLogger(UserDaoImpl.class);

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
				Date date = new Date();
				user.setDate(date);
				user.setTime(date);
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
		if (user != null) {
			Query query = session.createQuery("UPDATE User SET ID_ROLE = null WHERE ID_USER = :idUser");
			query.setParameter("idUser", user.getIdUser());
			query.executeUpdate();
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

	@Override
	public List<BookTour> myRegListByValue(String value, int idUser) {
		Session session = getCurrentSession();
		Query query = session.createQuery(
				"FROM BookTour " + "WHERE Id_User = :idUser AND Cus_Cancel = false AND Gone_Or_Not = false "
						+ "AND (cusName LIKE :value OR cusEmail LIKE :value OR cusPhone LIKE :value OR cusIdCard LIKE :value)"
						+ "GROUP BY relationship HAVING id_bt = MIN(id_bt)");
		query.setParameter("idUser", idUser);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<BookTour> registrationList = query.list();
		return registrationList;
	}

	// Display registration list by Id user
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> myRegList(int idUser) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("FROM BookTour WHERE id_user = :idUser AND cus_cancel = false AND gone_or_not = false "
						+ "GROUP BY relationship HAVING id_bt = MIN(id_bt)");
		query.setParameter("idUser", idUser);
		List<BookTour> myRegList = query.list();
		for (BookTour bookTour : myRegList) {
			if (bookTour.getTour().getDepartureDate().before(Calendar.getInstance().getTime())) {
				bookTour.setGoneOrNot(true);
			} else {
				bookTour.setGoneOrNot(false);
			}
			bookTourService.editBookTour(bookTour);
			logger.info("My registration List:" + bookTour);
		}
		return myRegList;
	}

	@Override
	public List<BookTour> myCancelListByValue(String value, int idUser) {
		Session session = getCurrentSession();
		Query query = session.createQuery("FROM BookTour WHERE ID_USER = :idUser AND CUS_CANCEL = true "
				+ "AND (cusName LIKE :value OR cusEmail LIKE :value OR cusPhone LIKE :value OR cusIdCard LIKE :value)"
				+ "GROUP BY relationship HAVING id_bt = MIN(id_bt)");
		query.setParameter("idUser", idUser);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<BookTour> cancelList = query.list();
		return cancelList;
	}

	// Display registration list by Id user
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> myCancelList(int idUser) {
		Session session = getCurrentSession();
		Query query = session.createQuery("FROM BookTour WHERE ID_USER = :idUser AND CUS_CANCEL = true "
				+ "GROUP BY relationship HAVING id_bt = MIN(id_bt)");
		query.setParameter("idUser", idUser);
		List<BookTour> myCancelList = query.list();
		for (BookTour bookTour : myCancelList) {
			logger.info("My cancel registration list:" + bookTour);
		}
		return myCancelList;
	}

	@Override
	public void undoCancel(int idBT, int idTour) {
		Session session = getCurrentSession();
		BookTour bookTour = (BookTour) session.load(BookTour.class, new Integer(idBT));
		if (bookTour != null) {
			Query query = session.createQuery("UPDATE BookTour SET " + "CUS_NUMOFTICKET = :cusNumOfTicket,"
					+ "CUS_CANCEL = false, TICKET_CANCEL = 0 WHERE ID_BT = :idBT");
			query.setParameter("idBT", bookTour.getIdBT());
			query.setParameter("cusNumOfTicket", bookTour.getTicketCancel());
			query.executeUpdate();
			session.saveOrUpdate(bookTour);
			session.flush();
			logger.info("Delete customer success!");
		}
	}

	@Override
	public List<BookTour> myBookTourListByValue(String value, int idUser) {
		Session session = getCurrentSession();
		Query query = session
				.createQuery("FROM BookTour WHERE ID_USER = :idUser AND CUS_CANCEL = false AND GONE_OR_NOT = true "
						+ "AND (cusName LIKE :value OR cusEmail LIKE :value OR cusPhone LIKE :value OR cusIdCard LIKE :value)"
						+ "GROUP BY relationship HAVING id_bt = MIN(id_bt)");
		query.setParameter("idUser", idUser);
		query.setParameter("value", "%" + value + "%");
		@SuppressWarnings("unchecked")
		List<BookTour> myBookTourList = query.list();
		return myBookTourList;
	}

	// Display registration list by Id user
	@SuppressWarnings("unchecked")
	@Override
	public List<BookTour> myBookTourList(int idUser) {
		Session session = getCurrentSession();
		Query query = session.createQuery("FROM BookTour WHERE ID_USER = :idUser AND CUS_CANCEL = false "
				+ "AND GONE_OR_NOT = true GROUP BY relationship HAVING id_bt = MIN(id_bt)");
		query.setParameter("idUser", idUser);
		List<BookTour> myBookTourList = query.list();
		for (BookTour bookTour : myBookTourList) {
			logger.info("My registration List:" + bookTour);
		}
		return myBookTourList;
	}
}