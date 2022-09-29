package org.itsci.controller.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itsci.utils.LoginManager;
import org.itsci.models.Logins;
import org.itsci.models.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

	public LoginController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping(value="/login" , method=RequestMethod.POST)
	public ModelAndView loginPage(HttpServletRequest request ) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("Logins");
		
		String email = request.getParameter("email");
		String pass = request.getParameter("pwd");
		
		Logins log = new Logins(email,pass);
		LoginManager m = new LoginManager();
		log = m.Login(log);
		
		if(log != null ) {
			Person p =log.getPersons();
			if(log.getType().equals("a") ) {
				session.setAttribute("admin", log);
				session.setAttribute("adminp", p);
				session.setMaxInactiveInterval(2*60*60);
				mav = new ModelAndView("admin/home_admin");
				return mav;
			}else if(log.getType().equals("s")){
				session.setAttribute("staff", log);
				session.setAttribute("staffp", p);
				session.setMaxInactiveInterval(2*60*60);
				mav = new ModelAndView("staff/home_staff");
				return mav;
			}else if(log.getType().equals("m")){
				session.setAttribute("member", log);
				session.setAttribute("memberp", p);
				session.setMaxInactiveInterval(2*60*60);
				mav = new ModelAndView("member/home_member");
				return mav;
			}
		}else {
			mav.addObject("message" , "User name หรือ Password ไม่ถูกต้องกรุณาลองใหม่อีกครั้ง");
			
		}
		return mav;
		
	}
	
	@RequestMapping(value="/logout" , method=RequestMethod.GET)
	public ModelAndView logoutPage(HttpServletRequest request ) {
		HttpSession session = request.getSession(false);
		ModelAndView mav = new ModelAndView("index");
		session.removeAttribute("log");
		
		return mav;
		
	}
	
	

}
