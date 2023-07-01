package org.itsci.manager;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.models.Appoinment;
import org.itsci.models.BuyService;
import org.itsci.models.Expertise;
import org.itsci.models.ServiceType;
import org.itsci.models.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BuyServiceManager {

	@Autowired
	SessionFactory sessionFactory;
	//***************************Add BuyServices***********************************	
	@Transactional
	public int addBuyService(BuyService buyservice) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.save(buyservice);
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}
	//***************************List BuyServices***********************************	
	@Transactional
	public List<BuyService> getlistBuyService() {
		List<BuyService> Resutl = null;
		Session session = sessionFactory.openSession();
		Resutl = (List<BuyService>) session.createQuery("From BuyService").list();
		
		return Resutl;
	}
	
	@Transactional
	public List<BuyService> getlistBuyServiceMemberId(int memberId) {
		List<BuyService> result = null;
	    Session session = sessionFactory.openSession();
	    Query query = session.createQuery("FROM BuyService WHERE person.id = :memberId AND order_qty = 1 AND appoinment.status = 0");
	    query.setParameter("memberId", memberId);
	    result = query.list();
	    
		return result;
	}
	
	@Transactional
	public List<BuyService> getlistCancelBuyServiceMemberId(int memberId) {
		List<BuyService> result = null;
	    Session session = sessionFactory.openSession();
	    Query query = session.createQuery("FROM BuyService WHERE person.id = :memberId AND order_qty = 1 AND appoinment.status = 1");
	    query.setParameter("memberId", memberId);
	    result = query.list();
	    
		return result;
	}
	
	@Transactional
	public List<BuyService> getlistBuyServiceSucceed(int memberId) {
		List<BuyService> result = null;
	    Session session = sessionFactory.openSession();
	    Query query = session.createQuery("FROM BuyService WHERE person.id = :memberId AND order_qty = 0");
	    query.setParameter("memberId", memberId);
	    result = query.list();
	    
		return result;
	}
	
	@Transactional
	public List<BuyService> getlistBuyServiceByStatus() {
		List<BuyService> Resutl = null;
		Session session = sessionFactory.openSession();
		Resutl = (List<BuyService>) session.createQuery("From BuyService WHERE status = 2 AND order_qty = 1 AND appoinment.appoinment_time IS NOT NULL" ).list();
		
		return Resutl;
	}
	
	@Transactional
	public List<BuyService> getlistBuyServiceBySucceed() {
		List<BuyService> Resutl = null;
		Session session = sessionFactory.openSession();
		Resutl = (List<BuyService>) session.createQuery("From BuyService WHERE status = 2 AND order_qty = 0").list();
		
		return Resutl;
	}
	
	@Transactional
	public List<BuyService> getlistBuyServiceByConfirm() {
		List<BuyService> Resutl = null;
		Session session = sessionFactory.openSession();
		Resutl = (List<BuyService>) session.createQuery("From BuyService WHERE status = 1 ").list();
		
		return Resutl;
	}
	
	//*************************Get BuyServices*************************************
		@Transactional
		public BuyService getBuyService(int buyservice) {
			BuyService Resutl = null;
			 try {
				 	Session session = sessionFactory.getCurrentSession();
		            Resutl = session.get(BuyService.class, buyservice);
	  
		        } catch (Exception e) {
		            e.printStackTrace();
		            Resutl = null;
		        }
		        return Resutl;
		}
		
		@Transactional
		public int getServicesId(int buyserviceId) {
		    int result = 0;
		    Session session = null;
		    try {
		        session = sessionFactory.openSession();
		        Query query = session.createSQLQuery("SELECT service_FK FROM BuyService b WHERE b.buyservice_id = :buyserviceId");
		        query.setParameter("buyserviceId", buyserviceId);
		        Object uniqueResult = query.uniqueResult();
		        if (uniqueResult != null) {
		            result = (int) uniqueResult;
		        }
		    } catch (Exception e) {
		        e.printStackTrace();
		        result = 0;
		    } finally {
		        if (session != null) {
		            session.close();
		        }
		    }
		    return result;
		}
	//***********************Update BuyService***********************
		
		@Transactional
		public int UpdateBuyService(BuyService buyservice) {
			int Resutl = 0;
			 try {
		            Session session = sessionFactory.openSession();
		            session.update(buyservice);
		            Resutl = 1;
		        } catch (Exception e) {
		            e.printStackTrace();
		            Resutl = 0;  
		        }
		        return Resutl;
		}
		
		
		@Transactional
		public int updateBuyServiceStatus(int buyServiceId) {
		    int result = 0;
		    try {
		        Session session = sessionFactory.getCurrentSession();
		        Query query = session.createSQLQuery("UPDATE BuyService SET status = 1 WHERE buyservice_id = :buyServiceId");
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
		public int updateConfirmStatus(int buyServiceId) {
		    int result = 0;
		    try {
		        Session session = sessionFactory.getCurrentSession();
		        Query query = session.createSQLQuery("UPDATE BuyService SET status = 2 WHERE buyservice_id = :buyServiceId");
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
		public int updateConfirmQty(int buyServiceId) {
		    int result = 0;
		    try {
		        Session session = sessionFactory.getCurrentSession();
		        Query query = session.createSQLQuery("UPDATE BuyService SET order_qty = 0 WHERE buyservice_id = :buyServiceId");
		        query.setParameter("buyServiceId", buyServiceId);
		        int updatedRows = query.executeUpdate();
		        result = (updatedRows > 0) ? 1 : 0;
		    } catch (Exception e) {
		        e.printStackTrace();
		        result = 0;
		    }
		    return result;
		}
}
