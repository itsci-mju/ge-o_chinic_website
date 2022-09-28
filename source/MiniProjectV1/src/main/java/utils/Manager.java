package utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import models.*;

public class Manager {
	public int AddorUpdatePerson(Person person) {
		int Resutl = 0;
		 try {
	            SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
	            Session session = sessionFactory.openSession();
	            Transaction t = session.beginTransaction();
	            session.saveOrUpdate(person);
	              
	            t.commit();
	            session.close();
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}
	
	public int AddorUpdateLogins(Logins logins) {
		int Resutl = 0;
		 try {
	            SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
	            Session session = sessionFactory.openSession();
	            Transaction t = session.beginTransaction();
	            session.saveOrUpdate(logins);
	              
	            t.commit();
	            session.close();
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}
	
	public Person getPerson(int Id) {
		Person Resutl = null;
		SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
        Session session = sessionFactory.openSession();
		 try {
	            Resutl = session.get(Person.class, Id);
	              
	                 
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = null;
	        }
		 	session.close(); 
	        return Resutl;
	}
	
	public Person getPerson(String Id) {
		Person Resutl = null;
		SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
        Session session = sessionFactory.openSession();
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
	
	public Logins getLogins(String Id) {
		Logins Resutl = null;
		 try {
	            SessionFactory sessionFactory = HibernateConnection.doHibernateConnection();
	            Session session = sessionFactory.openSession();
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
