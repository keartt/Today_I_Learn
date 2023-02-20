package com.all.spring.command.member;

import java.util.Arrays;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.all.spring.dao.MDao;

public class MJoinCommand implements MCommand {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		String email = request.getParameter("email");
		String name = request.getParameter("name");
		String regi_num_front = request.getParameter("regi_num_front");
		String regi_num_back = request.getParameter("regi_num_back");
		String year = request.getParameter("year");
		String month = request.getParameter("month");
		String day = request.getParameter("day");
		
		String[] temp = request.getParameterValues("interest");
		String interest = Arrays.toString(temp);
		
		String introduce = request.getParameter("introduce");

		MDao dao = new MDao();
		
		try {
			dao.Join(user_id, user_pw, email, name, regi_num_front, regi_num_back, year, month, day, interest, introduce);
			model.addAttribute("msg", "가입 ㅊㅋ");
            model.addAttribute("url", "/login");
		
		} catch (Exception e) {
			model.addAttribute("msg", "가입 실패 ㅋ");
            model.addAttribute("url", "/join");
		}

	}

}