package com.deno4ka.learn.hibernate.oneToMany;

import com.deno4ka.learn.hibernate.entity.Course;
import com.deno4ka.learn.hibernate.entity.Instructor;
import com.deno4ka.learn.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteCourseDemo {

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
				final int COURSE_ID = 10;

				session.beginTransaction();

				Course course = session.get(Course.class, COURSE_ID);
				session.delete(course);

				session.getTransaction().commit();

				System.out.println("Done!");
			}

		}
	}

}
