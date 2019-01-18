package com.hibernate.practice.util;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import com.hibernate.practice.pojo.Employee;

public class HibernateUtil {

	private static SessionFactory sessionFactory;

	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			Properties properties = new Properties();
			properties.setProperty(Environment.DRIVER, "com.mysql.jdbc.Driver");
			properties.setProperty(Environment.URL, "jdbc:mysql://localhost/java-fullstack");
			properties.setProperty(Environment.USER, "root");
			properties.setProperty(Environment.PASS, "");
			properties.setProperty(Environment.DIALECT, "org.hibernate.dialect.MySQL5Dialect");
			properties.setProperty(Environment.SHOW_SQL, "true");
			properties.setProperty(Environment.FORMAT_SQL, "true");
			properties.setProperty(Environment.HBM2DDL_AUTO, "update");

			Configuration configuration = new Configuration();
			configuration.setProperties(properties);
			configuration.addAnnotatedClass(Employee.class);

			ServiceRegistry registry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties())
					.build();
			sessionFactory = configuration.buildSessionFactory(registry);
		}
		return sessionFactory;

	}

}
