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
		
		Vehicle vehicle = new Vehicle();
		vehicle.setVehicleName("TATA");
		
       details.setVehicle(vehicle);		
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
		
		session.save(details);
		session.save(vehicle);
		session.getTransaction().commit();
		session.close();
		 
	
	}
}
