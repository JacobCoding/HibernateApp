package com.kuba.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kuba.hibernate.demo.entity.Instructor;
import com.kuba.hibernate.demo.entity.InstructorDetail;


public class GetInstructorDetailDemo {
	
	
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
			
			// start a transaction
			session.beginTransaction();
			
			int theId = 233;
			
			
			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theId);
			
			if(tempInstructorDetail != null){
				System.out.println(tempInstructorDetail);
				System.out.println(tempInstructorDetail.getInstructor());
			}else{
				System.out.println("InstructorDetail not founds");
			}
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}catch(Exception exc){
			exc.printStackTrace();
		}
		finally {
			
			// handling leaking issue
			session.close();
			
			factory.close();
		}
	}
	

}
