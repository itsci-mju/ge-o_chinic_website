package org.itsci.controller.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.itsci.manager.AppionmentManager;
import org.itsci.manager.BuyServiceManager;
import org.itsci.manager.LoginManager;
import org.itsci.models.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AlertMessageController {
	
	@Autowired
	AppionmentManager am;
	@Autowired
	BuyServiceManager bm;
	@Autowired
	LoginManager lm;
	
	@RequestMapping(value="/alert_list_rigister_page", method=RequestMethod.GET)
	public ModelAndView LondAlertListRegisterService(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/appionment_member/view_appointment");
		String email = request.getParameter("email");
		int memberId = Integer.parseInt(lm.getLoginMemberId(email));
		
		String message = "กรุณารอการตรวจสอบจากพนักงาน";
        mav.addObject("message", message);
		
		List<BuyService> list_buyservice = bm.getlistBuyServiceMemberId(memberId);
		mav.addObject("ListBuyServices",list_buyservice);
		return mav;
	}
}
