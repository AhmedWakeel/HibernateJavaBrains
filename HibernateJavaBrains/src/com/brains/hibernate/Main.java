package com.brains.hibernate;

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
		
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("TATA");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("TATA1");
		
		details.getCollect().add(vehicle1);
		details.getCollect().add(vehicle2);
		
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		
//		session.save(details);
		session.persist(details);
	
		session.getTransaction().commit();
		session.close();
		 
	
	}
}
