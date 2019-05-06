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

public class CreateCourseAndStudentsDemo {

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
				session.beginTransaction();

				Course course = new Course("Pacman - How To Score One Million Points");

				System.out.println("\nSaving the course ...");
				session.save(course);
				System.out.println("Saved the course: " + course);

				Student student1 = new Student("John", "Doe", "john@luv2code.com");
				Student student2 = new Student("Mary", "Public", "mary@luv2code.com");

				course.addStudent(student1);
				course.addStudent(student2);

				System.out.println("\nSaving students ...");
				session.save(student1);
				session.save(student2);

				System.out.println("Saved students: " + course.getStudentList());

				session.getTransaction().commit();
				System.out.println("Done!");
			}

		}
	}

}
