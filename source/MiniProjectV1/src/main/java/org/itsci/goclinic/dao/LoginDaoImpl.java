package org.itsci.goclinic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.goclinic.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LoginDaoImpl implements LoginDao {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public Login Login(Login u) {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Login l where l.email=:email");
        query.setParameter("email", u.getEmail());
        Login login = (Login) query.getSingleResult();
        if (login != null && login.getPassword().equals(u.getPassword())) {
            return login;
        }
        return null;
    }
}
