package com.all.spring.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
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

@Controller
public class BController {

	// 글 리스트 페이지
	@Autowired
	BListCommand bListCommand;
	@RequestMapping("/list")
	public String list(Model model, HttpSession session) {
		String userId = (String) session.getAttribute("user_id");
		if (userId == null) {
			model.addAttribute("msg", "로그인 하셈");
			model.addAttribute("url", "/login");
			return "member/alert";
		}
		bListCommand.execute(model);
		model.addAttribute("user_id", userId);

		return "board/list";
	}

	// 글 작성 페이지 이동
	@RequestMapping("/write_view")
	public String write_view(Model model, HttpSession session) {

		String userId = (String) session.getAttribute("user_id");
		if (userId == null) {
			model.addAttribute("msg", "로그인 하셈");
			model.addAttribute("url", "/login");
			return "member/alert";
		}

		model.addAttribute("user_id", session.getAttribute("user_id"));
		return "board/write_view";
	}

	// 글 작성 액션
	@Autowired
	BWriteCommand bWriteCommand;
	@RequestMapping("/write")
	public String wirte(Model model, HttpServletRequest request, HttpSession session) {

		String userId = (String) session.getAttribute("user_id");
		if (userId == null) {
			// alert 함께
			model.addAttribute("msg", "로그인 하셈");
			model.addAttribute("url", "/login");
			return "member/alert";
		}

		System.out.println("비컨1");
		model.addAttribute("request", request);
		bWriteCommand.execute(model);
		System.out.println("비컨2");

		return "redirect:list";
	}

	// 글 상세 내용 페이지
	@Autowired
	BContentCommand bContentCommand;
	@RequestMapping("/content_view")
	public String content_view(Model model, HttpServletRequest request, HttpSession session) {

		String userId = (String) session.getAttribute("user_id");
		if (userId == null) {
			model.addAttribute("msg", "로그인 하셈");
			model.addAttribute("url", "/login");
			return "member/alert";
		}

		model.addAttribute("request", request);
		bContentCommand.execute(model);

		return "board/content_view";
	}

	// 글 수정
	@Autowired
	BModifyCommand bModifyCommand;
	@RequestMapping("/modify")
	public String modify(Model model, HttpServletRequest request, HttpSession session) {

		String userId = (String) session.getAttribute("user_id");
		if (userId == null) {
			model.addAttribute("msg", "로그인 하셈");
			model.addAttribute("url", "/login");
			return "member/alert";
		}

		model.addAttribute("request", request);
		bModifyCommand.execute(model);

		return "member/alert";
	}

	// 글 삭제
	@Autowired
	BDeleteCommand bDeleteCommand;
	@RequestMapping("/delete")
	public String delete(Model model, HttpServletRequest request, HttpSession session) {

		String userId = (String) session.getAttribute("user_id");
		if (userId == null) {
			model.addAttribute("msg", "로그인 하셈");
			model.addAttribute("url", "/login");
			return "member/alert";
		}

		model.addAttribute("request", request);
		bDeleteCommand.execute(model);

		return "member/alert";
	}

	// 글 답변 접근
	@Autowired
	BReplyViewCommand bReplyViewCommand;
	@RequestMapping("/reply_view")
	public String reply_view(HttpServletRequest request, Model model, HttpSession session) {

		String userId = (String) session.getAttribute("user_id");
		if (userId == null) {
			model.addAttribute("msg", "로그인 하셈");
			model.addAttribute("url", "/login");
			return "member/alert";
		}

		model.addAttribute("request", request);
		bReplyViewCommand.execute(model);

		model.addAttribute("user_id", session.getAttribute("user_id"));

		return "board/reply_view";
	}
	// 글 답변 액션
	@Autowired
	BReplyCommand bReplyCommand;
	@RequestMapping("/reply")
	public String reply(HttpServletRequest request, Model model, HttpSession session) {

		String userId = (String) session.getAttribute("user_id");
		if (userId == null) {
			model.addAttribute("msg", "로그인 하셈");
			model.addAttribute("url", "/login");
			return "member/alert";
		}

		model.addAttribute("request", request);
		bReplyCommand.execute(model);
		return "redirect:list";
	}

	@RequestMapping("/download")
	public void download(@RequestParam("filename") String filename, HttpServletRequest request,
			HttpServletResponse response) {
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
			System.out.println(ex);
		}
	}
	
}
