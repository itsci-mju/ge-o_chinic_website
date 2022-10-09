package org.itsci.controller.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.itsci.manager.ServicesManager;
import org.itsci.models.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DeleteServiceController {
	
	@Autowired
	private ServicesManager sm;
	
	@RequestMapping(value="/delete_service", method=RequestMethod.GET)
	public ModelAndView doDeleteMenu(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/list/list_service");
		int Id = Integer.parseInt(request.getParameter("id"));
		
		Services s = sm.getServices(Id);	
		int rusult = sm.deleteService(s);
		
		List<Services> list_service = sm.getListService();
		mav.addObject("list_service",list_service);
		
		if(rusult == 1){
			mav.addObject("message","Delete Sucess");
		}else {
			mav.addObject("message","Delete Not Sucess !!!");
		}
		
		return mav;
	}
}
