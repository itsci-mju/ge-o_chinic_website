package org.itsci.controller.spring;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.itsci.models.*;
import org.itsci.manager.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class AddServiceController {
	
	@Autowired
	private ServicesManager sm;
	
	@RequestMapping(value="/open_add_service_page", method=RequestMethod.GET)
	public ModelAndView LondAddservices(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("admin/service/add_service");

		List<ServiceType> st = sm.getlistServiceType();
		List<Expertise> et = sm.getListExpertise();
		mav.addObject("service_type",st);
		mav.addObject("expertise",et);
		return mav;
	}
	
	@RequestMapping(value="/add_services", method=RequestMethod.POST)
	public ModelAndView doAddProducts(HttpServletRequest request){
		HttpSession session = request.getSession();
		ModelAndView mav = new ModelAndView("admin/list/list_service");
		
		
			try {
				List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
				request.setCharacterEncoding("UTF-8");
			
//			String serviceName = request.getParameter("");
//			String serviceDetail = request.getParameter("");
//			int serviceStatus = Integer.parseInt(request.getParameter(""));
//			double price = Double.parseDouble(request.getParameter(""));
//			String image = request.getParameter("");
//			data.write(new File(path + File.separator + image));
				
			String serviceName = data.get(0).getString("UTF-8");
			String image = new File(data.get(1).getName()).getName();
			
			String path = request.getSession().getServletContext().getRealPath("/") + "WEB-INF\\assets\\images\\";
			data.get(1).write(new File(path + File.separator + image));
			
			String serviceDetail = data.get(2).getString("UTF-8");
			int serviceStatus = Integer.parseInt(data.get(3).getString());
			int servicetype_FK = Integer.parseInt(data.get(4).getString());
			int expertise_FK = Integer.parseInt(data.get(5).getString());
			double price = Double.parseDouble(data.get(6).getString("UTF-8"));
			
			System.out.println(path + File.separator + image);
			
			ServiceType st = sm.getServiceType(servicetype_FK);
			Expertise et = sm.getExpertise(expertise_FK);
			
			Services s = new Services(serviceName,serviceDetail,serviceStatus,price,image,st,et);
			int result = sm.addService(s);
			System.out.println(result+"****************");
			if(result == 1) {
				mav.addObject("message","Input Service Succeed");
				System.out.println();
			}else {
				mav.addObject("message","Input Service Failed");
			}
			
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
