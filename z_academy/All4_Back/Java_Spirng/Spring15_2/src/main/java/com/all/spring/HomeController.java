package com.all.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate );
		
		return "home";
	}
	
	@RequestMapping("/index")
	public String index() {
		return "input";
	}
	
	
	@RequestMapping( method = {RequestMethod.GET,RequestMethod.POST}, value = "/student")
	public String student(@RequestParam("studentId") String studentId, Model model) {
		model.addAttribute("studentId", studentId);
		return "output";
	}
	
	@RequestMapping(method = RequestMethod.POST, value = "/student")
	public ModelAndView student(@RequestParam("studentId") String studentId) {
		ModelAndView mav = new ModelAndView();
		mav.addObject("studentId", studentId);
		mav.setViewName("output");
		return mav;
	}
	
	@RequestMapping("/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping( "/join_result")
	public String join_result(@ModelAttribute("aa") Member member) {
		return "join_result";
	}
}
