package org.itsci.controller.spring;

import java.io.UnsupportedEncodingException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.itsci.models.Logins;
import org.itsci.models.Person;
import org.itsci.manager.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class EditStaffController {
	
	@Autowired
	private Manager m;
	
	@RequestMapping(value="/open_edit_staff_page", method=RequestMethod.GET)
	public ModelAndView LondAddStaff(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("admin/staff/edit_staff");
			String Id = request.getParameter("id");
			
			Logins log = m.getLogins(Id);
			Person p = log.getPersons();
			
			mav.addObject("logins",log);
			mav.addObject("person",p);
		return mav;
	}
	
	@RequestMapping(value="/edit_staff_page", method=RequestMethod.POST)
	public ModelAndView AddStaff(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("admin/list/list_staff");
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

		
		SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
		Date strDate;
			strDate = format.parse(birthday);
			
			Logins user = new Logins(email,pwd,"s");
			Person p = new Person(name,nickname,strDate,idcard,
					gender,address,phone,"",
					"");
			p.setPerson_id(Integer.parseInt(id));
			
		p.setLogins(user);
		m.UpdatePerson(p);
		
		List<Person> list_staff = m.getListStaff();
		mav.addObject("list_staff",list_staff);
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
