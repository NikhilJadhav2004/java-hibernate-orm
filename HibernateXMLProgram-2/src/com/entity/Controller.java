package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Controller {

	public static void main(String[] args) {
		
		
		Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
		
		SessionFactory sf=cfg.buildSessionFactory();
		
		Session s=sf.openSession();
		
		Student s1=new Student();
		s1.setId(101);
		s1.setName("nikhil");
		
		s.save(s1);
		s.beginTransaction().commit();
		System.out.println("done");
		
		
	}
}
