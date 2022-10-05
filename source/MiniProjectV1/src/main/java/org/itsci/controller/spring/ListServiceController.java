package org.itsci.controller.spring;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.itsci.manager.Manager;
import org.itsci.models.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ListServiceController {

	@Autowired
	private Manager m;
	
	@RequestMapping(value="/open_list_service_page", method=RequestMethod.GET)
	public ModelAndView LoadListStaff(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/list/list_service");
		
		List<Person> list_staff = m.getListStaff();
		mav.addObject("list_staff",list_staff);
		
		return mav;
	}
}
