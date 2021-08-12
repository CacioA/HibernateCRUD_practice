package com.cacioa.hibernate.demo;

import com.cacioa.hibernate.demo.entity.User;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class QueryUserDemo {

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
				 
			
			// start transaction
			session.beginTransaction();
			
			
			List<User> theUsers = session.createQuery("from User").list();
			
			
			displayUsers(theUsers);
			System.out.println("All users displayed");
			System.out.println("=====================");

			displayUsers(theUsers);
			theUsers=session.createQuery("from User u where u.firstName='Taz'").list();
			System.out.println("All users with first name Taz");
			System.out.println("=====================");
			
			
			
			theUsers=session.createQuery("from User u where u.email LIKE '%othermail.com'").list();
			displayUsers(theUsers);
			System.out.println("All users with email othermail.com");
			System.out.println("=====================");
			
			
			// commit transaction
			session.getTransaction().commit();
			
			
		}
		
		finally {
			
			factory.close();
		}
	}

	private static void displayUsers(List<User> theUsers) {
		for(User tempUser : theUsers) {
			System.out.println(tempUser);
		}
	}

}
