package com.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;

public class Controller {

	//diff between load and get ()
	public static void main(String[] args) {
		
		SessionFactory sf=HibernateUtil.getSessionFactory();
		Session s=sf.openSession();
		
		Studant s1=new Studant();
		s1.setRollNO(14);
		s1.setName("savita");
		s1.setSirName("Jadhav");
		s1.setDOB("30/4/1989");
		
		//s.save(s1);
	
//		Studant st=s.get(Studant.class, 13);
//		System.out.println(st);
//		
		
		Studant st1=s.load(Studant.class, 14);
		System.out.println(st1);
		s.beginTransaction().commit();
		System.out.println("Data insert");
	}
}
