package com.Entity;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;

public class Controller {

	public static void main(String[] args) {
		
	SessionFactory sf=HibernateUtil.getFactory();
	Session s=sf.openSession();
	Session c=sf.openSession();
	System.out.println(s.hashCode());
	System.out.println(c.hashCode());
	System.out.println("___________________________________________________");
	Session a=sf.getCurrentSession();
	Session b=sf.getCurrentSession();
	System.out.println(a.hashCode());
	System.out.println(b.hashCode());
	System.out.println("------------------------------------------------");
	Scanner sc=new Scanner(System.in);
	
	Student s1=new Student();
	Employee e1=new Employee();
	
	System.out.println("ENTER SNAME");
	s1.setSname(sc.next());
	System.out.println("Enter the Saddress");
	s1.setSaddress(sc.next());
	
	System.out.println("enter ename");
	e1.setEname(sc.next());
	System.out.println("enter address emp");
	e1.setEaddress(sc.next());
	
	s.save(e1);

	s.save(s1);
	s.beginTransaction().commit();
	
	
	System.out.println("---------------------------------------------------------s");
	
	}
}
