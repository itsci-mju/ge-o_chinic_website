package org.itsci.manager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.itsci.models.Appoinment;
import org.itsci.models.Logins;
import org.itsci.models.Receipt;
import org.itsci.models.UpLoadPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class UpLoadPaymentManager {
	@Autowired
	SessionFactory sessionFactory;
	//***************************Add UpLoadPayment***********************************	
	@Transactional
	public int addUpLoadPayment(UpLoadPayment uploadpayment) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.save(uploadpayment);
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}
	//***************************Add UpLoadPayment***********************************
	@Transactional
	public int addReceipt(Receipt receipt) {
		int Resutl = 0;
		 try {
	            Session session = sessionFactory.getCurrentSession();
	            session.save(receipt);
	            Resutl = 1;
	        } catch (Exception e) {
	            e.printStackTrace();
	            Resutl = 0;  
	        }
	        return Resutl;
	}
	//***************************Update UpLoadPayment***********************************	
		@Transactional
		public int UpdateUpLoadPayment(UpLoadPayment uploadpayment) {
			int Resutl = 0;
			 try {
		            Session session = sessionFactory.getCurrentSession();
		            session.update(uploadpayment);
		            Resutl = 1;
		        } catch (Exception e) {
		            e.printStackTrace();
		            Resutl = 0;  
		        }
		        return Resutl;
		}
		
		@Transactional
		public int updateImageByBuyServiceId(int buyServiceId, String imagePath) {
		    int result = 0;
		    try {
		        Session session = sessionFactory.getCurrentSession();
		        Query query = session.createSQLQuery("UPDATE uploadpayment "
		        		+ "JOIN BuyService ON uploadpayment.uploadPayment_id = BuyService.uploadpayment_FK "
		        		+ "SET uploadpayment.images = :imagePath "
		        		+ "WHERE BuyService.buyservice_id = :buyServiceId");
		        query.setParameter("imagePath", imagePath);
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
