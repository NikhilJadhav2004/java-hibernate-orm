package com.Servise;

import java.util.ArrayList;
import java.util.List;

import java.util.Scanner;

import javax.transaction.SystemException;
import javax.transaction.Transaction;

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
		}else{
			System.out.println("Id is not register");
		}
		
		
	}

	@Override
	public void UpdateOnlyStudentDetailsUsingStudentID() {
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Student Id");
		Session s=sf.openSession();
		Student s1=new Student();
		Student student=s.get(Student.class, sc.nextInt());
		if(student!=null) {
			boolean flag=true;
			while(flag) {
				System.out.println("1.Update Student Name");
				System.out.println("2.Update Student Address");
				System.out.println("3.Exit");
				System.out.println("_____________________________________");
				System.out.println("Enter the choise");
				int ch=sc.nextInt();
				switch (ch) {
				case 1:
					System.out.println("Enter the new name");
					String name=sc.next();
					student.setStudentName(name);
					
					s.update(student);
					s.beginTransaction().commit();
					System.out.println("Done");
					break;
				case 2:
					System.out.println("Enter the new Address");
					String Add=sc.next();
					student.setStudentAddress(Add);
					s.update(student);
					s.beginTransaction().commit();
					System.out.println("Done");
					break;
				case 3:
					flag=false;
					System.out.println("Exit");
					break;
				default:
					System.out.println("Entre the correct Choise");
					break;
				}
				
			}
			
			
			
		}else {
			System.out.println("Id is not enrolled");
		}
		
		
	}
		

	@Override
	public void UpdateOnlySubjectDetailsUsingStudentID() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Student Id");
		Session s=sf.openSession();	
		Student student=s.get(Student.class, sc.nextInt());
		
		if(student!=null) {
			List<Subjects> listofsub=student.getListOfSubject();
			System.out.println("Which subject we want to update enter the sub id");
			int sid=sc.nextInt();
			for(Subjects sub:listofsub) {
				if(sub!=null && sub.getSubId()==sid) {
					System.out.println("Enter the subject name");
					sub.setSubName(sc.next());
					s.update(sub);
					s.beginTransaction().commit();
					System.out.println("Subject Updated");
				}
				
				
			}
		}else {
			System.out.println("id is not enrolled");
		}
	}

	@Override
	public void DeleteOnlyStudentDetailsUsingStudentID() {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter the Student Id");
		Session s=sf.openSession();	
		Student student=s.get(Student.class, sc.nextInt());
		if(student!=null) {
			student.setListOfSubject(null);
			s.save(student);
			s.delete(student);
			s.beginTransaction().commit();
		}else {
			System.out.println("Id is not enrolled");
		}
		
	}

	public void DeleteOnlySubjectDetailsUsingStudentID() {
	    Scanner sc = new Scanner(System.in);
	    System.out.println("Enter the Student Id");

	    Session s = sf.openSession();
	    org.hibernate.Transaction tx = null;

	    try {
	        tx = s.beginTransaction();

	        // Fetch the student by the provided ID
	        int studentId = sc.nextInt();
	        Student student = s.get(Student.class, studentId);

	        if (student != null) {
	            // Create a copy of the list to avoid ConcurrentModificationException
	            List<Subjects> listOfSub = new ArrayList<>(student.getListOfSubject());

	            // Delete subjects associated with this specific student
	            for (Subjects sub : listOfSub) {
	                student.getListOfSubject().remove(sub); // Remove association
	                s.delete(sub); // Delete the subject
	            }

	            System.out.println("Subjects for Student ID " + studentId + " deleted successfully.");
	        } else {
	            System.out.println("Student with ID " + studentId + " not found.");
	        }

	        tx.commit();
	    } catch (Exception e) {
	        if (tx != null) {
	            tx.rollback();
	        }
	        e.printStackTrace();
	    } finally {
	        s.close();
	    }
	}

}
