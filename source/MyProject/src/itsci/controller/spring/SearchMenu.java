package itsci.controller.spring;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import model.Menu;
import utils.Manager;

@Controller
public class SearchMenu {
	@RequestMapping(value="/openSearchMenu", method=RequestMethod.POST)
	public String LoadAddMenu(HttpServletRequest request,Model md,HttpSession session) {
		try {
			request.setCharacterEncoding("UTF-8");
        String menuname = request.getParameter("st");
        Manager m = new Manager();
        List<Menu> list = m.searchMenu(menuname);
        request.setAttribute("result", list);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "menu";
	}
}
