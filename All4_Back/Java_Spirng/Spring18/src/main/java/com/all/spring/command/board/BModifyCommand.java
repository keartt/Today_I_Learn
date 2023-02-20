package com.all.spring.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.BDao;

public class BModifyCommand implements Command{

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		String bId = request.getParameter("bId");
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		
		// HttpSession 객체 가져오기
	    HttpSession session = request.getSession();  
	    // HttpSession 객체에서 "user_id" 가져오기
	    String user_id = (String) session.getAttribute("user_id");  
		System.out.println("2" + user_id);
		
		// 세션에 저장된 아이디랑 게시글 작성자랑 같다면 
		if (user_id.equals(bName)) {
			BDao dao = new BDao();
			dao.modify(bId, bName, bTitle, bContent);
			
			model.addAttribute("msg", "수정함!");
	        model.addAttribute("url", "/list");
		// 아니면 삭제 불가 
		}else {
			model.addAttribute("msg", "남의 글 수정 불가");
	        model.addAttribute("url", "/list");
		}
		
		
		
	}
}
