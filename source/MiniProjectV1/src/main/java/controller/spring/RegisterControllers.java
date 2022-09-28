package controller.spring;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import models.*;
import utils.*;

@Controller
public class RegisterControllers {
	@RequestMapping(value="/open_Registers_page", method=RequestMethod.GET)
	public ModelAndView LondRegisters(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("register_page");

		return mav;
	}
	@RequestMapping(value="/open_Registers_page", method=RequestMethod.POST)
	public ModelAndView LondEditRegisters(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("Login_page");
		try {
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		String pwd = request.getParameter("pwd");
		String birthday = request.getParameter("birthday");
		String gender = request.getParameter("err_gender");
		String nickname = request.getParameter("nickname");
		String idcard = request.getParameter("idcard");
		String address = request.getParameter("address");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		String congenital_disorder = request.getParameter("congenital_disorder");
		String drug_allergy = request.getParameter("drug_allergy");
		
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date strDate;
			strDate = format.parse(birthday);
			
			Logins user = new Logins(email,pwd,"m");
			Person p = new Person(name,nickname,strDate,idcard,
					gender,address,phone,congenital_disorder,
					drug_allergy);
			
		Manager mm = new Manager();
		p.setLogins(user);
		
		int result = mm.AddorUpdatePerson(p);

		
		
		
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}
}
