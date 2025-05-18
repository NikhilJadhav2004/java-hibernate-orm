package com.Util;

import java.util.HashMap;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;

import com.Entity.Student;
public class HibernateUtil {

	private static StandardServiceRegistry registry=null;
	
	private static SessionFactory sf=null;

	public static SessionFactory getSessionFactory() {

		if (sf == null) {

			HashMap<String, Object> map = new HashMap<String, Object>();
			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/Jspm");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS, "Admin@123");

			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			map.put(Environment.HBM2DDL_AUTO, "update");
			map.put(Environment.SHOW_SQL, true);
			//2nd lavel cache add property
			map.put(Environment.CACHE_REGION_FACTORY, "org.hibernate.cache.ehcache.internal.EhcacheRegionFactory");

			registry = new StandardServiceRegistryBuilder().applySettings(map).build();

			MetadataSources mds = new MetadataSources(registry).addAnnotatedClass(Student.class);
			Metadata md = mds.getMetadataBuilder().build();
			sf = md.getSessionFactoryBuilder().build();
			return sf;

		}
		return sf;
	}
}
