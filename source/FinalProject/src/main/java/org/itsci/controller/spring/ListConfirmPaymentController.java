package org.itsci.controller.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.itsci.manager.BuyServiceManager;
import org.itsci.manager.UpLoadPaymentManager;
import org.itsci.models.BuyService;
import org.itsci.models.Receipt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListConfirmPaymentController {
	@Autowired
	BuyServiceManager bm;
	@Autowired
	UpLoadPaymentManager um;
	
	@RequestMapping(value="/open_List_confirm_payment_page", method=RequestMethod.GET)
	public ModelAndView LondConfirmPayment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("staff/list_appionments_staff/list_confirm_payment_page");
		List<BuyService> list_buyservice = bm.getlistBuyServiceByConfirm();
		
		mav.addObject("ListBuyServices",list_buyservice);
		return mav;
	}
	
	@RequestMapping(value="/open_confirm_payment_page", method=RequestMethod.GET)
	public ModelAndView doConfirmPayment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("staff/confirm_payment_page");
		int Id = Integer.parseInt(request.getParameter("id"));
		BuyService buyservice = bm.getBuyService(Id);
		
		mav.addObject("BuyServices",buyservice);
		return mav;
	}
	
	@RequestMapping(value="/confirm_payment_page", method=RequestMethod.GET)
	public ModelAndView ConfirmPayment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("staff/list_appionments_staff/list_confirm_payment_page");
		int Id = Integer.parseInt(request.getParameter("id"));
		BuyService buyservice = bm.getBuyService(Id);
		
		bm.updateConfirmStatus(Id);
		Receipt receipt = new Receipt(buyservice);
		um.addReceipt(receipt);
		
		List<BuyService> list_buyservice = bm.getlistBuyServiceByConfirm();
		mav.addObject("ListBuyServices",list_buyservice);
		mav.addObject("BuyServices",buyservice);
		return mav;
	}
}
