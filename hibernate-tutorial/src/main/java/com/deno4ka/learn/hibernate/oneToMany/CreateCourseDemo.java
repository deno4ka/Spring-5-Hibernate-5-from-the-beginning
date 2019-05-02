package com.deno4ka.learn.hibernate.oneToMany;

import com.deno4ka.learn.hibernate.entity.Course;
import com.deno4ka.learn.hibernate.entity.Instructor;
import com.deno4ka.learn.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateCourseDemo {

	public static void main(String[] args) {

		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.WARNING);

		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.buildSessionFactory()) {

			try (Session session = factory.getCurrentSession()) {
				final int INSTRUCTOR_ID = 1;

				session.beginTransaction();

				Instructor instructor = session.get(Instructor.class, INSTRUCTOR_ID);
				Course course1 = new Course("Air Guitar - The Ultimate Guide");
				Course course2 = new Course("The Pinball MasterClass");
				instructor.addCourse(course1);
				instructor.addCourse(course2);

				System.out.println("Saving instructor with courses:\n" + course1 + "\n" + course2);
				session.save(course1);
				session.save(course2);

				session.getTransaction().commit();

				System.out.println("Done!");
			}

		}
	}

}
