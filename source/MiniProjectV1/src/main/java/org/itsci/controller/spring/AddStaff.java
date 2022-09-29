package org.itsci.controller.spring;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.itsci.utils.Manager;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import org.itsci.models.Logins;
import org.itsci.models.Person;

@Controller
public class AddStaff {
	@RequestMapping(value="/open_add_services_page", method=RequestMethod.GET)
	public ModelAndView LondAddservices(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("add_service");
		
		return mav;
	}
	
	@RequestMapping(value="/add_services_page", method=RequestMethod.POST)
	public ModelAndView AddService(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("add_service");
		try {
			List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
		
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
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date strDate;
			strDate = format.parse(birthday);
			
			Logins user = new Logins(email,pwd,"s");
			Person p = new Person(name,nickname,strDate,idcard,
					gender,address,phone,"",
					"");
			
		Manager mm = new Manager();
		p.setLogins(user);
		
		int result = mm.AddorUpdatePerson(p);

		
		
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
        } catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return mav;
	}
}
