package org.itsci.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.itsci.models.Logins;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class LoginManager {

//    @Autowired
//    HibernateConnection sessionFactory;
	@Autowired
	SessionFactory sessionFactory;

    public LoginManager() {
		// TODO Auto-generated constructor stub
	}

    @Transactional
	public Logins Login(Logins u) {
    	Logins user = null;

            Session session = sessionFactory.getCurrentSession();
            user = (Logins) session.createQuery("From Logins where email= '" + u.getEmail() + 
            		"' and password = '" + u.getPassword() + "'").uniqueResult();
            return user;
        }
}






//SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
//Session session = sessionFactory.openSession();
//Logins user = null;
//try {		
//    user = (Logins) session.createQuery("From Logins where email= '" + u.getEmail() + 
//    		"' and password = '" + u.getPassword() + "'").uniqueResult();
//    session.close();
//} catch (Exception e) {
//    e.printStackTrace();
//    session.close();
//}
// return user ;