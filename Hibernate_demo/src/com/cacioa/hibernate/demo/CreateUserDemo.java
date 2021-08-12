package com.cacioa.hibernate.demo;

import com.cacioa.hibernate.demo.entity.User;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.internal.build.AllowSysOut;

public class CreateUserDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(User.class)
								.buildSessionFactory();
		
		
		// create session
		
		Session session = factory.getCurrentSession();
		
		try {
			
			// use the session to save the Java obj
		
			// create the object
			
			System.out.println("Creating new user...");
			User tempUser = new User("Toni", "C","email@yahoo.com");
			
			// start transaction
			session.beginTransaction();
			// save the object
			System.out.println("Saving the user...");
			session.save(tempUser);
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("User created");
		}
		
		finally {
			
			factory.close();
		}
	}

}
