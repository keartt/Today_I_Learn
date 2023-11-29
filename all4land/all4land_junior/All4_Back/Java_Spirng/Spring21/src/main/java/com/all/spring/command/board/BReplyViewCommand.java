package com.all.spring.command.board;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.BDao;
import com.all.spring.dto.BDto;
@Service("BReplyViewCommand")
public class BReplyViewCommand implements Command {
	@Autowired
	SqlSession sqlSession;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bId =Integer.parseInt(request.getParameter("bId"));
		
		BDao bDao = sqlSession.getMapper(BDao.class);
		BDto dto = new BDto();
		dto = bDao.reply_view(bId);

		model.addAttribute("reply_view",dto);
	}
}
