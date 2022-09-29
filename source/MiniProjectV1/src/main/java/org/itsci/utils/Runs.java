package org.itsci.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.itsci.models.Logins;
import org.itsci.models.Person;


public class Runs {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
        Session session = sessionFactory.openSession();
        Transaction t = session.beginTransaction();
        System.out.println(session);
        
        Logins log = new Logins("gun@hotmail.com","1234");
		LoginManager m = new LoginManager();
		log = m.Login(log);
		
		Person p = log.getPersons();
	
		System.out.println(p.getFull_name());
        t.commit();
        session.close();
	}
}
