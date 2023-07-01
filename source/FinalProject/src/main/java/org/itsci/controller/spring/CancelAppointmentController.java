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
public class CancelAppointmentController {
	@Autowired
	BuyServiceManager bm;
	@Autowired
	LoginManager lm;
	@Autowired
	AppionmentManager am;
	
	@RequestMapping(value="/open_cancel_appointment_page", method=RequestMethod.GET)
	public ModelAndView LondCancelAppointment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/appionment_member/cancel_appointment_page");
		int Id = Integer.parseInt(request.getParameter("id"));
		BuyService buyservice = bm.getBuyService(Id);
		
		if (buyservice != null) {
	    	String email = request.getParameter("email");
			int memberId = Integer.parseInt(lm.getLoginMemberId(email));
			List<BuyService> list_buyservice = bm.getlistBuyServiceMemberId(memberId);
			String check_dates = am.getBuyServicesDates(Id);
			
	        mav = new ModelAndView("member/appionment_member/view_appointment");
	        mav.addObject("BuyServices", buyservice);

	        if (buyservice.getStatus() == 0 || buyservice.getStatus() == 1) {
	            String message = "กรุณาชำระเงิน หรือรอการตรวจสอบ";
	            mav.addObject("ListBuyServices", list_buyservice);
	            mav.addObject("message", message);
	            mav.setViewName("member/appionment_member/view_appointment");
	        } else if(buyservice.getStatus() == 2 && check_dates == null){
	        	String message = "คุณยังไม่ได้ได้ทำการจองเวลา";
	            mav.addObject("ListBuyServices", list_buyservice);
	            mav.addObject("message", message);
	            mav.setViewName("member/appionment_member/view_appointment");
	        }else if(buyservice.getStatus() == 2 && check_dates != null){
	            mav.addObject("ListBuyServices", list_buyservice);
	            mav.setViewName("member/appionment_member/cancel_appointment_page");
	        }
	    } else {
	        mav = new ModelAndView("error_page");
	    }
	        
		
		mav.addObject("BuyServices",buyservice);
		return mav;
	}
	
	@RequestMapping(value="/cancel_appointment_page", method=RequestMethod.POST)
	public ModelAndView doCancelAppointment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/appionment_member/view_appointment");
		int id = Integer.parseInt(request.getParameter("id"));
		String note = request.getParameter("note");
		
		String Id = request.getParameter("member_id");
		int memberId = Integer.parseInt(lm.getLoginMemberId(Id));
		List<BuyService> list_buyservice = bm.getlistBuyServiceMemberId(memberId);
		
		am.updateCancelAppointmentStatusMember(id,note);
		
		mav.addObject("ListBuyServices",list_buyservice);
		return mav;
	}
	
	@RequestMapping(value="/cancel_appointment_staff_page", method=RequestMethod.GET)
	public ModelAndView doCancelAppointmentStaff(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/appionment_member/view_appointment");
		int id = Integer.parseInt(request.getParameter("id"));
		List<BuyService> list_buyservice = bm.getlistBuyServiceByStatus();
		
		am.updateCancelAppointmentStatusStaff(id);

		mav.addObject("ListBuyServices",list_buyservice);
		return mav;
	}
}
