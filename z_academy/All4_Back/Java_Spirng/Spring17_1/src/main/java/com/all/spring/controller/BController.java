package com.all.spring.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.all.spring.command.BCommand;
import com.all.spring.command.BContentCommand;
import com.all.spring.command.BDeleteCommand;
import com.all.spring.command.BListCommand;
import com.all.spring.command.BModifyCommand;
import com.all.spring.command.BReplyCommand;
import com.all.spring.command.BReplyViewCommand;
import com.all.spring.command.BWriteCommand;
import com.all.spring.util.Constant;

@Controller
public class BController {
	BCommand command = null;
	
	
	public JdbcTemplate template;

	@Autowired // 빈이 만들어질때 바로 setting
	public void setTemplate(JdbcTemplate template){
		this.template = template;
		// template을 전역적으로 사용하기 위해 Constant 파일을 만듬
		Constant.template = this.template;
	}
	
	
	
	// 글 리스트 페이지
	@RequestMapping("/list")
	public String list(Model model){
		command = new BListCommand();
		command.execute(model);
		
		return "list";
	}
	// 글 작성 페이지 이동
	@RequestMapping("/write_view")
	public String write_view () {
		return  "write_view";
	}
	// 글 작성 액션
	@RequestMapping("/write")
	public String wirte(Model model, HttpServletRequest request) {
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	// 글 상세 내용 페이지
	@RequestMapping("/content_view")
	public String content_view (Model model, HttpServletRequest request) {
		model.addAttribute("request",request);
		command = new BContentCommand();
		command.execute(model);
		
		return "content_view";
	}
	
	// 글 수정 
	@RequestMapping("/modify")
	public String modify (Model model, HttpServletRequest request) {
		model.addAttribute("request",request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	// 글 삭제
	@RequestMapping("/delete")
	public String delete (Model model, HttpServletRequest request) {
		model.addAttribute("request",request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	// 글 답변
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request,Model model) {
		System.out.println("reply_view()");
		model.addAttribute("request",request);
		command = new BReplyViewCommand();
		command.execute(model);
		return "reply_view";
	}
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model) {
		System.out.println("reply()");
		model.addAttribute("request", request);		
		command = new BReplyCommand();
		command.execute(model);
		return "redirect:list";
	}
}
