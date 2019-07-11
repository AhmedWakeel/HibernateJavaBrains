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
		/*
		for(int i =1;i<=10;i++)
		{
			UserDetails details = new UserDetails();
			details.setUserName("User :"+i);
			session.save(details);
		}*/
		
		UserDetails userDetails = session.get(UserDetails.class, 5);
		System.out.println(userDetails.getUserName());
		userDetails.setUserName("wwwww");
		session.update(userDetails);
//		session.delete(userDetails);
		
		
		session.getTransaction().commit();
		session.close();
		 
	
	}
}
