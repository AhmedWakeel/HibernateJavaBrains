package com.brains.crud;

import java.util.List;

import javax.transaction.HeuristicMixedException;
import javax.transaction.HeuristicRollbackException;
import javax.transaction.RollbackException;
import javax.transaction.SystemException;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

public class Main {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
	{
		
		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
	
		Criteria createCriteria = session.createCriteria(UserDetails.class);
		/*Criteria add = createCriteria.add(Restrictions.eq("userName", "Name is :4"))
				                     .add(Restrictions.between("userId", 2, 10))
				                     .add(Restrictions.like("userId", "%Name 1%"));*/
		
		     Criteria add = createCriteria.add(Restrictions.or(Restrictions.between("userId", 2, 5),Restrictions.between("userId", 4, 9)));
		
		List<UserDetails> list = add.list();
		System.out.println(list.size());
		
		session.getTransaction().commit();
		session.close(); 
		
		for(UserDetails details :list)
		{
			System.out.println(details.getUserName());
		}
	
	}
}
