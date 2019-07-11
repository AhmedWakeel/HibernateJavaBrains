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
	
		String s ="5";
		String s1 = "Name is :6";
		/*Query<UserDetails> createQuery = session.createQuery("from UserDetails where userId > ?1 and userName = ?2");
		createQuery.setInteger(1, Integer.parseInt(s));
		createQuery.setString(2, s1);*/

		Query<UserDetails> createQuery = session.createQuery("from UserDetails where userId > :s and userName = :s1");
		createQuery.setInteger("s", Integer.parseInt(s));
		createQuery.setString("s1",s1);
		
		
		List<UserDetails> list = createQuery.list();
	/*	createQuery.setFirstResult(4);
		createQuery.setMaxResults(4);*/
		
		session.getTransaction().commit();
		session.close(); 
		System.out.println(list.size());
	
	}
}
