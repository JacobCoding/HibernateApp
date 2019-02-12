package com.kuba.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kuba.hibernate.demo.entity.Course;
import com.kuba.hibernate.demo.entity.Instructor;
import com.kuba.hibernate.demo.entity.InstructorDetail;
import com.kuba.hibernate.demo.entity.Review;
import com.kuba.hibernate.demo.entity.Student;


public class GetCoursesForStudent {
	
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.addAnnotatedClass(Student.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// get student
			int studentId = 1;
			Student tempStudet = session.get(Student.class, studentId);
			System.out.println(tempStudet);
			
			
			// create two new courses
			Course course = new Course("course _1000");
			Course course2 = new Course("course _222222");
			
			// add student to a corses 
			course.addStudent(tempStudet);
			course2.addStudent(tempStudet);
			
			
			// save courses 
			session.save(course);
			session.save(course2);
			
			
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
