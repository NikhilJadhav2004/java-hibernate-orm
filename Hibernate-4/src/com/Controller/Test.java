package com.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.Employee;
import com.Entity.Student;
import com.Util.HibernateUtil;


public class Test {

	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session s=sf.openSession();
		/*
		 * Student s1=new Student();
		 * 
		 * s1.setSname("paras");
		 * 
		 * Employee e=new Employee();
		 * 
		 * e.setEmployeeName("om"); e.setEmployeeAddress("pune");
		 * 
		 * s.save(s1); s.save(e);
		 */
		     Student s2=new Student();
		     s2.setSname("mayur");
		     s.save(s2);
		     s.beginTransaction().commit();
		     
		
	}
}
