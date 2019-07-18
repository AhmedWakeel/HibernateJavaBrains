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
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;

public class Main {

	public static void main(String[] args) throws SecurityException, RollbackException, HeuristicMixedException, HeuristicRollbackException, SystemException
	{

		SessionFactory buildSessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = buildSessionFactory.openSession();
		session.beginTransaction();
	
		
		UserDetails details = new UserDetails();
		details.setUserName("Name is%");
		
		Example example = Example.create(details).enableLike();  // excludeProperty("UserId").
		
		 Criteria add = session.createCriteria(UserDetails.class)
				                          .addOrder(Order.asc("UserId"))
				                          .add(example);
//				                          .setProjection(Projections.max("UserId")); 
//		                                  .setProjection(Projections.count("UserId"));
//				                          .setProjection(Projections.property("UserId"));
		List<UserDetails> list = (List<UserDetails>) add.list();
		session.getTransaction().commit();
		session.close(); 
		
	
	}
}
