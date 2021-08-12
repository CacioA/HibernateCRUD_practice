package com.cacioa.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cacioa.hibernate.demo.entity.User;

public class PrimaryKeyDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(User.class)
				.buildSessionFactory();

		// create session

		Session session = factory.getCurrentSession();

		try {

			// use the session to save the Java obj

			// create 3 user object
//
//			System.out.println("Creating new user...");
//			User tempUser1 = new User("Andreea", "C", "andreea1@yahoo.com");
//			User tempUser2 = new User("Taz", "C", "ta1z@yahoo.com");
//			User tempUser3 = new User("Zelda", "C", "zelda1@yahoo.com");
//			// start transaction
//			session.beginTransaction();
//			// save the object
//			System.out.println("Saving the user...");
//			session.save(tempUser1);
//			session.save(tempUser2);
//			session.save(tempUser3);
//			// commit transaction
//			
//
//			System.out.println("User created");
//			
//			System.out.println("Reading user...");
//			
//			User myUser = session.get(User.class,tempUser1.getId());
//			
//			System.out.println("User: "+myUser);
//			
//			
//			
//			System.out.println("Create - Done; ");
//			System.out.println("Read - Done; ");
//			session.getTransaction().commit();
		}

		finally {

			factory.close();
		}
	}
}
