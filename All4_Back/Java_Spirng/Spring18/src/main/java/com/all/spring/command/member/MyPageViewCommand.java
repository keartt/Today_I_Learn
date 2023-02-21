package com.all.spring.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.MDao;
import com.all.spring.dto.MDto;

public class MyPageViewCommand implements Command {
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		MDto dto = new MDao().memberView(request.getParameter("user_id"));
		model.addAttribute("member", dto);
	}
}
