package utils;



import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import models.*;


public class HibernateConnection {
	public static SessionFactory sessionFactory;
	static String url = "jdbc:mysql://localhost:3306/mini_project?characterEncoding=UTF-8";
	static String uname = "root";
	static String pwd = "1234";
	
	public static SessionFactory  doHibernateConnection() {
		Properties database = new Properties();
		
		//database.setProperty("hibernate.hbm2ddl.auto", "create");
		database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		database.setProperty("hibernate.connection.username", uname);
		database.setProperty("hibernate.connection.password", pwd);
		database.setProperty("hibernate.connection.url", url);
		database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
		Configuration cfg = new Configuration()
				.setProperties(database)
				.addPackage("models")
				.addAnnotatedClass(Person.class)
				.addAnnotatedClass(Appoinment.class)
				.addAnnotatedClass(AppoinmentWeekDay.class)
				.addAnnotatedClass(BuyService.class)
				.addAnnotatedClass(Logins.class)
				.addAnnotatedClass(Receipt.class)
				.addAnnotatedClass(Service.class)
				.addAnnotatedClass(ServiceType.class)
				.addAnnotatedClass(UpLoadPayment.class)
				.addAnnotatedClass(Room.class)
				.addAnnotatedClass(Doctor.class)
				.addAnnotatedClass(Expertise.class)
				;
			
				
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
		sessionFactory = cfg.buildSessionFactory(ssrb.build());
		return sessionFactory;
	}

}
