package org.itsci.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class SreachManager {
	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public List<Services>  sreachServices(String Keyworld){
		List<Services> Resutl = null;
		 Session session = sessionFactory.getCurrentSession();
        try {
            Resutl = session.createQuery("From Services where serviceName like '%"+Keyworld+"%' or service_id like '%"+Keyworld+"%'").list();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Resutl;
    }
}
