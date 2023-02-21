package com.all.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.all.spring.command.Command;
import com.all.spring.command.board.BContentCommand;
import com.all.spring.command.board.BDeleteCommand;
import com.all.spring.command.board.BListCommand;
import com.all.spring.command.board.BModifyCommand;
import com.all.spring.command.board.BReplyCommand;
import com.all.spring.command.board.BReplyViewCommand;
import com.all.spring.command.board.BWriteCommand;
import com.all.spring.util.Constant;

@Controller
public class BController {
	Command command = null;
	
	
	public JdbcTemplate template;

	@Autowired // 빈이 만들어질때 바로 setting
	public void setTemplate(JdbcTemplate template){
		this.template = template;
		// template을 전역적으로 사용하기 위해 Constant 파일을 만듬
		Constant.template = this.template;
	}
	
	
	// 글 리스트 페이지
	@RequestMapping("/list")
	public String list(Model model,HttpSession session){
		
		// 로그인 안하면 로그인 페이지로
		String userId = (String) session.getAttribute("user_id");
	    if (userId == null) {
	    	// alert 함께
	    	model.addAttribute("msg", "로그인 하셈");
            model.addAttribute("url", "/login");
            
            return "member/alert"; 
	    }
		
		command = new BListCommand();
		command.execute(model);
		// 마이페이지 용으로 세션 아이디 보내기
		model.addAttribute("user_id", userId);
		
		return "board/list";
	}
	
	// 글 작성 페이지 이동
	@RequestMapping("/write_view")
	public String write_view (Model model,HttpSession session){
		
		// 로그인 안하면 로그인 페이지로
		String userId = (String) session.getAttribute("user_id");
	    if (userId == null) {
	    	model.addAttribute("msg", "로그인 하셈");
            model.addAttribute("url", "/login");
            
            return "member/alert";}
	    
		model.addAttribute("user_id", session.getAttribute("user_id"));
		return  "board/write_view";
	}
	
	// 글 작성 액션
	@RequestMapping("/write")
	public String wirte(Model model, HttpServletRequest request, HttpSession session){
		
		// 로그인 안하면 로그인 페이지로
		String userId = (String) session.getAttribute("user_id");
	    if (userId == null) {
	    	// alert 함께
	    	model.addAttribute("msg", "로그인 하셈");
            model.addAttribute("url", "/login");
            
            return "member/alert";}
	    
		model.addAttribute("request", request);
		command = new BWriteCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	// 글 상세 내용 페이지
	@RequestMapping("/content_view")
	public String content_view (Model model, HttpServletRequest request, HttpSession session){
		
		// 로그인 안하면 로그인 페이지로
		String userId = (String) session.getAttribute("user_id");
	    if (userId == null) {
	    	// alert 함께
	    	model.addAttribute("msg", "로그인 하셈");
            model.addAttribute("url", "/login");
            
            return "member/alert";}
	    
		model.addAttribute("request",request);
		command = new BContentCommand();
		command.execute(model);
		
		return "board/content_view";
	}
	
	// 글 수정 
	@RequestMapping("/modify")
	public String modify (Model model, HttpServletRequest request, HttpSession session){
		
		// 로그인 안하면 로그인 페이지로
		String userId = (String) session.getAttribute("user_id");
	    if (userId == null) {
	    	// alert 함께
	    	model.addAttribute("msg", "로그인 하셈");
            model.addAttribute("url", "/login");
            
            return "member/alert";}
	    
		model.addAttribute("request",request);
		command = new BModifyCommand();
		command.execute(model);
		
		return "member/alert";
	}
	
	// 글 삭제
	@RequestMapping("/delete")
	public String delete (Model model, HttpServletRequest request, HttpSession session){
		
		// 로그인 안하면 로그인 페이지로
		String userId = (String) session.getAttribute("user_id");
	    if (userId == null) {
	    	// alert 함께
	    	model.addAttribute("msg", "로그인 하셈");
            model.addAttribute("url", "/login");
            
            return "member/alert";}
	    
		model.addAttribute("request",request);
		command = new BDeleteCommand();
		command.execute(model);
		
		return "member/alert";
	}
	
	// 글 답변
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request,Model model, HttpSession session){
		
		// 로그인 안하면 로그인 페이지로
		String userId = (String) session.getAttribute("user_id");
	    if (userId == null) {
	    	// alert 함께
	    	model.addAttribute("msg", "로그인 하셈");
            model.addAttribute("url", "/login");
            
            return "member/alert";}
	    
		model.addAttribute("request",request);
		command = new BReplyViewCommand();
		command.execute(model);
		
		model.addAttribute("user_id", session.getAttribute("user_id"));
		
		return "board/reply_view";
	}
	
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model, HttpSession session){
		
		// 로그인 안하면 로그인 페이지로
		String userId = (String) session.getAttribute("user_id");
	    if (userId == null) {
	    	// alert 함께
	    	model.addAttribute("msg", "로그인 하셈");
            model.addAttribute("url", "/login");
            
            return "member/alert";}
	    
		model.addAttribute("request", request);		
		command = new BReplyCommand();
		command.execute(model);
		
		return "redirect:list";
	}
	
	@RequestMapping("/download")
    public void download(@RequestParam("filename") String filename, HttpServletRequest request, HttpServletResponse response) {
        try {
            String realPath = "";
            String savePath = "boardupload";
            int fileSize = 5 * 1024 * 1024;

            realPath = request.getRealPath(savePath);
            String filePath = realPath + "/" + filename;

            File downloadFile = new File(filePath);
            FileInputStream is = new FileInputStream(downloadFile);

            String mimetype = "application/octet-stream";
            response.setHeader("Content-Disposition", "attachment; filename=\"" + filename + "\";");
            response.setContentType(mimetype);
            response.setContentLength((int) downloadFile.length());
            ServletOutputStream sos = response.getOutputStream();

            byte[] buffer = new byte[4096];
            int bytesRead = -1;

            while ((bytesRead = is.read(buffer)) != -1) {
                sos.write(buffer, 0, bytesRead);
            }

            is.close();
            sos.close();
        } catch (IOException ex) {

        }
    }
}
