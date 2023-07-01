package org.itsci.controller.spring;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.itsci.manager.AppionmentManager;
import org.itsci.manager.BuyServiceManager;
import org.itsci.manager.LoginManager;
import org.itsci.manager.ServicesManager;
import org.itsci.models.Appoinment;
import org.itsci.models.BuyService;
import org.itsci.models.Services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.protobuf.TextFormat.ParseException;

@Controller
public class MakeApooinmentController {
	@Autowired
	BuyServiceManager bm;
	@Autowired
	AppionmentManager am;
	@Autowired
	ServicesManager sm;
	@Autowired
	LoginManager lm;
	
	@RequestMapping(value="/open_make_appoinment_page", method=RequestMethod.GET)
	public ModelAndView LondMakeApooinment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView();
		int Id = Integer.parseInt(request.getParameter("id"));
		Date date_now = new Date(System.currentTimeMillis() + 24 * 60 * 60 * 1000);// วันที่พรุ่งนี้
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String formattedDate = sdf.format(date_now);
        System.out.println(formattedDate);
        
        String chack_date =  request.getParameter("date_app");
        if(chack_date != null) {
        	try {
				date_now = sdf.parse(chack_date);
				
			} catch (java.text.ParseException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
        }
        String format_Chang_Date = sdf.format(date_now);
        
		BuyService buyservice = bm.getBuyService(Id);

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
		//สรวจสอบเวลาที่ซ้ำ
//		if (list_time != null) {
//			for (String time : times) {
//			    boolean found = false;
//			    for (String listTime : list_time) {
//			        if (time.equals(listTime)) {
//			            found = true;
//			            times.remove(time);
//			        }
//			    }
//			}
//		}
		
		if (list_time != null) {
		    List<String> timesToRemove = new ArrayList<>();
		    for (String time : times) {
		        if (list_time.contains(time)) {
		            timesToRemove.add(time);
		        }
		    }
		    times.removeAll(timesToRemove);
		}
		
	     
	    if (buyservice != null) {
	    	String email = request.getParameter("email");
			int memberId = Integer.parseInt(lm.getLoginMemberId(email));
			List<BuyService> list_buyservice = bm.getlistBuyServiceMemberId(memberId);
			String check_dates = am.getBuyServicesDates(Id);
			
	        mav = new ModelAndView("member/appionment_member/view_appointment");
	        mav.addObject("BuyServices", buyservice);

	        if (buyservice.getStatus() == 0 || buyservice.getStatus() == 1) {
	            String message = "กรุณาชำระเงิน หรือรอการตรวจสอบ";
	            mav.addObject("ListBuyServices", list_buyservice);
	            mav.addObject("message", message);
	            mav.setViewName("member/appionment_member/view_appointment");
	        } else if(buyservice.getStatus() == 2 && check_dates != null){
	        	String message = "คุณได้ทำการจองเวลาไว้แล้ว";
	            mav.addObject("ListBuyServices", list_buyservice);
	            mav.addObject("message", message);
	            mav.setViewName("member/appionment_member/view_appointment");
	        }else {
	        	mav.addObject("ListBuyServices", list_buyservice);
	            mav.setViewName("member/make_appoinment_page");
	        }
	    } else {
	        mav = new ModelAndView("error_page");
	    }
	    mav.addObject("BuyServices", buyservice);  
	    mav.addObject("date_now",formattedDate);
	    mav.addObject("Times",times);
		return mav;
	}
	
	@RequestMapping(value="/check_make_appoinment_page", method=RequestMethod.GET)
	public ModelAndView CheckMakeApooinment(HttpServletRequest request) throws java.text.ParseException {
		ModelAndView mav = new ModelAndView("member/make_appoinment_page");
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
	
	@RequestMapping(value="/make_appoinment_page", method=RequestMethod.POST)
	public ModelAndView doMakeApooinment(HttpServletRequest request) {
		ModelAndView mav = new ModelAndView("member/appionment_member/view_appointment");
	    int id = Integer.parseInt(request.getParameter("id"));
	    
	    String Id = request.getParameter("member_id");
		int memberId = Integer.parseInt(lm.getLoginMemberId(Id));
		List<BuyService> list_buyservice = bm.getlistBuyServiceMemberId(memberId);
		
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
