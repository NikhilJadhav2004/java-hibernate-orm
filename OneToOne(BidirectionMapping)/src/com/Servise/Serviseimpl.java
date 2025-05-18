package com.Servise;

import java.security.Provider.Service;
import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.sql.Update;

import com.Entity.AdharCard;
import com.Entity.Person;
import com.Util.HibernateUtil;

public class Serviseimpl implements Servise {

	SessionFactory sf = HibernateUtil.getSessionFactory();

	Scanner sc = new Scanner(System.in);

	@Override
	public void AddPersonWithAdhar() {
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
		// Has a relation-relation in both direction
		p.setAdharcard(a);
		a.setPerson(p);

		s.save(a);

		s.beginTransaction().commit();
		System.out.println("Done");

	}

	@Override
	public void GetPersonOnlyUsingPersonId() {
		System.out.println("Enter the person id we want to get the details");
		Session s = sf.openSession();
		Person p = s.get(Person.class, sc.nextInt());
		if (p == null) {
			System.out.println("Data is not registerd");
		} else {
			System.out.println(p.getPersonName() + p.getPersonAddress());

		}
	}

	@Override
	public void GetPersonOnlyUsingAdharId() {

		System.out.println("Enter the Adhar id we want to get the details");
		Session s = sf.openSession();
		AdharCard ad = new AdharCard();
		AdharCard adhar = s.get(AdharCard.class, sc.nextInt());
		if (adhar != null) {
			System.out.println(adhar.getPerson());
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
	public void GetAdharOnlyUsingAdharId() {

		System.out.println("Enter the Adhar id we want to get the details");
		Session s = sf.openSession();
		AdharCard ad = new AdharCard();
		AdharCard adhar = s.get(AdharCard.class, sc.nextInt());
		if (adhar != null) {
			System.out.println(adhar.getAdharId() + " " + " " + adhar.getAdharNumber());
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
	public void UpdatePersonOnlyUsingAdahrId() {

		System.out.println("Enter the adhar we want to upadate");
		Session s = sf.openSession();
		AdharCard adhar = s.get(AdharCard.class, sc.nextInt());
		if (adhar != null) {
			boolean flag = true;
			Person p = new Person();
			while (flag) {
				System.out.println("1.Update name");
				System.out.println("2.Update Address");
				System.out.println("3.exit");
				System.out.println("Enter the choise");
				int a = sc.nextInt();
				switch (a) {
				case 1:
					System.out.println("Enter the new name");
					String name = sc.next();
					adhar.getPerson().setPersonName(name);
					s.update(adhar);
					s.beginTransaction().commit();
					System.out.println("done");

					break;
				case 2:
					System.out.println("Enter the new address");

					adhar.getPerson().setPersonAddress(sc.next());
					s.update(adhar);
					s.beginTransaction().commit();
					System.out.println("done");

					break;
				case 3:
					flag = false;
					System.out.println("Exit");
					break;
				default:
					System.out.println("Enter the correct choise");
					break;
				}
			}
		} else {
			System.out.println("data is not register");
		}

	}

	@Override
	public void UpdateAdharOnlyUsingPersonId() {
		System.out.println("Enter the person id");
		int id = sc.nextInt();

		Session s = sf.openSession();

		Person p = s.get(Person.class, id);
		if (p != null) {

			System.out.println("Enter the new adhar number");
			p.getAdharcard().setAdharNumber(sc.next());
			s.update(p);
			s.beginTransaction().commit();
			System.out.println("Done");

		}

	}

	@Override
	public void UpdateAdharOnlyUsingAdahrId() {
		System.out.println("Enter the adhar id");

		AdharCard adhar = new AdharCard();

		Session s = sf.openSession();

		AdharCard a = s.get(AdharCard.class, sc.nextInt());
		if (a != null) {
			System.out.println("Enter the new adhar number");

			a.setAdharNumber(sc.next());

			s.update(a);

			s.beginTransaction().commit();
			System.out.println("Done");
		}
	}

	@Override
	public void DeletePersonOnlyUsingPersonId() {
		System.out.println("Enter the person id we want to delete the details");
		Session s = sf.openSession();
		Person p = s.get(Person.class, sc.nextInt());
		if (p != null) {
			AdharCard adhar = p.getAdharcard();
			adhar.setPerson(null);
			p.setAdharcard(null);
			s.update(p);
			s.delete(p);
			s.beginTransaction().commit();
			System.out.println("Done");

		} else {
			System.out.println("Data is not registerd");

		}
	}

	@Override
	public void DeletePersonOnlyUsingAdharId() {

		System.out.println("Enter the Adhar id");

		Session s = sf.openSession();

		AdharCard adhar = s.get(AdharCard.class, sc.nextInt());

		if (adhar != null) {

			Person p1 = adhar.getPerson();
			adhar.setPerson(null);
			p1.setAdharcard(null);
			s.update(p1);
			s.delete(p1);
			s.beginTransaction().commit();
			System.out.println("Susessfully deleted data");
		} else {
			System.out.println("not register the this id");
		}

	}

	@Override
	public void DeleteAdharOnlyUsingPersonId() {

		Session s = sf.openSession();

		System.out.println("Enter the person id");

		Person p = s.get(Person.class, sc.nextInt());

		if (p != null) {

			AdharCard ad = p.getAdharcard();
			ad.setPerson(null);
			p.setAdharcard(null);
			s.update(ad);
			s.delete(ad);
			s.beginTransaction().commit();
			System.out.println("Dones");

		} else {
			System.out.println("Data is not register");
		}

	}

	@Override
	public void DeleteAdharOnlyUsingAdharId() {
		System.out.println("Enter the adhar id");

		AdharCard adhar = new AdharCard();

		Session s = sf.openSession();

		AdharCard a = s.get(AdharCard.class, sc.nextInt());
		if (a != null) {

			Person p = a.getPerson();
			p.setAdharcard(null);
			a.setPerson(null);
			s.update(a);
			s.delete(a);
			s.beginTransaction().commit();
			System.out.println("Done");
		} else {
			System.out.println("Data is  not register");
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
