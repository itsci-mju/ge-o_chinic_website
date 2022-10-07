package org.itsci.goclinic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class Page_Link {

	public Page_Link() {
		super();
		// TODO Auto-generated constructor stub
	}
	//**************Customer page**************
	@RequestMapping(value="/open_home_customer_page", method=RequestMethod.GET)
	public ModelAndView LondHomeCustomers(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("index");

		return mav;
	}
	
	@RequestMapping(value="/open_about_c_page", method=RequestMethod.GET)
	public ModelAndView LondAbout(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("about_customer");

		return mav;
	}
	
	@RequestMapping(value="/open_contact_page", method=RequestMethod.GET)
	public ModelAndView LondContact(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("contact");

		return mav;
	}
	
	@RequestMapping(value="/open_services_c_page", method=RequestMethod.GET)
	public ModelAndView Londservices_c(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("service_customer");

		return mav;
	}

	//**************Member page**************
	@RequestMapping(value="/open_home_member_page", method=RequestMethod.GET)
	public ModelAndView LondHomeMembers(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("member/home_member");

		return mav;
	}
	
	@RequestMapping(value="/open_about_m_page", method=RequestMethod.GET)
	public ModelAndView LondAboutm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("member/about_member");

		return mav;
	}
	
	@RequestMapping(value="/open_contact_m_page", method=RequestMethod.GET)
	public ModelAndView LondContactm(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("member/contact_member");

		return mav;
	}
	
}
