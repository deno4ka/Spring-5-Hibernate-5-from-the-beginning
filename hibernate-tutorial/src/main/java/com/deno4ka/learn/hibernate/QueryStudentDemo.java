package com.deno4ka.learn.hibernate;

import com.deno4ka.learn.hibernate.entity.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class QueryStudentDemo {

	public static void main(String[] args) {

		SessionFactory factory = new Configuration()
				.configure("hibernate.cfg.xml")
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();

		Session session = factory.getCurrentSession();
		try {
			session.beginTransaction();

			session.getTransaction().commit();
		} finally {
			factory.close();
		}

	}

}
