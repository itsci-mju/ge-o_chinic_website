package org.itsci.manager;

import java.util.List;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.itsci.models.Logins;
import org.itsci.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
public class Manager {

	@Autowired
	SessionFactory sessionFactory;

	@Transactional
	public int AddPerson(Person person) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.save(person);
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}
	
	@Transactional
	public int UpdatePerson(Person person) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.update(person);
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}
	
	@Transactional
	public int AddService(Service service) {
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
	
	@Transactional
	public int UpdateService(Service service) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.update(service);
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
	        return Resutl;
	}

	@Transactional
	public Person getPerson(String Id) {
		Person Resutl = null;
        Session session = sessionFactory.getCurrentSession();
		 try {
			 //???????????????????????????????????????
	            Resutl = (Person) session.createQuery("From Person where logins.email = '"+ Id +"'").uniqueResult();
	         //??????????????????????????????????????????
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
	public Logins getLogins(String Id) {
		Logins Resutl = null;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            Resutl = session.get(Logins.class, Id);

	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = null;
	        }
	        return Resutl;
	}
	
	//**************get list**********************
	@Transactional
	public List<Person> getListStaff() {
		List<Person> Resutl = null;
        Session session = sessionFactory.getCurrentSession();
		 try {
			 //???????????????????????????????????????
	            Resutl = session.createQuery("From Person where logins.type = '"+"s"+"'").list();
	         //??????????????????????????????????????????
//	            Object[] o = (Object[]) session.createSQLQuery("Select Person_id From person where logins_FK = '"+ Id +"'").uniqueResult();
//	            	Resutl = new Person();
//	            	Resutl.setPerson_id(Integer.parseInt(o[0].toString()));
	                 
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = null;
	        }
	        return Resutl;
	}
	//**************delete staff**********************
	@Transactional
	public int deleteStaff(Person person) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.delete(person);
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}
}
