package com.all.spring;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class StudentController {
	
	@RequestMapping("/studentConfirm")
	public String studentRedirect(HttpServletRequest httpServletRequest) {
		
		String id = httpServletRequest.getParameter("id");
		if (id.equals("a")) {
			return "redirect:studentOk";
		}
		return "redirect:studentNg";
	}
	
	@RequestMapping("/studentOk")
	public String studentOk() {
		return "studentOk";
	}
	
	@RequestMapping("/studentNg")
	public String studentNg() {
		return "studentNg";
	}


}
