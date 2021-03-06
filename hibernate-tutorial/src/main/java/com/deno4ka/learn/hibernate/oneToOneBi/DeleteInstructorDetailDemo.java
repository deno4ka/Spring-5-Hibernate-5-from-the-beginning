package com.deno4ka.learn.hibernate.oneToOneBi;

import com.deno4ka.learn.hibernate.entity.Instructor;
import com.deno4ka.learn.hibernate.entity.InstructorDetail;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class DeleteInstructorDetailDemo {

	public static void main(String[] args) {

		Logger log = Logger.getLogger("org.hibernate");
		log.setLevel(Level.WARNING);

		try (SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		     Session session = factory.getCurrentSession()) {
			
			session.beginTransaction();

			final int instructorDetailId = 3;
			InstructorDetail instructorDetail = session.get(InstructorDetail.class, instructorDetailId);

			// break bi-directional link
			instructorDetail.getInstructor().setInstructorDetail(null);

			System.out.println("Deleting instructorDetail: " + instructorDetail);
			session.delete(instructorDetail);

			session.getTransaction().commit();
			System.out.println("Done!");
		} catch(Exception e) {
			e.printStackTrace();
		}

	}

}
