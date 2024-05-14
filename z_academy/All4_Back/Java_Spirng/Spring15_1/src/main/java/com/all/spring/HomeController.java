package com.all.spring;

import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.all.spring.member.Member;

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

		model.addAttribute("serverTime", formattedDate);

		return "home";
	}

	@RequestMapping("/board/confirm")
	public String confirm(Model model, HttpServletRequest hsr) {
		String id = hsr.getParameter("id");
		String pw = hsr.getParameter("pw");

		// 모델을 통해 data 넘기기
		model.addAttribute("id", id);
		model.addAttribute("pw", pw);
		return "board/confirmId";
	}

	@RequestMapping("/board/checkId")
	public String checkId(@RequestParam("id") String id, @RequestParam("pw") String pw, Model model) {
		model.addAttribute("identify", id);
		model.addAttribute("password", pw);
		return "board/checkId";
	}

	@RequestMapping("/member/join")
	public String memberInfo(Member member) {
		return "/member/join";
	}
	
	@RequestMapping("/student/{studentId}")
    public String student(@PathVariable String studentId, Model model) {
        model.addAttribute("studentId", studentId);
        return "/student/studentView";
    }
	
	
	

}
