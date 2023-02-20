package com.all.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.all.spring.command.member.MCommand;
import com.all.spring.command.member.MDeleteCommand;
import com.all.spring.command.member.MJoinCommand;
import com.all.spring.command.member.MListCommad;
import com.all.spring.command.member.MLoginCommand;
import com.all.spring.command.member.MViewCommand;
import com.all.spring.util.Constant;

@Controller
public class MController {
	MCommand command = null;

	public JdbcTemplate template;

	@Autowired
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
		Constant.template = this.template;
	}

//	1. 로그인
	// 1-1. /로그인 요청 -> 로그인 페이지로
	@RequestMapping("/login")
	public String loginPage() {
		return "member/loginForm";
	}

	// 1-2. /로그인 submit
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginAction(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		command = new MLoginCommand();
		command.execute(model);

		return "member/alert";
	}

//	2. 회원가입
	// 2-1./회원가입 요청 -> 회원가입 페이지로
	@RequestMapping("/join")
	public String joinPage() {
		return "member/joinForm";
	}

	// 2-2 /회원가입 submit
	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String joinAction(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		command = new MJoinCommand();
		command.execute(model);

		return "member/alert";
	}

////	3. 관리자 페이지
//	//	3-1 /관리자	회원리스트 보기
	@RequestMapping(value = "/admin") // 얘는 post 아니고 get 임 까먹지 말기
	public String memberList(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		command = new MListCommad();
		command.execute(model);
		return "member/Member_list";
	}

//	//	3-2 /관리자 	회원정보 보기
//	@RequestMapping(value = "/join", method = RequestMethod.POST)
//	public String memberView(Model model, HttpServletRequest request) {
//		model.addAttribute("request", request);
//		command = new MViewCommand();
//		command.execute(model);
//		
//		return " ";
//	}

//	//	3-3 /관리자	회원정보 삭제 
//	@RequestMapping(value = "/join", method = RequestMethod.POST)
//	public String memberDelete(Model model, HttpServletRequest request) {
//		model.addAttribute("request", request);
//		command = new MDeleteCommand();
//		command.execute(model);
//		
//		return " ";
//	}

}
