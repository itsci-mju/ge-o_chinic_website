package itsci.controller.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import utils.*;

@Controller
public class DeleteControllers {
	@RequestMapping(value="/Del", method=RequestMethod.GET)
	public String delapp(HttpServletRequest request,HttpSession session) {
		int id = Integer.parseInt(request.getParameter("id"));
		Manager mgr = new Manager();
		int result = mgr.deletemenu(id);
		
		session.setAttribute("alertDel", result);
		return "menu";
		
	}
}
