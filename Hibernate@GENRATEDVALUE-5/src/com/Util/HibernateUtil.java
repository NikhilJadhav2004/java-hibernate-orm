package com.Util;

import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.MetadataSource;

import com.Entity.Employee;
import com.Entity.Student;

//@genratedvalu(stratergies)
//Session obj cereation two ways
public class HibernateUtil {

	private HibernateUtil() {

	}

	private static StandardServiceRegistry registry = null;

	private static SessionFactory sf = null;

	public static SessionFactory getFactory() {

		if (sf == null) {

			HashMap<String, Object> map = new HashMap<String, Object>();

			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/jspm");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "Admin@123");

			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			map.put(Environment.HBM2DDL_AUTO, "create");
			map.put(Environment.SHOW_SQL, "true");
			map.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();

			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(Student.class)
					.addAnnotatedClass(Employee.class);

			Metadata md = mds.getMetadataBuilder().build();
			sf = md.getSessionFactoryBuilder().build();
			return sf;
		}
		return sf;
	}

}
