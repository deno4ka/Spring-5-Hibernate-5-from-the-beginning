package com.deno4ka.learn.hibernate.oneToMany;

import com.deno4ka.learn.hibernate.entity.Course;
import com.deno4ka.learn.hibernate.entity.Instructor;
import com.deno4ka.learn.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class GetInstructorCoursesDemo {

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
				System.out.println("Instructor:\n" + instructor);
				System.out.println("Courses:\n" + instructor.getCourseList());
//				List<Course> courseList = instructor.getCourseList();

				session.getTransaction().commit();

				System.out.println("Done!");
			}

		}
	}

}
