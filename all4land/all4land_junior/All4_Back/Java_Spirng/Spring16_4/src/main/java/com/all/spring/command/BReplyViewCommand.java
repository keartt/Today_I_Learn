package com.all.spring.command;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.all.spring.dao.BDao;
import com.all.spring.dto.BDto;

public class BReplyViewCommand implements BCommand {
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bId =Integer.parseInt(request.getParameter("bId"));
		
		BDao dao = new BDao();
		BDto dto = new BDto();
		dto = dao.getBDto(bId);
		model.addAttribute("reply_view",dto);
	}
}
