package com.org.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.RegisterDao;
import com.org.dao.TodoDao;
import com.org.dto.Register;
import com.org.dto.Todo;
@Controller
public class TodoConroller {
	
	@RequestMapping("/submit")
	public ModelAndView saveData(@ModelAttribute Todo td , HttpSession hs) {
		Register user = RegisterDao.findByEmail((String)hs.getAttribute("email"),(String)hs.getAttribute("password"));
		td.setReg(user) ;
		ModelAndView mav = new ModelAndView("Home.jsp");
		boolean res = TodoDao.saveData(td);
		if(res) mav.addObject("msg" , "list addedd successfully");
		else mav.addObject("msg" , "something went wrong");
		return mav;
	}
	
	@RequestMapping("/get")
	public String view(HttpSession hs) {
		int id = (int) hs.getAttribute("id") ;
		List<Todo> td = TodoDao.viewData(id);
		System.out.println(td);
		hs.setAttribute("ToDo", td);
		return "view.jsp";
	}
	
	@RequestMapping("/delete")
	public ModelAndView deleteList(@RequestParam int id) {
		ModelAndView mav = new ModelAndView("get");
		boolean res = TodoDao.deleteData(id);
		if(res) mav.addObject("msg" , "deleted Sucessfully");
		return mav;
	}
	
	@RequestMapping("/edit")
	public ModelAndView editDetails(@RequestParam int id) {
		Todo td = TodoDao.findById(id);
		ModelAndView mav = new ModelAndView("update.jsp");
		mav.addObject("todo" , td);
		return mav;
	}
	@RequestMapping("/update")
	public ModelAndView updateList(@ModelAttribute Todo td,HttpSession hs) {
		
		TodoDao.updateList(td,(Integer)hs.getAttribute("id"));
		System.out.println("---------------->"+td);
		ModelAndView mav = new ModelAndView("get");
		mav.addObject("msg", "updated successfully");
		return mav;
	}
}
