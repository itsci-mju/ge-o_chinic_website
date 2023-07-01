package org.itsci.controller.spring;

import java.io.File;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.itsci.manager.BuyServiceManager;
import org.itsci.manager.LoginManager;
import org.itsci.manager.UpLoadPaymentManager;
import org.itsci.models.BuyService;
import org.itsci.models.Receipt;
import org.itsci.models.UpLoadPayment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class PrintInvoiceController {
	
	@Autowired
	BuyServiceManager bm;
	@Autowired
	UpLoadPaymentManager um;
	@Autowired
	LoginManager lm;
	
	@RequestMapping(value="/open_print_invoice_page", method=RequestMethod.GET)
	public ModelAndView LondPrintInvoice(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/print_invoice_page");
		int Id = Integer.parseInt(request.getParameter("id"));
		BuyService buyservice = bm.getBuyService(Id);
		
		mav.addObject("BuyServices",buyservice);
		return mav;
	}
	
	@RequestMapping(value="/print_invoice_page", method=RequestMethod.POST)
	public ModelAndView doPrintInvoice(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/appionment_member/view_appointment");
	try {
		String member_Id = request.getParameter("member_id");
		int memberId = Integer.parseInt(lm.getLoginMemberId(member_Id));
		List<BuyService> list_buyservice = bm.getlistBuyServiceMemberId(memberId);
		
		List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);

		int Id = Integer.parseInt(data.get(0).getString());
		String imagePath = new File(data.get(1).getName()).getName();
		String path = request.getSession().getServletContext().getRealPath("/") + "WEB-INF\\assets\\images\\";
		data.get(1).write(new File(path + File.separator + imagePath));
		
		BuyService buyservice = bm.getBuyService(Id);
		System.out.println(buyservice);
		
		bm.updateBuyServiceStatus(Id);
		um.updateImageByBuyServiceId(Id, imagePath);
		
		System.out.println(buyservice.getStatus());
		mav.addObject("ListBuyServices",list_buyservice);
		mav.addObject("BuyServices",buyservice);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return mav;
	}
}
