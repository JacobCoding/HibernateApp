package com.kub.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kuba.hibernate.demo.entity.Instructor;
import com.kuba.hibernate.demo.entity.InstructorDetail;


public class CreateStudentDemo {
	
	
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
			
			// create the objects
//			Instructor tempInstructor = new Instructor("Jacob", "K", "KK@gmail.com");
//			InstructorDetail  instrDetail = new InstructorDetail("youtube.com/Qbala", "hobby-run");
//			tempInstructor.setInstructorDetail(instrDetail);
			
			Instructor tempInstructor = new Instructor("Steve", "X", "XX@gmail.com");
			InstructorDetail  instrDetail = new InstructorDetail("youtube.com/XX", "hobby-fun@");
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
			factory.close();
		}
	}
	

}
