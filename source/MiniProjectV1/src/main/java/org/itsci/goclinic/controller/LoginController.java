package org.itsci.goclinic.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itsci.goclinic.dao.LoginDao;
import org.itsci.goclinic.model.Login;
import org.itsci.goclinic.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class LoginController {

	@Autowired
	private LoginDao loginDao;

	@RequestMapping(value="/open_Login_page", method=RequestMethod.GET)
	public String loginForm(Model model) {
		model.addAttribute("login", new Login());
		return "Login_page";
	}

//	@RequestMapping(value="/login" , method=RequestMethod.POST)
//	public String loginPage(
//			@ModelAttribute("login") Login log,
//			HttpSession session,
//			Model model) {
//		String mav = "Login_page";
//		log = loginDao.Login(log);
//
//		if(log != null ) {
//			Person p =log.getPersons();
//			if(log.getType().equals("a") ) {
//				session.setAttribute("admin", log);
//				session.setAttribute("adminp", p);
//				session.setMaxInactiveInterval(2*60*60);
//				mav = "admin/home_admin";
//				model.addAttribute("name","admin");
//				return mav;
//			}else if(log.getType().equals("s")){
//				session.setAttribute("staff", log);
//				session.setAttribute("staffp", p);
//				session.setMaxInactiveInterval(2*60*60);
//				mav = "staff/home_staff";
//				model.addAttribute("fullname", p.getFull_name());
//				return mav;
//			}else if(log.getType().equals("m")){
//				session.setAttribute("member", log);
//				session.setAttribute("memberp", p);
//				session.setMaxInactiveInterval(2*60*60);
//				mav = "member/home_member";
//				model.addAttribute("emails", p.getLogins().getEmail());
//				model.addAttribute("fullname", p.getFull_name());
//				return mav;
//			}
//		}else {
//			model.addAttribute("message" , "User name หรือ Password ไม่ถูกต้องกรุณาลองใหม่อีกครั้ง");
//		}
//		return mav;
//	}
	
//	@RequestMapping(value="/logout" , method=RequestMethod.GET)
//	public String logoutPage(HttpServletRequest request ) {
//		HttpSession session = request.getSession(false);
//		session.removeAttribute("log");
//		return "index";
//	}
}
