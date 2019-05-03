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

public class DeleteCourseAndReviewsDemo {

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
				final int COURSE_ID = 10;

				session.beginTransaction();

				Course course = session.get(Course.class, COURSE_ID);

				System.out.println("Deleting the course ... ");
				System.out.println(course);
				System.out.println(course.getReviewList());

				session.delete(course);

				session.getTransaction().commit();
				System.out.println("Done!");
			}

		}
	}

}
