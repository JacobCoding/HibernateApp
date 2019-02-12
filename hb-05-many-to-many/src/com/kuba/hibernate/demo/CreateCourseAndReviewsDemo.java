package com.kuba.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kuba.hibernate.demo.entity.Course;
import com.kuba.hibernate.demo.entity.Instructor;
import com.kuba.hibernate.demo.entity.InstructorDetail;
import com.kuba.hibernate.demo.entity.Review;


public class CreateCourseAndReviewsDemo {
	
	
	public static void main(String[] args) {

		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernate.cfg.xml")
								.addAnnotatedClass(Instructor.class)
								.addAnnotatedClass(InstructorDetail.class)
								.addAnnotatedClass(Course.class)
								.addAnnotatedClass(Review.class)
								.buildSessionFactory();
		
		// create session
		Session session = factory.getCurrentSession();
		
		try {			
			
			// start a transaction
			session.beginTransaction();
			
			// create course
			Course course = new Course("New Course 12345dsadada");
			
			//add some reviews
			
			course.addReview(new Review("rate = 5"));
			course.addReview(new Review("rate = 4"));
			course.addReview(new Review("rate = 3"));
			
			
			//save the course ... and leverage the cascade all 
			session.save(course); // saving course will automatically save all reviews, cascadeType.ALL
			
			
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
