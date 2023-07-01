package org.itsci.manager;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.models.Appoinment;
import org.itsci.models.BuyService;
import org.itsci.models.ServiceType;
import org.itsci.models.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class AppionmentManager {
	
	@Autowired
	SessionFactory sessionFactory;
	//***************************Add Appionments***********************************	
	@Transactional
	public int addAppoinment(Appoinment appoinment) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.save(appoinment);
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}
	//*****************************Get Appionment*************************************
	@Transactional
	public List<String> getAppointmentTimes(String date) {
	    List<String> result = null;
	    try {
	        Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT DATE_FORMAT(a.appoinment_time, '%H:%i') FROM appoinment a "
	                + "JOIN buyservice b "
	                + "ON a.appoinment_id = b.appoinment_FK "
	                + "WHERE DATE_FORMAT(a.appoinment_time, '%Y-%m-%d') = :date ");
	        query.setParameter("date", date);
	        List<Object> resultList = query.getResultList();
	        if (resultList != null && !resultList.isEmpty()) {
	            result = new ArrayList<>();
	            for (Object obj : resultList) {
	                result.add(obj.toString());
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        result = null;
	    }
	    return result;
	}
	
	@Transactional
	public List<String> getAppointmentTime(String date, int serviceId) {
	    List<String> result = null;
	    try {
	        Query query = sessionFactory.getCurrentSession().createSQLQuery("SELECT DATE_FORMAT(a.appoinment_time, '%H:%i') FROM appoinment a "
	                + "JOIN buyservice b "
	                + "ON a.appoinment_id = b.appoinment_FK "
	                + "WHERE b.service_FK = :serviceId "
	                + "AND DATE_FORMAT(a.appoinment_time, '%Y-%m-%d') = :date");
	        query.setParameter("serviceId", serviceId);
	        query.setParameter("date", date);
	        List<Object> resultList = query.getResultList();
	        if (resultList != null && !resultList.isEmpty()) {
	            result = new ArrayList<>();
	            for (Object obj : resultList) {
	                result.add(obj.toString());
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        result = null;
	    }
	    return result;
	}

	
	@Transactional
	public String getBuyServicesDates(int buyserviceId) {
	    String result = null;
	    Session session = null;
	    try {
	        session = sessionFactory.openSession();
	        Query query = session.createSQLQuery("SELECT DATE_FORMAT(a.appoinment_time, '%Y-%m-%d') From appoinment a JOIN buyservice b ON a.appoinment_id = b.appoinment_FK WHERE b.buyservice_id = :buyserviceId");
	        query.setParameter("buyserviceId", buyserviceId);
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
	
	@Transactional
	public String getBuyServicesTimss(int buyserviceId) {
	    String result = null;
	    Session session = null;
	    try {
	        session = sessionFactory.openSession();
	        Query query = session.createSQLQuery("SELECT DATE_FORMAT(a.appoinment_time, '%H:%i') From appoinment a JOIN buyservice b ON a.appoinment_id = b.appoinment_FK WHERE b.buyservice_id = :buyserviceId");
	        query.setParameter("buyserviceId", buyserviceId);
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
	//***************************Update Appionments***********************************	
		
		@Transactional
		public int updateAppointmentTime(int buyServiceId, String date) {
		    int result = 0;
		    try {
		        Session session = sessionFactory.getCurrentSession();
		        Query query = session.createSQLQuery("UPDATE appointment "
		                + "JOIN buyservice ON appointment.appoinment_id = buyservice.appoinment_FK "
		                + "SET appointment.appoinment_time = CONCAT(:date, ' ', buyservice.select_time) "
		                + "WHERE buyservice.buyservice_id = :buyServiceId");
		        query.setParameter("date", date);
		        query.setParameter("buyServiceId", buyServiceId);
		        int updatedRows = query.executeUpdate();
		        result = (updatedRows > 0) ? 1 : 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		        result = 0;
		    }
		    return result;
		}
		
		@Transactional
		public int updateCancelAppointmentStatusMember(int buyServiceId, String note) {
		    int result = 0;
		    try {
		        Session session = sessionFactory.getCurrentSession();
		        Query query = session.createSQLQuery("UPDATE appoinment "
		                + "JOIN buyservice ON appoinment.appoinment_id = buyservice.appoinment_FK "
		                + "SET appoinment.status = 0, appoinment.appoinment_time = null, appoinment.note = :note "
		                + "WHERE buyservice.buyservice_id = :buyServiceId");
		        query.setParameter("buyServiceId", buyServiceId);
		        query.setParameter("note", note);
		        int updatedRows = query.executeUpdate();
		        result = (updatedRows > 0) ? 1 : 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		        result = 0;
		    }
		    return result;
		}
		
		@Transactional
		public int updateCancelAppointmentStatusStaff(int buyServiceId) {
		    int result = 0;
		    try {
		        Session session = sessionFactory.getCurrentSession();
		        Query query = session.createSQLQuery("UPDATE appoinment "
		                + "JOIN buyservice ON appoinment.appoinment_id = buyservice.appoinment_FK "
		                + "SET appoinment.status = 0, appoinment.appoinment_time = null, appoinment.note = null "
		                + "WHERE buyservice.buyservice_id = :buyServiceId");
		        query.setParameter("buyServiceId", buyServiceId);
		        int updatedRows = query.executeUpdate();
		        result = (updatedRows > 0) ? 1 : 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		        result = 0;
		    }
		    return result;
		}
		
		
		@Transactional
		public int updateAppointmente(int buyServiceId, Date date) {
		    int result = 0;
		    try {
		        Session session = sessionFactory.getCurrentSession();
		        Query query = session.createSQLQuery("UPDATE appoinment a "
		                + "JOIN buyservice b ON a.appoinment_id = b.appoinment_FK "
		                + "SET a.appoinment_time = :date "
		                + "WHERE b.buyservice_id = :buyServiceId");
		        query.setParameter("date", date);
		        query.setParameter("buyServiceId", buyServiceId);
		        int updatedRows = query.executeUpdate();
		        result = (updatedRows > 0) ? 1 : 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		        result = 0;
		    }
		    return result;
		}
	//***************************Update Appionments***********************************		
		@Transactional
		public ServiceType getAppoinment(int appoinment) {
			ServiceType Resutl = null;
			 try {
				 	Session session = sessionFactory.getCurrentSession();
		            Resutl = session.get(ServiceType.class, appoinment);
	  
		        } catch (Exception e) {
		            e.printStackTrace();
		            Resutl = null;
		        }
		        return Resutl;
		}

}
