package org.itsci.goclinic.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.goclinic.model.Login;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public class LoginDaoImpl implements LoginDao, UserDetailsService {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    @Transactional
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Session session = sessionFactory.getCurrentSession();
        Query query = session.createQuery("from Login l where l.email=:email");
        query.setParameter("email", email);
        Login login = (Login) query.getSingleResult();
        return login.getPerson();
    }
}
