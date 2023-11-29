package com.all.spring.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.BDao;
@Service("BModifyCommand")
public class BModifyCommand implements Command{
	@Autowired
	SqlSession sqlSession;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int bId =Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		String file = request.getParameter("file");
		
	    HttpSession session = request.getSession();  
	    String user_id = (String) session.getAttribute("user_id");  
		
		// 세션에 저장된 아이디랑 게시글 작성자랑 같다면 
		if (user_id.equals(bName)) {
			BDao bDao = sqlSession.getMapper(BDao.class);
			bDao.modify(bId, bName, bTitle, bContent, file);
			
			model.addAttribute("msg", "수정함!");
	        model.addAttribute("url", "/list");
		// 아니면 삭제 불가 
		}else {
			model.addAttribute("msg", "남의 글 수정 불가");
	        model.addAttribute("url", "/list");
		}
		
		
		
	}
}
