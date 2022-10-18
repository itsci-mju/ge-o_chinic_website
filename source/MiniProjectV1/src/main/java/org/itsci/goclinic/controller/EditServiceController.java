package org.itsci.goclinic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itsci.goclinic.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class EditServiceController {
	
	@Autowired
	private Manager m;
	
	@RequestMapping(value="/open_edit_service_page", method=RequestMethod.GET)
	public ModelAndView LondEditServices(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("admin/service/edit_service");
		
		return mav;
	}

}
