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
public class DeleteStaffController {
	@Autowired
	private Manager m;
	
	@RequestMapping(value="/delete_staff", method=RequestMethod.GET)
	public ModelAndView doDeleteMenu(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/list/list_staff");
		String Id = request.getParameter("id");
		
		Person p = m.getPerson(Id);	
		int rusult = m.deleteStaff(p);
		
		List<Person> list_staff = m.getListStaff();
		mav.addObject("list_staff",list_staff);
		
		return mav;
	}
}
