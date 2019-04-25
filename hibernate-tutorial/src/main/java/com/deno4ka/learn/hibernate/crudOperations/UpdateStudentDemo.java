package com.deno4ka.learn.hibernate.crudOperations;

import com.deno4ka.learn.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class UpdateStudentDemo {

	public static void main(String[] args) {

		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.WARNING);

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session;
		try {
			session = factory.getCurrentSession();
			final int studentId = 1;
			session.beginTransaction();

			System.out.println("Getting student with id: " + studentId);
			Student student = session.get(Student.class, studentId);
			System.out.println("Get complete: " + student);

			System.out.println("Updating student...");
			student.setFirstName("Scooby");

			session.getTransaction().commit();

			session = factory.getCurrentSession();
			session.beginTransaction();
			System.out.println("Update email for all students");
			session.createQuery("update Student set email = 'foo@gmail.com'").executeUpdate();
			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
