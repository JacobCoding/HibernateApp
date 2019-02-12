package com.kub.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kuba.hibernate.demo.entity.Instructor;
import com.kuba.hibernate.demo.entity.InstructorDetail;


public class DeleteDemo {
	
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			int theId = 1;
			
			// start a transaction
			session.beginTransaction();
			
			// getting Instructor by id
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Found instructor: " + tempInstructor);
			
			// deleting the instructor if exists in DB
			if(tempInstructor!= null){
				session.delete(tempInstructor); // InstructorDetail will also be deleted
			}
			
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
	

}
