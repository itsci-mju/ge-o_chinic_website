package org.itsci.utils;

import java.beans.PropertyVetoException;
import java.util.Properties;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import org.itsci.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.sql.DataSource;

@org.springframework.context.annotation.Configuration
@EnableTransactionManagement
@PropertySource("classpath:persistence.properties")
public class HibernateConnection {

	@Autowired
	private Environment env;

	@Bean
	public PlatformTransactionManager hibernateTransactionManager() {
		HibernateTransactionManager transactionManager = new HibernateTransactionManager();
		transactionManager.setSessionFactory(sessionFactory().getObject());
		return transactionManager;
	}

	@Bean
	public LocalSessionFactoryBean sessionFactory() {
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(dataSource());
		sessionFactory.setPackagesToScan(new String[] { "org.itsci.models" });
		sessionFactory.setHibernateProperties(hibernateProperties());
		return sessionFactory;
	}

	private final Properties hibernateProperties() {
		Properties hibernateProperties = new Properties();
		hibernateProperties.setProperty("hibernate.hbm2ddl.auto", env.getProperty("hibernate.hbm2ddl.auto"));
		hibernateProperties.setProperty("hibernate.dialect.storage_engine", env.getProperty("hibernate.dialect.storage_engine"));
		hibernateProperties.setProperty("hibernate.dialect", env.getProperty("hibernate.dialect"));
		hibernateProperties.setProperty("hibernate.show_sql", env.getProperty("hibernate.show_sql"));
		return hibernateProperties;
	}

	@Bean
	public DataSource dataSource() {
		// create connection pool
		ComboPooledDataSource securityDataSource = new ComboPooledDataSource();

		// set JDBC driver class
		try {
			securityDataSource.setDriverClass(env.getProperty("jdbc.driver"));
		} catch (PropertyVetoException exc) {
			throw new RuntimeException(exc);
		}

		// set database connection props
		securityDataSource.setJdbcUrl(env.getProperty("jdbc.url"));
		securityDataSource.setUser(env.getProperty("jdbc.user"));
		securityDataSource.setPassword(env.getProperty("jdbc.password"));

		// set connection pool props
		securityDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
		securityDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
		securityDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
		securityDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));

		return securityDataSource;
	}

	private int getIntProperty(String propName) {
		String propVal = env.getProperty(propName);
		int intPropVal = Integer.parseInt(propVal);
		return intPropVal;
	}

//	public static SessionFactory  doHibernateConnection() {
//		Properties database = new Properties();
//
//		//database.setProperty("hibernate.hbm2ddl.auto", "create");
//		database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
//		database.setProperty("hibernate.connection.username", uname);
//		database.setProperty("hibernate.connection.password", pwd);
//		database.setProperty("hibernate.connection.url", url);
//		database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
//		Configuration cfg = new Configuration()
//				.setProperties(database)
//				.addPackage("models")
//				.addAnnotatedClass(Person.class)
//				.addAnnotatedClass(Appoinment.class)
//				.addAnnotatedClass(AppoinmentWeekDay.class)
//				.addAnnotatedClass(BuyService.class)
//				.addAnnotatedClass(Logins.class)
//				.addAnnotatedClass(Receipt.class)
//				.addAnnotatedClass(Service.class)
//				.addAnnotatedClass(ServiceType.class)
//				.addAnnotatedClass(UpLoadPayment.class)
//				.addAnnotatedClass(Room.class)
//				.addAnnotatedClass(Doctor.class)
//				.addAnnotatedClass(Expertise.class)
//				;
//
//
//		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(cfg.getProperties());
//		sessionFactory = cfg.buildSessionFactory(ssrb.build());
//		return sessionFactory;
//	}

}
