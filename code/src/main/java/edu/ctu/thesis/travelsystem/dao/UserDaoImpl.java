package edu.ctu.thesis.travelsystem.dao;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;

import edu.ctu.thesis.travelsystem.extra.EncoderPassword;
import edu.ctu.thesis.travelsystem.extra.GenerateId;
import edu.ctu.thesis.travelsystem.model.Role;
import edu.ctu.thesis.travelsystem.model.User;

public class UserDaoImpl implements UserDao {
	
	EncoderPassword ep = new EncoderPassword();
	
	GenerateId gid = new GenerateId();
	
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
		Role role = new Role();
		role.setIdRole(1);
		role.setNameRole("role_user");
		if(user!=null){
			try {
				user.setRole(role);
				System.out.println(user.getRole().getNameRole());
				user.setPassword(ep.enCoded(user.getPassword()));
				user.setPasswordConfirm(user.getPassword());
				user.setIdUser(gid.generateIdUser(user.getUserName()));
				session.save(user);
				System.out.println("In here!");
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
			query.setParameter(1, ep.enCoded(user.getPassword()));
			System.out.println("Password: " + ep.enCoded(user.getPassword()));
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

	@Override
	public Integer getRoleUser(User user) {
		return user.getRole().getIdRole();
	}

	@Override
	public void loadUser(User user) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		if(user!=null){
			try {
				session.get(User.class, new Integer(2));
				System.out.println("In here!");
				tx.commit();
				session.close();
			} catch (Exception e) {
				tx.rollback();
				session.close();
				e.printStackTrace();
			}
		}
	}

}