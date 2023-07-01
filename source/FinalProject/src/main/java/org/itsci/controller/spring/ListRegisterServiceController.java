package org.itsci.controller.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itsci.manager.AppionmentManager;
import org.itsci.manager.BuyServiceManager;
import org.itsci.manager.LoginManager;
import org.itsci.models.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListRegisterServiceController {
	@Autowired
	AppionmentManager am;
	@Autowired
	BuyServiceManager bm;
	@Autowired
	LoginManager lm;
	
	@RequestMapping(value="/open_list_rigister_service_page", method=RequestMethod.GET)
	public ModelAndView LondListRegisterService(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/appionment_member/view_appointment");
		String Id = request.getParameter("id");
		int memberId = Integer.parseInt(lm.getLoginMemberId(Id));
		
		List<BuyService> list_buyservice = bm.getlistBuyServiceMemberId(memberId);
		mav.addObject("ListBuyServices",list_buyservice);
		return mav;
	}
	
	@RequestMapping(value="/open_succeed_appionment_page", method=RequestMethod.GET)
	public ModelAndView LondSucceedAppointment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/appionment_member/succeed_appiontment");
		String Id = request.getParameter("id");
		int memberId = Integer.parseInt(lm.getLoginMemberId(Id));
		List<BuyService> list_buyservice = bm.getlistBuyServiceSucceed(memberId);
		
		mav.addObject("ListBuyServices",list_buyservice);
		return mav;
	}
	
	
	
}
