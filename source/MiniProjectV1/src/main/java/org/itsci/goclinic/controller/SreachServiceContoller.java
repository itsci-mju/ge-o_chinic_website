package org.itsci.controller.spring;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.itsci.manager.SreachManager;
import org.itsci.models.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SreachServiceContoller {
	
	@Autowired
	private SreachManager sm;
	
	@RequestMapping(value="/SreachServices", method=RequestMethod.POST)
	public ModelAndView doSreachService(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("services_page");
		
		try {
		request.setCharacterEncoding("UTF-8");		
		String sreach = request.getParameter("search");		
		List<Services> list_services = sm.sreachServices(sreach);
		
		System.out.println(sreach);

		mav.addObject("ListServices",list_services);
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return mav;
	}
}
