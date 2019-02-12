package com.kuba.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kuba.hibernate.demo.entity.Course;
import com.kuba.hibernate.demo.entity.Instructor;
import com.kuba.hibernate.demo.entity.InstructorDetail;


public class CreateInstructorDemo {
	
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			
			Instructor tempInstructor = new Instructor("Pawel2", "Sztos2", "Pawel222@gmail.com");
			InstructorDetail  instrDetail = new InstructorDetail("youtube.com-swimming", "swimming@");
			tempInstructor.setInstructorDetail(instrDetail);
			
			
			// start a transaction
			session.beginTransaction();
			
			System.out.println("Instructor " + tempInstructor);
			
			// saving instructor
			session.save(tempInstructor); // saving Instructor and associated objects ->  Annotation cascade type = CascadeType.ALL
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			
			session.close();
			
			factory.close();
		}
	}
	

}
