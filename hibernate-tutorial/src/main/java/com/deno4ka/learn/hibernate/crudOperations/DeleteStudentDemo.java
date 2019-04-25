package com.deno4ka.learn.hibernate.crudOperations;

import com.deno4ka.learn.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteStudentDemo {

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

//			System.out.println("Getting student with id: " + studentId);
//			Student student = session.get(Student.class, studentId);
//			System.out.println("Deleting student: " + student);
//			session.delete(student);

			System.out.println("Deleting student id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();

			session.getTransaction().commit();

			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
