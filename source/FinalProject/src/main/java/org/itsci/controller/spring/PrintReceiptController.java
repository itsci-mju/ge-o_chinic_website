package org.itsci.controller.spring;

import javax.servlet.http.HttpServletRequest;

import org.itsci.manager.BuyServiceManager;
import org.itsci.manager.UpLoadPaymentManager;
import org.itsci.models.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrintReceiptController {
	@Autowired
	BuyServiceManager bm;
	@Autowired
	UpLoadPaymentManager um;
	
	@RequestMapping(value="/open_receipt_invoice_page", method=RequestMethod.GET)
	public ModelAndView LondPrintReceipt(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/print_receipt_page");
		int Id = Integer.parseInt(request.getParameter("id"));
		BuyService buyservice = bm.getBuyService(Id);
		
		mav.addObject("BuyServices",buyservice);
		return mav;
	}
}
