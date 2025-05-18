package com.Entity;

import java.nio.channels.SeekableByteChannel;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Util.HibernateUtil;

public class Test {
	
	public static void main(String[] args) {
		
	Student s1=new Student();
	
	s1.setSid(101);
	s1.setSname("Ram");
	s1.setsAddress("pune");
	
	Student s2=new Student();
	s2.setSid(102);
	s2.setSname("raj");	
	s2.setsAddress("mumbai");
	
	SessionFactory  sf=HibernateUtil.getSessionFactory();
	
	Session s=sf.openSession();
	
	//s.save(s1);
	//s.saveOrUpdate(s2);
	//s.update(s1);
	//s.delete(s2);
	
    Student a=s.get(Student.class, 101);  
    System.out.println(a);
    
    Student b=s.load(Student.class, 102);
    System.out.println(b);
    
	
	s.beginTransaction().commit();

	
	}

}
