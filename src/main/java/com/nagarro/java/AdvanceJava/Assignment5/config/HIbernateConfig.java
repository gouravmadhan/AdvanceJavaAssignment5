package com.nagarro.java.AdvanceJava.Assignment5.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.nagarro.java.AdvanceJava.Assignment5.entity.HrRecord;

public class HIbernateConfig {
	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			try {
				sessionFactory = new Configuration().configure("hibernate.config.xml").addAnnotatedClass(HrRecord.class)
						.buildSessionFactory();
			} catch (Exception e) {
				System.out.println("Session Factory Build UnsuccessFul");
			}
		}
		return sessionFactory;
	}
}
