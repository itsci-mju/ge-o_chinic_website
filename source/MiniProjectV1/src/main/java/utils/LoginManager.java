package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;


import models.Logins;

public class LoginManager {
	public LoginManager() {
		// TODO Auto-generated constructor stub
	}

	public Logins Login(Logins u) {
		Logins user = null;
		try {
            SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
            Session session = sessionFactory.openSession();
            Transaction t = session.beginTransaction();
            user = (Logins) session.createQuery("From Logins where email= '" + u.getEmail() + 
            		"' and password = '" + u.getPassword() + "'").uniqueResult();
            t.commit();
            session.close();
            return user ;
        } catch (Exception e) {
            e.printStackTrace();
            return user;
        }
		
	}
}
