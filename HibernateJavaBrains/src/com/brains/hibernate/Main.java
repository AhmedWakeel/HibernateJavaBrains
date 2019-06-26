package com.brains.hibernate;

import java.util.Date;

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
	
		UserDetails details = new UserDetails();
		details.setUserName("Malik");
		details.setAddress("mumbai");
		details.setDescription("java");
		details.setJoinedDate(new Date());
		
		
		Address  address = new Address();
		address.setCity("mumbai");
		address.setPincode("400072");
		address.setState("maharashtraa");
		
		Address  address2 = new Address();
		address2.setCity("mumbai1");
		address2.setPincode("4000721");
		address2.setState("maharashtraa11");
		
		details.getAddresses().add(address);
		details.getAddresses().add(address2);
		
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		org.hibernate.Transaction beginTransaction = openSession.beginTransaction();
		
		openSession.save(details);
		beginTransaction.commit();
		openSession.close();
		
		
	}
}
