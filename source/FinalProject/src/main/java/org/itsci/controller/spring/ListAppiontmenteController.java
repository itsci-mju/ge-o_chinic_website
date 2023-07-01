package org.itsci.controller.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.itsci.manager.BuyServiceManager;
import org.itsci.manager.LoginManager;
import org.itsci.models.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListAppiontmenteController {
	@Autowired
	BuyServiceManager bm;
	@Autowired
	LoginManager lm;
	
	@RequestMapping(value="/open_list_appionment_page", method=RequestMethod.GET)
	public ModelAndView LondCancelAppointment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("staff/list_appionments_staff/list_appionment_page");
		List<BuyService> list_buyservice = bm.getlistBuyServiceByStatus();
		
		mav.addObject("ListBuyServices",list_buyservice);
		return mav;
	}
	
	@RequestMapping(value="/succeed_appionment_page", method=RequestMethod.GET)
	public ModelAndView SucceedAppointment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("staff/list_appionments_staff/list_succeed_appiontment");
		int Id = Integer.parseInt(request.getParameter("id"));
		
		bm.updateConfirmQty(Id);
		
		List<BuyService> list_buyservice = bm.getlistBuyServiceBySucceed();
		mav.addObject("ListBuyServices",list_buyservice);
		return mav;
	}
	
	@RequestMapping(value="/open_succeed_appionment", method=RequestMethod.GET)
	public ModelAndView LoadSucceedAppointment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("staff/list_appionments_staff/list_succeed_appiontment");
		List<BuyService> list_buyservice = bm.getlistBuyServiceBySucceed();
		mav.addObject("ListBuyServices",list_buyservice);
		return mav;
	}
	
	
	

}
