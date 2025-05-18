package com.Controller;

import javax.transaction.Transaction;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.Student;
import com.Util.HiibernateUtil;

public class Test {
     //session obj cretae two way-1>opensession(),2>getCurrentSession()-diff
	//beginTransaction()-1st open the transction -then add the data-add propery in cfg
	//session 1st lavel cache machanisum
	//session 2nd lavel cache machanisum
	
	public static void main(String[] args) {
		
		SessionFactory sf=HiibernateUtil.getSessionFactory();
		
	    Session session=sf.openSession();
	    Session session1=sf.getCurrentSession();
	    Session session2=sf.getCurrentSession();
		
	    Student s1=new Student();
	    s1.setSid(101);
	    s1.setSname("om");
	    s1.setSaddress("pune");
	    
	   
	    org.hibernate.Transaction t=session1.beginTransaction();
	   // session1.save(s1);
		/*
		 * Student s=session.get(Student.class, 101); System.out.println(s); //
		 */	    //session.evict(s);
	    
//	    Student s3=session.get(Student.class, 0);
//	    System.out.println(s3);
	    
	     t.commit();
		
	}
}
