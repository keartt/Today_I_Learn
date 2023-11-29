package com.all.spring.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.BDao;
import com.all.spring.dto.BDto;

public class BReplyViewCommand implements Command {
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bId =Integer.parseInt(request.getParameter("bId"));
		
		BDao dao = new BDao();
		BDto dto = new BDto();
		
		
		dto = dao.reply_view(bId);

		model.addAttribute("reply_view",dto);
	}
}
