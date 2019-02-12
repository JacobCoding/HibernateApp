package com.kuba.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kuba.hibernate.demo.entity.Course;
import com.kuba.hibernate.demo.entity.Instructor;
import com.kuba.hibernate.demo.entity.InstructorDetail;
import com.kuba.hibernate.demo.entity.Review;
import com.kuba.hibernate.demo.entity.Student;


public class CreateCourseAndStudentsDemo {
	
	
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
			
			Course course = new Course("How to become lean dancer");
			session.save(course);
			System.out.println("save course: " + course ) ;
			
			
			Student tempStudent = new Student("Steve", "Nash", "nash@wp.pl");
			Student tempStudent2 = new Student("Steve2", "Nash2", "nash2@wp.pl");
			
			course.addStudent(tempStudent);
			course.addStudent(tempStudent2);
			
			session.save(tempStudent);
			session.save(tempStudent2);
			
			
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
