package com.deno4ka.learn.hibernate.eagerVsLazy;

import com.deno4ka.learn.hibernate.entity.Course;
import com.deno4ka.learn.hibernate.entity.Instructor;
import com.deno4ka.learn.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import java.util.logging.Level;
import java.util.logging.Logger;

public class FetchJoinDemo {

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

				Query<Instructor> query = session.createQuery(
						"SELECT i from Instructor i " +
								"JOIN FETCH i.courseList " +
								"WHERE i.id=:instructorId", Instructor.class);
				query.setParameter("instructorId", INSTRUCTOR_ID);
				Instructor instructor = query.getSingleResult();
				System.out.println("luv2code: Instructor:\n" + instructor);

				session.getTransaction().commit();

				System.out.println("luv2code: Courses:\n" + instructor.getCourseList());

				System.out.println("luv2code: Done!");
			}

		}
	}

}
