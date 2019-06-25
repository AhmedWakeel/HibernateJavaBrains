package com.brains.hibernate;

import java.util.Date;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;
import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
	{
	
		UserDetails details = new UserDetails();
		details.setUserName("Malik");
		details.setAddress("mumbai");
		details.setDescription("java");
		details.setJoinedDate(new Date());
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		openSession.beginTransaction();
		
		openSession.save(details);
		Transaction transaction = (Transaction) openSession.getTransaction();
		transaction.commit();
		openSession.close();
		
		details = null;
		Session openSession2 = buildSessionFactory.openSession();
		Transaction beginTransaction = (Transaction) openSession2.beginTransaction();
		
		UserDetails userDetails = openSession2.get(UserDetails.class, 1);
		System.out.println("www  "+userDetails.getAddress());
		beginTransaction.commit();
		openSession2.close();
	}
}
