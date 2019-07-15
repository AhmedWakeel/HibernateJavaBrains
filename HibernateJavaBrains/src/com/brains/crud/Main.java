package com.brains.crud;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class Main {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
	{

		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();

		
		Query createQuery = session.createQuery("from UserDetails user where user.userId = 1");
		createQuery.setCacheable(true);
		List list = createQuery.list();
		
		session.getTransaction().commit();
		session.close(); 
		

		 session = buildSessionFactory.openSession();
		session.beginTransaction();

		Session session1 = buildSessionFactory.openSession();
		session1.beginTransaction();
		
		Query createQuery1 = session1.createQuery("from UserDetails user where user.userId = 1");
		createQuery1.setCacheable(true);
		List list1 = createQuery1.list();
		
		 session1 = buildSessionFactory.openSession();
			session1.beginTransaction();
		
	}
}
