package com.Service;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.AdharCard;
import com.Entity.Person;
import com.Util.HibernateUtil;

public class ServiceImpl implements SerciceClass {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	Scanner sc = new Scanner(System.in);

	@Override
	public void addpersonwithadhar() {

		Session s = sf.openSession();

		Person p = new Person();
		System.out.println("Enter the Name");

		String name = sc.next();

		p.setPersonName(name);

		System.out.println("Enter the personAddress");
		p.setPersonAddress(sc.next());

		AdharCard adhar = new AdharCard();
		System.out.println("Enter the adhar number");
		adhar.setAdharNo(sc.next());

		p.setAdharCard(adhar);

		s.save(p);

		s.beginTransaction().commit();
		

	}

	@Override
	public void getpersonOnlyUsingPersonId() {
		
		Session s=sf.openSession();
		System.out.println("enter the person id");
		Person p=s.get(Person.class, sc.nextInt());
		if(p!=null) {
		
		System.out.println(p.getPersonName()+" "+p.getPersonAddress());

	}else {
		System.out.println("Enter the valid personId");
	}
	}

	@Override
	public void getadharOnlyUsingPesronId() {
		Session s=sf.openSession();
		System.out.println("enter the person id");
		Person p=s.get(Person.class, sc.nextInt());
		if(p!=null) {
		
		System.out.println(p.getAdharCard());

	}else {
		System.out.println("Enter the valid personId");
	}
	}

	@Override
	public void updatePersonOnlyUsingPersonId() {
		
		Session s=sf.openSession();
		
		System.out.println("enter the person id");
		Person p=s.get(Person.class, sc.nextInt());
		if(p!=null) {
			System.out.println("Enter the new name");
			p.setPersonName(sc.next());
			s.update(p);
			s.beginTransaction().commit();
		}
		else {
			System.out.println("Enter valid id");
		}

	}

	@Override
	public void updateadharonlyUsingPersonId() {
        Session s=sf.openSession();
		
		System.out.println("enter the person id");
		Person p=s.get(Person.class, sc.nextInt());
		if(p!=null) {
			AdharCard a=new AdharCard();
			System.out.println("Enter the new AdharNo");
			a.setAdharNo(sc.next());
			p.setAdharCard(a);
			s.update(p);
			s.beginTransaction().commit();
		}
		else {
			System.out.println("Enter valid id");
		}

	}

	@Override
	public void deletePersonOnlyUsingPersonID() {
		
         Session s=sf.openSession();
		
		System.out.println("enter the person id");
		Person p=s.get(Person.class, sc.nextInt());
		if(p!=null) {
			
			
			s.delete();
			
			s.beginTransaction().commit();
		}
		else {
			System.out.println("Enter valid id");
		}


	}

	@Override
	public void deleteAdharonlyUsingPersonId() {
		
	}

	@Override
	public void addPersonOnly() {
		Session s = sf.openSession();

		Person p = new Person();
		System.out.println("Enter the Name");

		String name = sc.next();

		p.setPersonName(name);

		System.out.println("Enter the personAddress");
		p.setPersonAddress(sc.next());

		s.save(p);
		s.beginTransaction().commit();
		
	}

	@Override
	public void addAdharOnly() {

		AdharCard adhar = new AdharCard();
		System.out.println("Enter the adhar number");
		adhar.setAdharNo(sc.next());

		Session s = sf.openSession();
		s.save(adhar);
		s.beginTransaction().commit();
		
	}

}
