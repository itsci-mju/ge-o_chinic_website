package org.itsci.controller.spring;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itsci.manager.AppionmentManager;
import org.itsci.manager.BuyServiceManager;
import org.itsci.manager.ServicesManager;
import org.itsci.manager.UpLoadPaymentManager;
import org.itsci.models.Appoinment;
import org.itsci.models.BuyService;
import org.itsci.models.Expertise;
import org.itsci.models.Person;
import org.itsci.models.ServiceType;
import org.itsci.models.Services;
import org.itsci.models.UpLoadPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.Session;
@Controller
public class RegisterServiecController {
	@Autowired
	private ServicesManager sm;
	@Autowired
	private BuyServiceManager bm;
	@Autowired
	private UpLoadPaymentManager um;
	@Autowired
	private AppionmentManager am;
	
	@RequestMapping(value="/open_register_service_page", method=RequestMethod.GET)
	public ModelAndView LoadRegisterServices(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/service/service_detail");
		int Id = Integer.parseInt(request.getParameter("id"));
		
		Services s = sm.getServices(Id);
		List<ServiceType> st = sm.getlistServiceType();
		List<Expertise> et = sm.getListExpertise();
		
		mav.addObject("services",s);
		mav.addObject("servicetype",st);
		mav.addObject("expertise",et);
		return mav;
	}
	
	@RequestMapping(value="/register_service_page", method=RequestMethod.GET)
	public ModelAndView RegisterServices(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/appionment_member/view_appointment");
		HttpSession session = request.getSession();
		int Id = Integer.parseInt(request.getParameter("id"));
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date strDate = new Date();
		
		
		Person member_id = (Person) session.getAttribute("memberp");
		
		Appoinment appion = new Appoinment();
		am.addAppoinment(appion);
		
		
		UpLoadPayment upload_img = new UpLoadPayment();
		um.addUpLoadPayment(upload_img);
		
		Services services_id = sm.getServices(Id);
		
		BuyService buy_service = new BuyService(strDate,0,1,member_id,appion,services_id,upload_img);
		bm.addBuyService(buy_service);
		
		buy_service = bm.getBuyService(Id);
		mav.addObject("BuyServices",buy_service);
		return mav;
	}
	
	
}