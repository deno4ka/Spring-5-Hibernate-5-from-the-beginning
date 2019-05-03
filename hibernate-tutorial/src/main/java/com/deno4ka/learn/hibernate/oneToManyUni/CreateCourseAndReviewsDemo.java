package com.deno4ka.learn.hibernate.oneToManyUni;

import com.deno4ka.learn.hibernate.entity.Course;
import com.deno4ka.learn.hibernate.entity.Instructor;
import com.deno4ka.learn.hibernate.entity.InstructorDetail;
import com.deno4ka.learn.hibernate.entity.Review;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateCourseAndReviewsDemo {

	public static void main(String[] args) {

		Logger.getLogger("org.hibernate").setLevel(Level.WARNING);

		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.buildSessionFactory()) {

			try (Session session = factory.getCurrentSession()) {
				session.beginTransaction();

				Course course = new Course("Pacman - How To Score One Million Points");

				course.addReview(new Review("Great course ... loved id!"));
				course.addReview(new Review("Cool course, job well done"));
				course.addReview(new Review("What a dumb course, you are an idiot"));

				System.out.println("Saving the course");
				System.out.println(course);
				System.out.println(course.getReviewList());

				session.save(course);

				session.getTransaction().commit();
				System.out.println("Done!");
			}

		}
	}

}
