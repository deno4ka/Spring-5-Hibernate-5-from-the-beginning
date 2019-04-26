package com.deno4ka.learn.hibernate.oneToOneUni;

import com.deno4ka.learn.hibernate.entity.Instructor;
import com.deno4ka.learn.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateDemo {

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
			Instructor instructor = new Instructor("Chad", "Darby", "darby@luv2code.com");
			InstructorDetail instructorDetail = new InstructorDetail("http://www.luv2code.com/youtube", "Luv 2 code!!!");
			instructor.setInstructorDetail(instructorDetail);

			Instructor instructor2 = new Instructor("Madhu", "Patel", "madhu@luv2code.com");
			InstructorDetail instructorDetail2 = new InstructorDetail("http://www.youtube.com", "Guitar");
			instructor2.setInstructorDetail(instructorDetail2);

			session.beginTransaction();
			System.out.println("Saving instructor: " + instructor);
			session.save(instructor);
			session.save(instructor2);

			session.getTransaction().commit();
			System.out.println("Done!");
		} finally {
			factory.close();
		}

	}

}
