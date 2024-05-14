package com.all.spring.command.member;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.MDao;
import com.all.spring.dto.MDto;

public class MyPageEditCommand implements Command {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		String user_id = request.getParameter("user_id");
		System.out.println(user_id);
		String user_pw = request.getParameter("user_pw");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		

		String[] temp = request.getParameterValues("interest");
		String interest = Arrays.toString(temp);

		String introduce = request.getParameter("introduce");

		MDao dao = new MDao();
		try {
			dao.edit(user_id, user_pw, email, name,interest,introduce );
			model.addAttribute("msg", "변경완료");
			model.addAttribute("url", "list");
		} catch (Exception e) {
			model.addAttribute("msg", "실패");
			model.addAttribute("url", "list");
		}
		
		
		
	}
}
