package com.Servise;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.Student;
import com.Entity.Subjects;
import com.Util.HibernateUtil;

public class ServiseImpl implements Servise {

	SessionFactory sf=HibernateUtil.getSessionFactory();
	@Override
	public void AddStudentWithSubject() {
		Scanner sc=new Scanner(System.in);
		Session s=sf.openSession();
		
		List<Subjects> list=new ArrayList<Subjects>();
		Student s1=new Student();
		System.out.println("Enter the Student name");
		s1.setStudentName(sc.next());
		System.out.println("Enter the student address");
		s1.setStudentAddress(sc.next());
		System.out.println("How many Subject we want to add");
		int a=sc.nextInt();
		for(int i=0;i<a;i++) {
			Subjects sub=new Subjects();
			System.out.println("Enter the subject Name");
			sub.setSubName(sc.next());
			list.add(sub);
		}
		 s1.setListOfSubject(list);
		 s.save(s1);
		 s.beginTransaction().commit();
		 System.out.println("Done");
		
	}

	@Override
	public void DisplayOnlyStudentDetails() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the studentId");
		Session s=sf.openSession();
		Student stu=s.get(Student.class,sc.nextInt());
		if(stu!=null) {
			System.out.println(stu.getStudentName());
			System.out.println(stu.getStudentAddress());
		}else {
			System.out.println("Id is not ragister");
		}
		
		
	}

	@Override
	public void DisplayAllDetails() {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the studentId");
		Session s=sf.openSession();
		Student stu=s.get(Student.class,sc.nextInt());
		if(stu!=null) {
			System.out.println(stu);
		}else {
			System.out.println("Id is not register");
		}
		
	}

	@Override
	public void DisplayOnlySubjectDetails() {
		Scanner sc=new Scanner(System.in);
		System.out.println("enter the studentId");
		Session s=sf.openSession();
		Student stu=s.get(Student.class,sc.nextInt());
		if(stu!=null) {
		List<Subjects> l1=stu.getListOfSubject();
			for(Subjects list:l1) {
				System.out.println(list);
		}
		}{
			System.out.println("Id is not register");
		}
		
		
	}

	@Override
	public void UpdateOnlyStudentDetailsUsingStudentID() {
		
		
	}
		

	@Override
	public void UpdateOnlySubjectDetailsUsingStudentID() {
		
		
	}

	@Override
	public void DeleteOnlyStudentDetailsUsingStudentID() {
		
		
	}

	@Override
	public void DeleteOnlySubjectDetailsUsingStudentID() {
		
		
	}

}
