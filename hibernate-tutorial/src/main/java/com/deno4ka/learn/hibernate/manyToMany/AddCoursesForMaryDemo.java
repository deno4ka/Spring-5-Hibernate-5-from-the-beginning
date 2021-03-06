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

public class AddCoursesForMaryDemo {

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
				final int STUDENT_MARY_ID = 2;

				session.beginTransaction();

				Student studentMary = session.get(Student.class, STUDENT_MARY_ID);

				System.out.println("\nLoaded student: " + studentMary);
				System.out.println("Courses: " + studentMary.getCourseList());

				Course course2 = new Course("Rubik's Cube - How to Speed Cube");
				Course course3 = new Course("Atari 2600 - Game Development");

				course2.addStudent(studentMary);
				course3.addStudent(studentMary);

				System.out.println("\nSaving the course ...");
				session.save(course2);
				session.save(course3);

				session.getTransaction().commit();
				System.out.println("Done!");
			}

		}
	}

}
