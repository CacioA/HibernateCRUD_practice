package com.cacioa.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cacioa.hibernate.demo.entity.User;

public class UpdateUser {
	
	
	public static void main(String[] args) {

	SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
			.addAnnotatedClass(User.class)
			.buildSessionFactory();

// create session

	try
	{

		int userId = 1;
		// commit transa

		Session session = factory.getCurrentSession();
		session.beginTransaction();
		
		System.out.println("\nGettin user with id: "+userId);
		
		User myUser = session.get(User.class, userId);
		
		System.out.println("Updating user...");
		
		myUser.setFirstName("Antonio");
		
		System.out.println("Updating all email address");
	
		session.createQuery("update User set email='email@update-gmail.com'").executeUpdate();
		session.getTransaction().commit();

		System.out.println("Update - Done");
	}

	finally
	{

		factory.close();
	}
	}
}
