package com.cacioa.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cacioa.hibernate.demo.entity.User;

public class DeleteUser {

	public static void main(String[] args) {
		
		
		SessionFactory factory = new Configuration().configure("hibernate.cfg.xml")
					.addAnnotatedClass(User.class)
					.buildSessionFactory();
		
		
		try {
			
			
			Session session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			System.out.println("Delete user with id = 17");
			session.createQuery("delete from User where id=17").executeUpdate();
			
			// second approach
//			int userId = 17;
//			User myUser = session.get(User.class,userId);
//			session.delete(myUser);
			
			session.getTransaction().
			commit();
			
			System.out.println("Delete - Done");
			
		}
		
		finally{
			
			factory.close();
		}
		
	}
}
