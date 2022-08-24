package itsci.controller.spring;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import model.*;
import utils.Manager;

@Controller
public class controllers {
	@RequestMapping(value="/openlogin", method=RequestMethod.GET)
	public String LoadLogin() {
		return "Login";
	}
	@RequestMapping(value="/openAddMenu", method=RequestMethod.GET)
	public String LoadAddMenu() {
		return "AddMenu";
	}
	
	@RequestMapping(value="/openEditMenus", method=RequestMethod.GET)
	public ModelAndView LoadEditMenu(HttpServletRequest request,Model md,HttpSession session) {
		ModelAndView ma = new ModelAndView("EditMenu");
		
		int menuid = Integer.parseInt(request.getParameter("id"));
		
		Manager m = new Manager();
		Menu mn = m.getmenuid(menuid);

		ma.addObject("Menu", mn);

		return ma;
	}
	
	@RequestMapping(value="/openHome", method=RequestMethod.GET)
	public String LoadHome() {
		return "index";
	}
	
	@RequestMapping(value="/openMenus", method=RequestMethod.GET)
	public String LoadMenus() {
		return "menu";
	}
	
	@RequestMapping(value="/openProfile", method=RequestMethod.GET)
	public String LoadProfile(HttpSession session,Model md,HttpServletRequest request,@RequestParam String id) {
		try {
		
		request.setCharacterEncoding("UTF-8");
		Logins log = (Logins)session.getAttribute("username");
		Manager m = new Manager();
		
		request.setAttribute("list_log", log);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "Profile";
	}
	
	@RequestMapping(value="/loginss", method=RequestMethod.POST)
	public String doLogin(HttpServletRequest request,Model md,HttpSession session) {
		try { 
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("username");
		String pass = request.getParameter("pass");

		 Logins login = new Logins(name,pass,"","",""); 
		 Manager lmg = new Manager();
		 String message = lmg.do_login_process(login); 
		 if (message.equals("login success")) { 
			 
			 
			 md.addAttribute("emp_username",login.getName());
			 md.addAttribute("emp_pass",login.getPass());

			 
			 md.addAttribute("username", login.getName());
			 session.setAttribute("username", login);
			 
			 
			 return "mian"; 
		 }else{ 
			 md.addAttribute("error_msg", message); 
		 } 
		 	 return "Login"; 
		 }catch(Exception ex) { 
			 return "Login"; 
		 }
	}
	
	
	
	@RequestMapping(value="/openRegister", method=RequestMethod.GET)
	public String OpenRegisterstaff(HttpServletRequest request) {
		return "register";
	}
	
	@RequestMapping(value = "/register", method = RequestMethod.POST)
    public ModelAndView do_register(HttpServletRequest request) {
		
        String message = "";
        ModelAndView mav = new ModelAndView("register");
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
            	request.setCharacterEncoding("UTF-8");
                List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                String uname = data.get(0).getString("UTF-8");
                String pwd = data.get(1).getString();
                String fullname = data.get(2).getString("UTF-8");
                String gender = data.get(3).getString();
                String image = new File(data.get(4).getName()).getName();
                Logins login = new Logins(uname, pwd, fullname, gender, image);
                Manager rm = new Manager();
                message = rm.doSignUp(login);
                String path = request.getSession().getServletContext().getRealPath("/") + "//WEB-INF//images//";
                data.get(4).write(new File(path + File.separator + image));
            } catch (Exception e) {
                e.printStackTrace();
                message = "Please try again...."; 
            } 
	 } 
	 
	 mav.addObject("message", message); 
	 return mav; 
	 } 
	
	
}
