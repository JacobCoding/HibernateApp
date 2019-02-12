package com.kuba.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kuba.hibernate.demo.entity.Student;


public class DeleteStudentDemo {
	
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			// create a student object
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Paul", "Doe", "paul@luv2code.com");
			
			// start a transaction
			session.beginTransaction();
			
			// save the student object
			System.out.println("Saving the student...");
			session.save(tempStudent);
			
			
			
			// first way of deleting student
//			int studentId = 4;
//			Student myStudent = session.get(Student.class, studentId);
//			session.delete(myStudent);
			
			// second way of deleting student
			session.createQuery("delete from Student where id=3")
					.executeUpdate();
			
			
			
			
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}
	

}
