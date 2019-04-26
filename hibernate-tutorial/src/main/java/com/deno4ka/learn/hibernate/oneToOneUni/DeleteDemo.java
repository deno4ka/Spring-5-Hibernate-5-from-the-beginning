package com.deno4ka.learn.hibernate.oneToOneUni;

import com.deno4ka.learn.hibernate.entity.Instructor;
import com.deno4ka.learn.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteDemo {

	public static void main(String[] args) {

		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.WARNING);

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();
			final int instructorId = 1;
			Instructor instructor = session.get(Instructor.class, instructorId);
			System.out.println("Found instructor: " + instructor);
			if (instructor != null) {
				session.delete(instructor);
			}
			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
