package itsci.controller.spring;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import utils.Manager;
import model.Category;
import model.Menu;
@Controller
public class AddMenuControllers {

	
	@RequestMapping(value = "/openAddmenu", method = RequestMethod.POST)
    public ModelAndView do_register(HttpServletRequest request) throws UnsupportedEncodingException {
		request.setCharacterEncoding("UTF-8");
        String message = "";
        ModelAndView mav = new ModelAndView("openAddmenu");
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
            	
                List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                int idmenu = Integer.parseInt(data.get(0).getString());
                String nameMenu = data.get(1).getString();
                int priceMenu = Integer.parseInt(data.get(2).getString());
                String CategoryMenu = data.get(3).getString();
                String image = new File(data.get(4).getName()).getName();
                Manager m = new Manager();
        		Category ct  = new Category();
        		List<Category> c = m.getCategoryList();
        		
        		for(Category cs : c) {
        			if(Integer.parseInt(CategoryMenu) == cs.getCategoryid()) {
        				ct = cs;
        			}
        		}
        		Menu menus = new Menu(idmenu,nameMenu,priceMenu,ct,image);
        		int result = m.AddMenu(menus);
        		String path = request.getSession().getServletContext().getRealPath("/") + "//WEB-INF//images//";
                data.get(4).write(new File(path + File.separator + image));
        		if(result == 1) {
        			message = "Add Successfully...";
        			mav = new ModelAndView("AddMenu");
        		}else {
        			message = "Please try again...."; 
        			mav = new ModelAndView("AddMenu");
        		}
            } catch (Exception e) {
                e.printStackTrace();
                message = "Please try again...."; 
                mav.addObject("message", message); 
                mav = new ModelAndView("AddMenu");
                return mav; 
            } 
            mav.addObject("message", message); 
	 } 
	 return mav; 
	 } 
}
