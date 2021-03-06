package com.deno4ka.learn.hibernate.manyToMany;

import com.deno4ka.learn.hibernate.entity.Course;
import com.deno4ka.learn.hibernate.entity.Instructor;
import com.deno4ka.learn.hibernate.entity.InstructorDetail;
import com.deno4ka.learn.hibernate.entity.Review;
import com.deno4ka.learn.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeletePacmanCourseDemo {

	public static void main(String[] args) {

		Logger.getLogger("org.hibernate").setLevel(Level.WARNING);

		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory()) {

			try (Session session = factory.getCurrentSession()) {
				final int PACMAN_COURSE_ID = 10;

				session.beginTransaction();

				Course pacmanCourse = session.get(Course.class, PACMAN_COURSE_ID);
				System.out.println("Deleting course: " + pacmanCourse);

				session.delete(pacmanCourse);

				session.getTransaction().commit();
				System.out.println("Done!");
			}

		}
	}

}
