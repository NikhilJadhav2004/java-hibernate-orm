package com.Servise;

import java.security.Provider.Service;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.Update;

import com.Entity.AdharCard;
import com.Entity.Person;
import com.Util.HibernateUtil;

public class ServiseImpl implements Servise {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	Scanner sc = new Scanner(System.in);

	@Override
	public void AddPersonWithhAdhar() {
		Session s = sf.openSession();

		Person p = new Person();
		System.out.println("Enter the person Name");
		String personName = sc.next();
		p.setPersonName(personName);
		System.out.println("Enter the person Address");
		p.setPersonAddress(sc.next());
		AdharCard a = new AdharCard();
		System.out.println("Enter the Adhar Number");
		a.setAdharNumber(sc.next());
		p.setAdharcard(a);
		s.save(p);
		s.beginTransaction().commit();
		System.out.println("Data Sucessfully Entered");

	}

	@Override
	public void GetPersonOnlyUsingPersonId() {

		System.out.println("Enter the person id we want to get the details");
		Session s = sf.openSession();
		Person p = s.get(Person.class, sc.nextInt());
		if (p == null) {
			System.out.println("Data is not registerd");
		} else {
			System.out.println(p.getPersonName() + " " + p.getPersonAddress());

		}
	}

	@Override
	public void GetAdharOnlyUsingPersonId() {
		System.out.println("Enter the person id we want to get the details");
		Session s = sf.openSession();
		Person p = s.get(Person.class, sc.nextInt());
		AdharCard a = new AdharCard();
		if (p == null) {
			System.out.println("Data is not registerd");
		} else {
			System.out.println(p.getAdharcard());

		}
	}

	@Override
	public void UpdatePersonOnlyUsingPersonId() {

		System.out.println("Enter the person id we want to get the details");
		Session s = sf.openSession();
		Person p = s.get(Person.class, sc.nextInt());
		if (p != null) {

			boolean flag = true;

			while (flag) {

				System.out.println("1.Update Name");
				System.out.println("2.Update Address");
				System.out.println("3.Exit");
				System.out.println("Enter the choise");
				int a = sc.nextInt();

				switch (a) {
				case 1:
					System.out.println("Enter the new name");
					String name = sc.next();
					p.setPersonName(name);
					s.update(p);
					s.beginTransaction().commit();
					System.out.println("Data sucessfully enterd");

					break;

				case 2:
					System.out.println("Enter the new Address");
					String Address = sc.next();
					p.setPersonAddress(Address);
					s.update(p);
					s.beginTransaction().commit();
					System.out.println("Data sucessfully enterd");
					break;
				case 3:
					System.out.println("Exit");
					flag = false;
					break;

				default:
					System.out.println("Enter the valied choise");
					break;
				}
			}

		} else {
			System.out.println("Data is not registerd");

		}
	}

	@Override
	public void UpdateAdharOnlyUsingPersonId() {

		System.out.println("Enter the person id we want to get the details");
		Session s = sf.openSession();
		Person p = s.get(Person.class, sc.nextInt());
		AdharCard adhar = new AdharCard();
		if (p != null) {

			boolean flag = true;

			while (flag) {

				System.out.println("1.Update AdharNumber");
				System.out.println("2.Exit");
				System.out.println("Enter the choise");
				int a = sc.nextInt();

				switch (a) {
				case 1:
					System.out.println("Enter the new AdharNum");
					String num = sc.next();
					adhar.setAdharNumber(num);
					p.setAdharcard(adhar);
					s.update(p);
					s.beginTransaction().commit();
					System.out.println("Data sucessfully enterd");

					break;

				case 2:
					System.out.println("Exit");
					flag = false;
					break;

				default:
					System.out.println("Enter the valied choise");
					break;
				}
			}

		} else {
			System.out.println("Data is not registerd");

		}
	}

	@Override
	public void DeletePersonOnlyUsingPersonId() {
		System.out.println("Enter the person id we want to get the details");
		Session s = sf.openSession();
		Person p = s.get(Person.class, sc.nextInt());
		if (p != null) {
			p.setAdharcard(null);
			s.update(p);
			s.delete(p);
			s.beginTransaction().commit();
			System.out.println("Done");
		} else {
			System.out.println("id is not registre");
		}
	}

	@Override
	public void DeleteAdharOnlyUsingPersonId() {
		System.out.println("enter the person id");
		Session s = sf.openSession();
		Person p = s.get(Person.class, sc.nextInt());
		if (p != null) {

			AdharCard ad = p.getAdharcard();
			p.setAdharcard(null);
			s.update(ad);
			s.delete(ad);
			s.beginTransaction().commit();
			System.out.println("Done");

		} else {
			System.out.println("id is not registre");
		}
	}

	@Override
	public void AddPersonOnly() {
		Session s = sf.openSession();

		Person p = new Person();
		System.out.println("Enter the person Name");
		String personName = sc.next();
		p.setPersonName(personName);
		System.out.println("Enter the person Address");
		p.setPersonAddress(sc.next());
		s.save(p);
		s.beginTransaction().commit();
		System.out.println("Done");

	}

	@Override
	public void AddAdharOnly() {

		Session s = sf.openSession();
		Scanner sc = new Scanner(System.in);
		AdharCard adhar = new AdharCard();
		System.out.println("enter the adhar number");
		String name = sc.next();

		adhar.setAdharNumber(name);
		s.save(adhar);
		s.beginTransaction().commit();
		System.out.println("Done");
	}

}
