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

import model.Category;
import model.Menu;
import utils.Manager;

@Controller
public class EditMenuControllers {

	@RequestMapping(value = "/openEditmenu", method = RequestMethod.POST)
    public ModelAndView do_register(HttpServletRequest request) throws UnsupportedEncodingException {
		
        String message = "";
        ModelAndView mav = new ModelAndView("EditMenu");
        
        if (ServletFileUpload.isMultipartContent(request)) {
            try {
            	request.setCharacterEncoding("UTF-8");
                List<FileItem> data = new ServletFileUpload(new DiskFileItemFactory()).parseRequest(request);
                int idmenu = Integer.parseInt(data.get(0).getString());
                String nameMenu = data.get(1).getString("UTF-8");
                int priceMenu = Integer.parseInt(data.get(2).getString());
                String CategoryMenu = data.get(3).getString("UTF-8");
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
        		mav.addObject("Menu",menus);
        		
        		int result = m.editMenu(menus);
        		String path = request.getSession().getServletContext().getRealPath("/") + "//WEB-INF//images//";
                data.get(4).write(new File(path + File.separator + image));
        		if(result == 1) {
        			message = "Edit Successfully...";
        		}else {
        			message = "Please try again...."; 
        		}
            } catch (Exception e) {
                e.printStackTrace();
                message = "Please try again...."; 
                mav.addObject("message", message); 
                
                return mav; 
            } 
            mav.addObject("message", message); 
	 } 
	 return mav; 
	 } 
	
}
