package org.itsci.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import org.itsci.models.Logins;
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
}