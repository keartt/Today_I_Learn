package com.all.spring.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.BDao;

public class BDeleteCommand implements Command {

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		BDao dao = new BDao();
		dao.delete(bId);
	}

}
