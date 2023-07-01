package org.itsci.controller.spring;

import java.io.File;
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
import org.itsci.manager.*;
import org.itsci.models.Expertise;
import org.itsci.models.Logins;
import org.itsci.models.Person;
import org.itsci.models.ServiceType;
import org.itsci.models.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
@Controller
public class EditServiceController {
	
	@Autowired
	private ServicesManager sm;
	
	@RequestMapping(value="/open_edit_service_page", method=RequestMethod.GET)
	public ModelAndView LondEditServices(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("admin/service/edit_service");
		int Id = Integer.parseInt(request.getParameter("id"));
		
		Services s = sm.getServices(Id);
		List<ServiceType> st = sm.getlistServiceType();
		List<Expertise> et = sm.getListExpertise();
		
		mav.addObject("services",s);
		mav.addObject("servicetype",st);
		mav.addObject("expertise",et);
		return mav;
	}
	
	@RequestMapping(value="/edit_service_page", method=RequestMethod.POST)
	public ModelAndView EditSrevice(HttpServletRequest request) {
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("admin/list/list_service");
		try {
			List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
			request.setCharacterEncoding("UTF-8");
			
		String serviceName = data.get(0).getString("UTF-8");
		String image = new File(data.get(1).getName()).getName();
		
		String path = request.getSession().getServletContext().getRealPath("/") + "WEB-INF" + File.separator + "assets" + File.separator + "images";
		File file = new File(path + File.separator + image);
		data.get(1).write(file);
		// ตรวจสอบว่ามีไฟล์รูปภาพใหม่ถูกอัปโหลดมาหรือไม่
        if (file.exists()) {
            // ดำเนินการอัปเดตไฟล์รูปภาพที่อัปโหลดมาใหม่
            data.get(1).write(file);
        }
		
		String serviceDetail = data.get(2).getString("UTF-8");
		int servicetype_FK = Integer.parseInt(data.get(3).getString());
		int expertise_FK = Integer.parseInt(data.get(4).getString());
		double price = Double.parseDouble(data.get(5).getString());
		
		System.out.println(path + File.separator + image);
		
		ServiceType st = sm.getServiceType(servicetype_FK);
		Expertise et = sm.getExpertise(expertise_FK);
		
		Services s = new Services(serviceName,serviceDetail,1,price,image,st,et);
		sm.UpdateService(s);
		
		List<ServiceType> list_st = sm.getlistServiceType();
		List<Services> list_services = sm.getListService();
		mav.addObject("list_service_type",list_st);
		mav.addObject("ListServices",list_services);
		
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
