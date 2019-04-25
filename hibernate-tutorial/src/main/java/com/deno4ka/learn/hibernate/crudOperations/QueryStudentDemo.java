package com.deno4ka.learn.hibernate.crudOperations;

import com.deno4ka.learn.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class QueryStudentDemo {

	public static void main(String[] args) {

		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.WARNING);

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();



		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			List<Student> studentList = session.createQuery("from Student", Student.class).list();
			displayStudents(studentList);

			studentList = session.createQuery("from Student s where s.lastName = 'Doe'", Student.class).list();
			displayStudents(studentList);

			studentList = session.createQuery("from Student s where s.lastName = 'Doe' or s.firstName = 'Daffy'", Student.class).list();
			displayStudents(studentList);

			studentList = session.createQuery("from Student s where s.email like '%luv2code.com'", Student.class).list();
			displayStudents(studentList);

			studentList = session.createQuery("from Student s where s.email like '%gmail.com'", Student.class).list();
			displayStudents(studentList);

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

	private static void displayStudents(List<Student> studentList) {
		System.out.println();
		for (Object student : studentList) {
			System.out.println(student);
		}
	}

}
