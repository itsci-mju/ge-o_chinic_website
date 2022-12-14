package org.itsci.controller.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.itsci.manager.Manager;
import org.itsci.manager.ServicesManager;
import org.itsci.models.Person;
import org.itsci.models.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListServiceController {

	@Autowired
	private ServicesManager sm;
	
	@RequestMapping(value="/open_list_service_page", method=RequestMethod.GET)
	public ModelAndView LoadListServices(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/list/list_service");
		
		List<Services> list_services = sm.getListService();
		mav.addObject("ListServices",list_services);
		
		return mav;
	}
	
	@RequestMapping(value="/open_services_c_page", method=RequestMethod.GET)
	public ModelAndView LoadListService(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("services_page");
		
		List<Services> list_services = sm.getListService();
		mav.addObject("ListServices",list_services);
		
		return mav;
	}
}
