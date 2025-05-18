package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Test {
	
	public static void main(String[] args) {
		Configuration cnf = new Configuration().configure("hibernate.cfg.xml");

		

		Student s1 = new Student();
		s1.setId(11);
		s1.setName("Nikhil");

		SessionFactory sf = cnf.buildSessionFactory();
		Session s = sf.openSession();
		s.save(s1);
		s.beginTransaction().commit();
	}

}
