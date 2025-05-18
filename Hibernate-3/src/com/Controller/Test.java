package com.Controller;

import java.nio.channels.SeekableByteChannel;

import javax.naming.directory.SearchControls;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.entity.Employee;
import com.util.HibernateUtil;

public class Test {

	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session session =sf.openSession();
		Session session2=sf.openSession();
		
		
		Employee e1=new Employee();
		Employee emp=session2.get(Employee.class, 2);
		System.out.println(emp.getEname());
		emp.setEname("om");
		/*
		 * e1.seteDept("Hr"); e1.setEaddress("Mumbai"); e1.setEsalary(2300.899);
		 * e1.setDOB("2/9/2005");
		 */
		
         session2.update(emp);
		
		/*
		 * e2.setEname("om"); e2.seteDept("Hr"); e2.setEaddress("pune");
		 */
		//e2.setDOB("2/3/2004");
		
		//session.update(e2);
		//session.save(e1);
		
		//session.persist(e1);
		
		//session.saveOrUpdate(e1);
		
		//session.update(e1);
		
		//session.delete(e1);
		
		//get and load method 
		
		/* Employee emp =session.get(Employee.class, 2); */
		
		System.out.println("done");
		
		/*
		 * Employee emp2=session2.get(Employee.class, 1);
		 * 
		 * System.out.println(emp2);
		 */
		session.beginTransaction().commit();
		
		
	}
}
