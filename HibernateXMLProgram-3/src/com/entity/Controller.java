package com.entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Controller {

	public static void main(String[] args) {
		
		
	Configuration cfg=new Configuration().configure("hibernate.cfg.xml");
	
	SessionFactory sf=cfg.buildSessionFactory();
	Session s=sf.openSession();
	
	
	Employee e=new Employee();
	
	e.setEid(101);
	e.setEname("ram");
	e.setEsalary(45000.9000);
	
	s.save(e);
	
	s.beginTransaction().commit();
	System.out.println("Sucess");
	}
}
