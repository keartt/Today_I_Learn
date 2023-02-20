package com.all.spring.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.all.spring.dao.MDao;
import com.all.spring.dto.MDto;

public class MLoginCommand implements MCommand{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		String user_id = request.getParameter("user_id");
		String user_pw = request.getParameter("user_pw");
		
		System.out.println("커맨드1"+user_id);
		
		MDao mDao = new MDao();
		try {
			MDto mDto = mDao.login(user_id, user_pw);
			 if (mDto != null) {
		            // 로그인 성공
		            HttpSession session = request.getSession();
		            session.setAttribute("user_id", mDto.getUser_id());
		            if (mDto.getUser_id().equals("admin")) {
		            	model.addAttribute("msg", "관리자 ㅎㅇ");
			            model.addAttribute("url", "/admin");
					}else {
						model.addAttribute("msg", "로그인 ㅊㅋ");
			            model.addAttribute("url", "/list");
					}
		        } else {
		            // 로그인 실패
		            model.addAttribute("msg", "로그인 실패ㅋ");
		            model.addAttribute("url", "/login");
		        }
		    } catch (Exception e) {
		        model.addAttribute("msg", "뭔가 잘못됐는데연?");
		        model.addAttribute("url", "/login");
		    }
		
		
	}
}