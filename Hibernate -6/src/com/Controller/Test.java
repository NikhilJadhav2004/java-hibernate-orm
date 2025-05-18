package com.Controller;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.Student;
import com.Util.HiibernateUtil;

public class Test {
     
	//session 2nd lavel cache machanisum
	
	public static void main(String[] args) {
		
		SessionFactory sf=HiibernateUtil.getSessionFactory();
		
	Session s1=sf.openSession();
	Session s2	=sf.openSession();
	Session s3	=sf.openSession();
		
		Student s=new Student();
		s.setSid(102);
		s.setSname("ram");
		s.setSaddress("pune");
		
		//s1.save(s);
		
		Student a=s1.get(Student.class, 101);
		System.out.println(a);
		
		System.out.println("----------------------------------------------");
		
		Student b=s1.get(Student.class, 101);
		System.out.println(b);
		
		
		Student c=s3.get(Student.class, 102);
		System.out.println(c);
		
		System.out.println("-------------------------------------------------");
		
		Student d=s3.get(Student.class, 102);
		System.out.println(c);
		
		
		
		s1.beginTransaction().commit();
		
	
	}
}
