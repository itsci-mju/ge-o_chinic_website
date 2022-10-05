package org.itsci.controller.spring;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.itsci.manager.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.itsci.models.Logins;
import org.itsci.models.Person;


@Controller
public class EditProfileControllers {
	
	@Autowired
	private Manager m;
	
	@RequestMapping(value="/open_edit_profile_page", method=RequestMethod.GET)
	public ModelAndView LondAddMenu(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/profile/edit_profile");
		String Id = request.getParameter("id");
		
		Logins log = m.getLogins(Id);
		Person p = log.getPersons();
		
		mav.addObject("logins",log);
		mav.addObject("person",p);
		return mav;
	}
	
	@RequestMapping(value="/Edit_Profile", method=RequestMethod.POST)
	public ModelAndView LoadEditProfile(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("member/edit_profile");
		try {
		request.setCharacterEncoding("UTF-8");
		
		String id = request.getParameter("person_id");
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
		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date strDate;
			strDate = format.parse(birthday);
			
			Logins user = (Logins) session.getAttribute("member");
			Person p = new Person(name,nickname,strDate,idcard,
					gender,address,phone,congenital_disorder,
					drug_allergy);
			p.setPerson_id(Integer.parseInt(id));
			
		p.setLogins(user);
		
		int result = m.UpdatePerson(p);

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
