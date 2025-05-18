package com.Controller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.Entity.Employee;

import com.Util.HibernateUtil;

public class Test {
	//partial inssertion and update
	//Dynamic insert anotetion
	//dynamic update anotetion
	//data base call reduce for insertion and upadate
	//its does not hit each column particular column insert or update accourding to partial insertion or update quaery

	public static void main(String[] args) {

		SessionFactory sf = HibernateUtil.getSessionFactory();

		Session s = sf.openSession();

		Employee e = new Employee();

		e.setEmployeeName("raju");
		e.setEmployeeAddress("satara");

		Employee e2 = new Employee();

		e2.setEmployeeAddress("mumbai");

		//s.save(e);
		
		Employee emp=s.get(Employee.class, 3);
		
		emp.setEmployeeName("sumit");
		s.update(emp);
		
		

		s.beginTransaction().commit();

	}
}
