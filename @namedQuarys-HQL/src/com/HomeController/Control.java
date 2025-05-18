package com.HomeController;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import java.util.List;
import java.util.Scanner;

import javax.transaction.Transaction;

import com.Util.HibernateUtil;

public class Control {

	public static void getAllstudents(SessionFactory sf) {
		
		Session s = sf.openSession();
		Query q = s.getNamedQuery("SHOWALLSTUDENT");
		List list = q.getResultList();
		System.out.println(list);
	}

	public static void getMarks(SessionFactory sf) {
		Session s = sf.openSession();
		Query q = s.getNamedQuery("MAXMARK");
		Object resulrt = q.getSingleResult();
		System.out.println(resulrt);

	}

	public static void geTStudentMarksNameStartP(SessionFactory sf) {
		Session s = sf.openSession();
		Query q = s.getNamedQuery("PNAMESTUDENTMARK");

		List list = q.getResultList();
		System.out.println(list);

	}
	public static void getStudentAddress(SessionFactory sf) {
		Session s = sf.openSession();
		Query q = s.getNamedQuery("StudentAddress");
		List list = q.getResultList();
		System.out.println(list);

	}
	public static void updateStudentName(SessionFactory sf) {
		Session s=sf.openSession();

		Scanner sc=new Scanner(System.in);
		
		org.hibernate.Transaction t = s.beginTransaction();
		Query query = s.getNamedQuery("UpdateStudent");

		System.out.println("enter the valid id");
		query.setParameter("id", sc.nextInt());
		System.out.println("Enter the new name");
		query.setParameter("name", sc.next());
		
		query.executeUpdate();
		t.commit();
		
	}
	public static void GetallStudentUsingNative(SessionFactory sf) {
		//@namedNativQuary()
		Session s=sf.openSession();
		Query query=s.getNamedNativeQuery("abc");
		List list = query.getResultList();
		System.out.println(list);

	}

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		 
		Scanner sc = new Scanner(System.in);
		boolean flag = true;
		while (flag) {

			System.out.println("1.getAllstudents");
			System.out.println("2.getMarks");
			System.out.println("3.geTStudentMarksNameStartP");
			System.out.println("4.getStudentAddress");
			System.out.println("5. updateStudentName");
			System.out.println("6.GetStudentSql");
			System.out.println("7.Exit");
			System.out.println("Enter the choise");
			int a = sc.nextInt();

			switch (a) {
			case 1:
				getAllstudents(sf);
				break;

			case 2:
				getMarks(sf);
				break;
			case 3:
				geTStudentMarksNameStartP(sf);
				break;
			case 4:
				geTStudentMarksNameStartP(sf);
				break;
			case 5:
				 updateStudentName( sf) ;
				 break;

			case 6:
				 GetallStudentUsingNative(sf);
				
				break;
			case 7:
				flag = false;
				System.out.println("exit");
				break;
			default:
				System.out.println("Enter the valid choise");
				break;
			}
			
	}
}
}
