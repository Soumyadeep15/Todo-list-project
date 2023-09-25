package com.org.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.org.dao.RegisterDao;
import com.org.dto.Register;

@Controller
public class LogInController {
	
	
	@RequestMapping("/login")
	public String processLogin(@RequestParam String email , @RequestParam String password , HttpSession hs) {
		Register user = RegisterDao.findByEmail(email , password);
		hs.setAttribute("email", email) ;
		hs.setAttribute("password", password) ;
		hs.setAttribute("id", user.getId());
		if(user.getEmail().equals(email) && user.getPassword().equals(password)) return "Home.jsp";
		else return "error.jsp";
	}
}