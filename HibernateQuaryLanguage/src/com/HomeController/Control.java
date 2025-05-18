package com.HomeController;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;
import com.Util.HibernateUtil;

public class Control {

	public static void getAllstudents(SessionFactory sf) {
		// hql work on java classes and variables
		Session s = sf.openSession();
		Query q = s.createQuery("from HQL");
		List list = q.getResultList();
		System.out.println(list);
	}

	public static void getMarks(SessionFactory sf) {
		Session s = sf.openSession();
		Query q = s.createQuery("select Max(smark) from HQL");
		Object resulrt = q.getSingleResult();
		System.out.println(resulrt);

	}

	public static void geTStudentMarksNameStartP(SessionFactory sf) {
		Session s = sf.openSession();
		Query q = s.createQuery("select smark from HQL where sname like 'p%'");

		List list = q.getResultList();
		System.out.println(list);

	}
	public static void getStudentAddressUsingId(SessionFactory sf) {
		Session s = sf.openSession();
		Query q = s.createQuery("select saddress  from HQL ");

		List list = q.getResultList();
		System.out.println(list);

	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

//		getAllstudents(sf);
//		getMarks(sf);
//		geTStudentMarksNameStartP(sf);
//		getStudentAddressUsingId(sf);
//		Session s=sf.openSession();
//		Student s1=new Student();
//		
//		s1.setSaddress("ram");
//		s1.setSmark(86);
//		s.save(s1);
		// s.beginTransaction().commit();
////		
	}
}
