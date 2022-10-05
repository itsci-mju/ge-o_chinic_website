package org.itsci.manager;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.models.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ServicesManager {
	@Autowired
	SessionFactory sessionFactory;
//***********************ServiceType***********************
	@Transactional
	public List<ServiceType> getlistServiceType() {
		List<ServiceType> Resutl = null;
		Session session = sessionFactory.openSession();
		Resutl = (List<ServiceType>) session.createQuery("From ServiceType").list();
		return Resutl;
	}
	
	@Transactional
	public List<ServiceType> getListServiceTypes() {
		List<ServiceType> Resutl = null;
        Session session = sessionFactory.getCurrentSession();
		 try {
			 //เรียกทั้งคลาส
	            Resutl = session.createQuery("From ServiceType").list();
	         //ใช้แก้ตัวเดียว
//	            Object[] o = (Object[]) session.createSQLQuery("Select Person_id From person where logins_FK = '"+ Id +"'").uniqueResult();
//	            	Resutl = new Person();
//	            	Resutl.setPerson_id(Integer.parseInt(o[0].toString()));
	                 
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = null;
	        }
	        return Resutl;
	}
	
	@Transactional
	public ServiceType getServiceType(int service_type) {
		ServiceType Resutl = null;
		 try {
			 	Session session = sessionFactory.getCurrentSession();
	            Resutl = session.get(ServiceType.class, service_type);
  
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = null;
	        }
	        return Resutl;
	}
//***********************Service***********************
	
	@Transactional
	public int UpdateService(Services service) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.openSession();
	            session.update(service);
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}
//**************************************************************	
	@Transactional
	public int addService(Services service) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.save(service);
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}
}
