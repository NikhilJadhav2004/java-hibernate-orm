package com.Util;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Environment;
import org.hibernate.mapping.MetadataSource;

import com.Entity.AdharCard;
import com.Entity.Person;

public class HibernateUtil {

	private HibernateUtil() {
		
	}
	private static SessionFactory sf=null;
	
	private static StandardServiceRegistry regisrty=null;
	
	public static SessionFactory getSessionFactory() {
		
		if(sf==null) {
			
			Map<String ,Object> map=new HashMap<String, Object>();
			
			map.put(Environment.DRIVER, "com.mysql.jdbc.Driver");
			map.put(Environment.URL, "jdbc:mysql://localhost:3306/Exponent");
			map.put(Environment.USER, "root");
			map.put(Environment.PASS,"Admin@123");
			 
			map.put(Environment.DIALECT, "org.hibernate.dialect.MySQL8Dialect");
			map.put(Environment.HBM2DDL_AUTO, "update");
			map.put(Environment.FORMAT_SQL, true);
			map.put(Environment.SHOW_SQL, true);
			map.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, "thread");
			
			regisrty=new StandardServiceRegistryBuilder().applySettings(map).build();
			
			MetadataSources mds=new MetadataSources(regisrty).addAnnotatedClass(Person.class).addAnnotatedClass(AdharCard.class);
			
			Metadata md=mds.getMetadataBuilder().build();
			
			sf=md.getSessionFactoryBuilder().build();
			
			return sf;
			
	}
	return sf;
}
}
