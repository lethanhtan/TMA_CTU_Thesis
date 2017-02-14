package edu.ctu.thesis.travelsystem.dao.impl;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Repository;

import edu.ctu.thesis.travelsystem.dao.LoginDao;
import edu.ctu.thesis.travelsystem.entity.Account;

@Repository("loginDao")
public class LoginDaoImpl implements LoginDao{
	
	@Resource(name = "sessionFactroy")
	protected SessionFactory sessionFactory;

	@Override
	public void save(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void update(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(Account account) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean checkLogin(String idAcc, String passAcc) {
		Session session = sessionFactory.openSession();
		
		boolean userFound = false;
		String SQL_QUERY = "from account as o where o.idAcc=? and o.passAcc=?";
		Query query = session.createSQLQuery(SQL_QUERY);
		query.setParameter(0, idAcc);
		query.setParameter(1, passAcc);
		List list = query.list();
		
		if ((list != null) && (list.size() > 0)) {
			userFound = true;
		}
		
		session.close();
		
		return userFound;
	}


}
