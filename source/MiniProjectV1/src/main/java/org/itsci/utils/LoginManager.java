package org.itsci.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.itsci.models.Logins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class LoginManager {

    @Autowired
    SessionFactory sessionFactory;

    public LoginManager() {
		// TODO Auto-generated constructor stub
	}

    @Transactional
	public Logins Login(Logins u) {
		Logins user = null;
		try {
            Session session = sessionFactory.getCurrentSession();
            user = (Logins) session.createQuery("From Logins where email= '" + u.getEmail() + 
            		"' and password = '" + u.getPassword() + "'").uniqueResult();
            return user ;
        } catch (Exception e) {
            e.printStackTrace();
            return user;
        }
		
	}
}
