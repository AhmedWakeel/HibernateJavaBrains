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
		
		UserDetails details1 = new UserDetails();
		details1.setUserName("Ahmed");
		
		Vehicle vehicle4 = new Vehicle();
		vehicle4.setVehicleName("TATA1");
		
		Vehicle vehicle3 = new Vehicle();
		vehicle3.setVehicleName("TATA");
		
		
		Vehicle vehicle1 = new Vehicle();
		vehicle1.setVehicleName("TATA");
		
		Vehicle vehicle2 = new Vehicle();
		vehicle2.setVehicleName("TATA1");
		
		details.getCollect().add(vehicle1);
		details.getCollect().add(vehicle2);
		
		details1.getCollect().add(vehicle3);
		details1.getCollect().add(vehicle4);
		
		vehicle1.getUser().add(details1);
		vehicle2.getUser().add(details);
		
		vehicle3.getUser().add(details1);
		vehicle4.getUser().add(details);
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		
		session.save(details);
		session.save(vehicle1);
		session.save(vehicle2);
		
		session.save(details1);
		session.save(vehicle3);
		session.save(vehicle4);
		
		session.getTransaction().commit();
		session.close();
		 
	
	}
}
