package org.itsci.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import org.itsci.models.Logins;
import org.itsci.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

public class Manager {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public int AddorUpdatePerson(Person person) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.saveOrUpdate(person);
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}

	@Transactional
	public int AddorUpdateLogins(Logins logins) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.saveOrUpdate(logins);
	            session.close();
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}

	@Transactional
	public Person getPerson(int Id) {
		Person Resutl = null;
        Session session = sessionFactory.getCurrentSession();
		 try {
	            Resutl = session.get(Person.class, Id);
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = null;
	        }
		 	session.close(); 
	        return Resutl;
	}

	@Transactional
	public Person getPerson(String Id) {
		Person Resutl = null;
        Session session = sessionFactory.getCurrentSession();
		 try {
			 //เรียกทั้งคลาส
	            Resutl = (Person) session.createQuery("From Person where logins.email = '"+ Id +"'").uniqueResult();
	         //ใช้แก้ตัวเดียว
//	            Object[] o = (Object[]) session.createSQLQuery("Select Person_id From person where logins_FK = '"+ Id +"'").uniqueResult();
//	            	Resutl = new Person();
//	            	Resutl.setPerson_id(Integer.parseInt(o[0].toString()));
	                 
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = null;
	        }
		 	session.close(); 
	        return Resutl;
	}

	@Transactional
	public Logins getLogins(String Id) {
		Logins Resutl = null;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            Transaction t = session.beginTransaction();
	            Resutl = session.get(Logins.class, Id);
	              
	            t.commit();
	            session.close();      
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = null;
	        }
	        return Resutl;
	}
}
