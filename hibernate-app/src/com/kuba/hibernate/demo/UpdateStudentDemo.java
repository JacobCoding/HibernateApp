package com.kuba.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kuba.hibernate.demo.entity.Student;

public class UpdateStudentDemo {

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
			
			int studentId = 1;
			
			// retrieve student based on primary key
			Student myStudent = session.get(Student.class, studentId);
			
			//changing first name
			myStudent.setFirstName("Thomas@");
			
			// commit transaction
			session.getTransaction().commit();
			
			
			// new code
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			// 
			session.createQuery("update Student set email= 'foo@gmail.com'").executeUpdate();
			
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
