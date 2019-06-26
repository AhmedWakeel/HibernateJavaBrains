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
		
		
		Address  address = new Address();
		address.setCity("mumbai");
		address.setPincode("400072");
		address.setState("maharashtraa");
		
		details.setAddress2(address);
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		org.hibernate.Transaction beginTransaction = openSession.beginTransaction();
		
		openSession.save(details);
		beginTransaction.commit();
		openSession.close();
		
		
	}
}
