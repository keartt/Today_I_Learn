package com.all.spring.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.BDao;

public class BDeleteCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		
		// HttpSession 객체 가져오기
	    HttpSession session = request.getSession();  
	    // HttpSession 객체에서 "user_id" 가져오기
	    String user_id = (String) session.getAttribute("user_id");  
		System.out.println("2" + user_id);
		
		if (user_id.equals(bName)) {
			BDao dao = new BDao();
			dao.delete(bId);
			
			model.addAttribute("msg", "삭제함!");
	        model.addAttribute("url", "/list");
		}else {
			model.addAttribute("msg", "남의 글 삭제 안됨!");
	        model.addAttribute("url", "/list");
		}
		
		
	}

}
