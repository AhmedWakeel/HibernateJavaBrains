package com.gontu;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class Main {

	public static void main(String[] args)
	{
		Student student1 = new Student();
		student1.setStudent_name("mk12");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session openSession = sessionFactory.openSession();
		openSession.beginTransaction();
		
		Student student = openSession.get(Student.class, 4);
		student.setStudent_name("before update transient state100");
       
		System.out.println(openSession.get(Student.class, 4).getStudent_name());
		openSession.update(student);
		
		student.setStudent_name("before update transient state200");
		
		System.out.println(openSession.get(Student.class, 4).getStudent_name());
		
		openSession.getTransaction().commit();
		openSession.close();
		
		Session openSession2 = sessionFactory.openSession();
		openSession2.beginTransaction();
		openSession2.update(student);
		openSession2.close();
		
		
		
	}
}
