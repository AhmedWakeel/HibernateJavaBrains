package com.brains.hibernate;



import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class Main {

	public static void main(String[] args)
	{
		UserDetails details = new UserDetails();
		details.setUserName("Malik");
		
		SessionFactory buildSessionFactory =  new Configuration().configure().buildSessionFactory();
		Session openSession = buildSessionFactory.openSession();
		openSession.beginTransaction();
		
		 
		openSession.save(details);
		Transaction transaction = openSession.getTransaction();
		transaction.commit();
		openSession.close();
		
		
	}
}
