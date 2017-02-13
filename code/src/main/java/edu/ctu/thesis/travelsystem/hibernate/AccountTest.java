package edu.ctu.thesis.travelsystem.hibernate;

import java.sql.Date;
import org.hibernate.Session;

import edu.ctu.thesis.travelsystem.entity.Account;
import edu.ctu.thesis.travelsystem.entity.Customer;

public class AccountTest {
	public static void main(String[] args) {
		System.out.println("Started testing: ");
		
		Session session = HibernateUtil.getSessionFactory().openSession();
		session.beginTransaction();
		
		Customer customer = new Customer();
		customer.setIdCus("U0001");
		session.save(customer);
		
		session.getTransaction().commit();
		
		System.out.println("Finish tested.");
	}

}
