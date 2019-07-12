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
	
		Query<UserDetails> namedQuery = session.getNamedQuery("USER_DETAILS.byId");
		namedQuery.setInteger("userId", 2);
//		namedQuery.setString(0,"User 10");
		List<UserDetails> list = namedQuery.list();

		session.getTransaction().commit();
		session.close(); 
	System.out.println(list.size());
	
	}
}
