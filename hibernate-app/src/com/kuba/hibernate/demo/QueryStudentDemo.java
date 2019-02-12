package com.kuba.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kuba.hibernate.demo.entity.Student;



public class QueryStudentDemo {
	
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			//query all students
			List <Student> theStudents = session.createQuery("from Student").getResultList();
//			List <Student> theStudents = session.createQuery("from Student").list();
			
			// query students: lastName ='Doe'
			List <Student> theStudents2 = session.createQuery("from Student s where s.lastName='Doe'").getResultList();
			
			
			// lastName='Doe' OR firstName='Daffy'
			List <Student> theStudents3 = session.createQuery("from Student s where"
					+ " s.lastName='Doe' OR s.firstName='Steve'").getResultList();
			
			
			// where email LIKE '%luv2code.com'
			List <Student> theStudents4 = session.createQuery("from Student s where"
					+ " s.email LIKE '%gmail.com'").getResultList();
			
			
			
			//display the students
			displayStudent(theStudents4);
			
			// commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
		}
		finally {
			factory.close();
		}
	}

	private static void displayStudent(List<Student> theStudents) {
		for(Student student: theStudents){
			System.out.println(student);
		}
	}
	
	
	
	
	

}
