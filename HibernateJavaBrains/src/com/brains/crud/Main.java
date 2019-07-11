package com.brains.crud;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
	{
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		
		
		
		 UserDetails userDetails = session.get(UserDetails.class, 1);
		 System.out.println(userDetails.getUserName());
//        UserDetails details = new UserDetails();
//        details.setUserName("New User");   // object is in Transient state
        
//        session.save(details);   // object is in Persistence state
//        details.setUserName("Updated user");
		
		session.getTransaction().commit();
		session.close();  // object is in Detached state
		
		session = buildSessionFactory.openSession();
		session.beginTransaction();
		session.update(userDetails);
		session.close();
	
	}
}
