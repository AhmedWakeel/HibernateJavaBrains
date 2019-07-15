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
		userDetails.setUserName("mk");
		
		UserDetails userDetails1 = session.get(UserDetails.class, 1);
		session.getTransaction().commit();
		session.close(); 
		

		 session = buildSessionFactory.openSession();
		session.beginTransaction();
		
		UserDetails userDetails2 = session.get(UserDetails.class, 1);
	}
}
