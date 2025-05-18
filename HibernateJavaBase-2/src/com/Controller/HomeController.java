package com.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.StudentCollage;
import com.Util.HibernateUtil;

public class HomeController {

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory1();
		Session s = sf.openSession();

		StudentCollage s1 = new StudentCollage();

		s1.setSid(103);
		s1.setSname("sham");
		s1.setSmark(92.90);
		s1.setBloodgroup("o+");
		s1.setDob("2/3/2007");

		s.save(s1);

		s.beginTransaction().commit();

		System.out.println("Done");
	}
}
