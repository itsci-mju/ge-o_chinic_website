package org.itsci.controller.spring;

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
	@RequestMapping(value="/open_Login_page", method=RequestMethod.GET)
	public ModelAndView Lond(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("Login_page");

		return mav;
	}
	
	@RequestMapping(value="/open_home_customer_page", method=RequestMethod.GET)
	public ModelAndView LondHomeCustomers(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("index");

		return mav;
	}

	//**************Member page**************
	@RequestMapping(value="/open_home_member_page", method=RequestMethod.GET)
	public ModelAndView LondHomeMembers(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("member/home_member");

		return mav;
	}
	
	@RequestMapping(value="/open_test_member_page", method=RequestMethod.GET)
	public ModelAndView LondTestMembers(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("member/test1");

		return mav;
	}
	//**************Staff page**************
	@RequestMapping(value="/open_home_staff_page", method=RequestMethod.GET)
	public ModelAndView LondHomeStaff(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("staff/home_staff");

		return mav;
	}
	//**************Admin page**************
	@RequestMapping(value="/open_home_admin_page", method=RequestMethod.GET)
	public ModelAndView LondHomeAdmin(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("admin/home_admin");

		return mav;
	}
}
