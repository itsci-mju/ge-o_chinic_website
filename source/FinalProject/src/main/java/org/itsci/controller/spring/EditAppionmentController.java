package org.itsci.controller.spring;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.itsci.manager.AppionmentManager;
import org.itsci.manager.BuyServiceManager;
import org.itsci.models.BuyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class EditAppionmentController {
	@Autowired
	BuyServiceManager bm;
	@Autowired
	AppionmentManager am;
	
	@RequestMapping(value="/open_edit_appoinment_page", method=RequestMethod.GET)
	public ModelAndView LondEditApooinment(HttpServletRequest request) throws ParseException {
		ModelAndView mav = new ModelAndView("staff/list_appionments_staff/edit_appionment_page");
		int Id = Integer.parseInt(request.getParameter("id"));
		BuyService buyservice = bm.getBuyService(Id);
		
		//รับ ID เพื่อแสดงวันที่
		String dateParameter = am.getBuyServicesDates(Id);
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		Date format_Date = dateFormat.parse(dateParameter);
		String format_Chang_Date = dateFormat.format(format_Date);
		System.out.println(format_Chang_Date);
		
		//รับ ID เพื่อแสดงเวลา 
		String timeParameter = am.getBuyServicesTimss(Id);
		System.out.println(timeParameter);
		List<String> times = new ArrayList<String>(); //เวลาที่ใช้ select
		//สร้างเวลา
		times.add("09:00");
		times.add("10:00");
		times.add("11:00");
		times.add("12:00");
		times.add("13:00");
		times.add("14:00");
		times.add("15:00");
		times.add("16:00");
		times.add("17:00");
		times.add("18:00");
		//สรวจสอบเวลาที่ซ้ำ
		List<String> list_time = am.getAppointmentTimes(format_Chang_Date);
		System.out.println(list_time);
		if (list_time != null) {
		    Iterator<String> iterator = times.iterator();
		    while (iterator.hasNext()) {
		        String time = iterator.next();
		        if (list_time.contains(time) && !timeParameter.equals(time)) {
		            iterator.remove();
		        }
		    }
		}
//		if (timeParameter != null) {
//			for (String time : times) {
//			    if (time.equals(timeParameter)) {
//			        timeParameter = time;
//			        break;
//			    }
//			}
//		}
		
		//ส่งค่าไปแสดง
		mav.addObject("times_select",timeParameter);
		mav.addObject("date_now",format_Chang_Date);
	    mav.addObject("BuyServices", buyservice);   
	    mav.addObject("Times",times);
		return mav;
	}
	
	@RequestMapping(value="/check_edit_make_appoinment_page", method=RequestMethod.GET)
	public ModelAndView CheckEditMakeApooinment(HttpServletRequest request) throws java.text.ParseException {
		ModelAndView mav = new ModelAndView("staff/edit_appionment_page");
		int Id = Integer.parseInt(request.getParameter("id"));
		BuyService buyservice = bm.getBuyService(Id);
		
        String dateParameter = request.getParameter("date_app");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        Date check_date = dateFormat.parse(dateParameter);
        String format_Chang_Date = dateFormat.format(check_date);

        

		List<String> times = new ArrayList<String>(); //เวลาที่ใช้ select

		times.add("09:00");
		times.add("10:00");
		times.add("11:00");
		times.add("12:00");
		times.add("13:00");
		times.add("14:00");
		times.add("15:00");
		times.add("16:00");
		times.add("17:00");
		times.add("18:00");
		
		List<String> list_time = am.getAppointmentTimes(format_Chang_Date);
		System.out.println(list_time);

		if (list_time != null) {
            Iterator<String> iterator = times.iterator();
            while (iterator.hasNext()) {
                String time = iterator.next();
                if (list_time.contains(time)) {
                    iterator.remove();
                }
            }
        }
		
		mav.addObject("BuyServices", buyservice);   
	    mav.addObject("date_now",format_Chang_Date);
	    mav.addObject("Times",times);
		return mav;
	}
	
	@RequestMapping(value="/edit_make_appoinments_page", method=RequestMethod.POST)
	public ModelAndView doEditMakeApooinment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("staff/list_appionments_staff/list_appionment_page");
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    List<BuyService> list_buyservice = bm.getlistBuyServiceByStatus();
		
	    String select_date_string = request.getParameter("date_app");
	    String select_time = request.getParameter("select_time");
	    
	    String date_time = select_date_string + " " + select_time;
	    Date select_date = null;
	    try {
			select_date = new SimpleDateFormat("yyyy-MM-dd HH:mm").parse(date_time);
			
		} catch (java.text.ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    
	    
	    am.updateAppointmente(id, select_date);
	    
	    
	    mav.addObject("ListBuyServices", list_buyservice);
	    return mav;
	}
}
