package com.Entity;

import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;

public class HomeController {

	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		
		Session s=sf.openSession();
		
		Employee e=new Employee();
		
		e.setEid(1013);
		e.setEname("om");
		e.setEsalry(90000);
		
		/*
		 * Serializable id=s.save(e); System.out.println("updated id:"+id); s.save(e);
		 */
		/* s.persist(e); */
		s.saveOrUpdate(e);
		s.beginTransaction().commit();
		System.out.println("Done");
	}
}
