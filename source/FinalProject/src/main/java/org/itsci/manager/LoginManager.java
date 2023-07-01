package org.itsci.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.models.Logins;
import org.itsci.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LoginManager {

    @Autowired
    SessionFactory sessionFactory;

    @Transactional
    public Logins Login(Logins u) {
        Session session = sessionFactory.getCurrentSession();
        Logins user = (Logins) session.createQuery("From Logins where email= '" + u.getEmail() +
                "' and password = '" + u.getPassword() + "'").uniqueResult();
        return user;
    }
    
  //***************************Get Id***********************************	
    @Transactional
    public Person LoginMemberId(Person u) {
        Session session = sessionFactory.getCurrentSession();
        Person user = (Person) session.createSQLQuery("Select person_id From Person where logins_FK = :u ");
        return user;
    }
    
    @Transactional
	public String getLoginMemberId(String email) {
	    String result = null;
	    Session session = null;
	    try {
	        session = sessionFactory.openSession();
	        Query query = session.createSQLQuery("SELECT person_id From person WHERE logins_FK = :email");
	        query.setParameter("email", email);
	        Object uniqueResult = query.uniqueResult();
	        if (uniqueResult != null) {
	            result = uniqueResult.toString();
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        result = null;
	    } finally {
	        if (session != null) {
	            session.close();
	        }
	    }
	    return result;
	}
}