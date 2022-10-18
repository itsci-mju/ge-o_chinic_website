package org.itsci.goclinic.controller;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.itsci.goclinic.manager.Manager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.itsci.goclinic.model.Login;
import org.itsci.goclinic.model.Person;

@Controller
public class AddStaffController {
	
	
	
	@RequestMapping(value="/open_add_staff_page", method=RequestMethod.GET)
	public ModelAndView LondAddStaff(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/staff/add_staff");

		return mav;
	}
	
	@Autowired
	private Manager m;
	
	@RequestMapping(value="/add_staff_page", method=RequestMethod.POST)
	public ModelAndView AddStaff(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/list/list_staff");
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
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date strDate;
			strDate = format.parse(birthday);
			
			Login user = new Login(email,pwd,"s");
			Person p = new Person(name,nickname,strDate,idcard,gender,address,phone,"","");
	
		p.setLogins(user);
		m.AddPerson(p);
		
		List<Person> list_staff = m.getListStaff();
		mav.addObject("list_staff",list_staff);
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}
}
