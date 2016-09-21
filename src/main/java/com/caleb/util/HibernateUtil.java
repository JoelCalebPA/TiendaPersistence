package com.caleb.util;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

	private static SessionFactory sessionFactory;
	
	private static SessionFactory crearSessionFactory() {
		try {
			// Crea el sessionFactory desde el archivo de configuraci�n de Hibernate
			Configuration configuration = new Configuration();
			configuration.configure("hibernate.cfg.xml");
			
			sessionFactory = configuration.buildSessionFactory();
			
			return sessionFactory;
		} catch (Exception ex) {
			System.err.println("La creaci�n del sessionFactory a fallado." + ex);
			throw new ExceptionInInitializerError(ex);
		}
	}
	
	public static SessionFactory getSessionFactory() {
		if (sessionFactory == null) {
			sessionFactory = crearSessionFactory();
		}
		return sessionFactory;
	}
	
}
