package com.deno4ka.learn.hibernate.crudOperations;

import com.deno4ka.learn.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateStudentDemo {

	public static void main(String[] args) {

		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.WARNING);

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			System.out.println("Creating new student object...");
			Student tempStudent = new Student("Paul", "Wall", "paul@luv2code.com");

			session.beginTransaction();

			System.out.println("Saving the student...");
			session.save(tempStudent);

			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
