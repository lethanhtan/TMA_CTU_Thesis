package edu.ctu.thesis.travelsystem.hibernate;

import java.util.Date;

import org.hibernate.Session;

import edu.ctu.thesis.travelsystem.entity.Account;

public class AccountInsertData {
    
    @SuppressWarnings("deprecation")
	public static void main(String[] args) 
    {
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        
        Account account = new Account();
        account.setIdAcc(127162);
        account.setDateCreateAcc(new Date(01,01,2016));
        account.setEmailAcc("rtrush@gmail.com");
        account.setPassAcc("12345678");
        session.save(account);
        
        Account account1 = new Account();
        account1.setIdAcc(127322);
        account1.setDateCreateAcc(new Date(01,01,2016));
        account1.setEmailAcc("rtrush@gmail.com");
        account1.setPassAcc("12038378");
        session.save(account1);
        
        //Commit the transaction
        session.getTransaction().commit();
        HibernateUtil.shutdown();
    }
}