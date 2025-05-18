package com.Entity;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.annotations.Cache;

import com.Util.HibernateUtil;

public class HomeContoller {

public static void main(String[] args) {
	
	SessionFactory sf=HibernateUtil.getSessionFactory();
	
	Session s=sf.openSession();
	
	Session s1=sf.openSession();
	Session s2=sf.openSession();
//	Student s1=new Student();
//	s1.setName("Shreya");
//	s1.setAddress("Gursale");
//	
//	s.save(s1);
	
//	System.out.println("@@@@@@@@@@@@@@@@@@@___First lavel cache_______@@@@@@@@@@@@@");
//	Student a=s.get(Student.class,1);
//	System.out.println(a);
	
	//delete particular cache on session
	//s.evict(a);
//	
//	Student b=s.get(Student.class,1);
//	System.out.println(b);
//	
//	//delete all cache on session
//	s.clear();
//
//	Student c=s.get(Student.class,1);
//	System.out.println(c);
	
	
//session is change then the select quary fire in 1st lavel
	//like-
	
//	Student d=s1.get(Student.class,1);
//	System.out.println(d);
//	
	
//	System.out.println("___________________2nd lavel cache_________________");
//	
//	//in 2nd lavel cache multiple session fetch the data session factory,like-
//	Student b=s.get(Student.class,1);
//	System.out.println(b);
//
//	Student d=s1.get(Student.class,1);
//	System.out.println(d);
//	
//	//delete data copyed data on session factory-get cache then delete
//    javax.persistence.Cache ch=sf.getCache();
//    ch.evict(Student.class);
//	
//	
//    Student e=s2.get(Student.class, 1);
//    System.out.println(e);
  
    System.out.println("______________partial insertion and updation----------------");
	
    Student l=new Student();
//    l.setName("kavita");
//    s.persist(l);
//	
    System.out.println("-----------update-----------");
    
   Student p= s.get(Student.class, 3);
   p.setAddress("Satara");
   s.update(p);
   
   
	s.beginTransaction().commit();
	System.out.println("________________________Data insert________________________");
}
}
