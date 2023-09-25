package com.org.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.org.dao.RegisterDao;
import com.org.dto.Register;

@Controller
public class RegisterController {
	@RequestMapping("/Register")
	public ModelAndView save(@ModelAttribute Register r) {
		ModelAndView mav = new ModelAndView("login.jsp");
		boolean res = RegisterDao.saveDetails(r);
		if(res) mav.addObject("msg" , "Register successfull");
		else mav.addObject("msg" , "something wengt wrong");
		return mav;
	}
}
