package com.all.spring.command.board;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.BDao;

@Service("BReplyCommand")
public class BReplyCommand implements Command {
	@Autowired
	SqlSession sqlSession;

	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");

		int bId = Integer.parseInt(request.getParameter("bId"));
		String bName = request.getParameter("bName");
		String bTitle = request.getParameter("bTitle");
		String bContent = request.getParameter("bContent");
		int bGroup = Integer.parseInt(request.getParameter("bGroup"));
		int bStep = Integer.parseInt(request.getParameter("bStep"));
		int bIndent = Integer.parseInt(request.getParameter("bIndent"));

		BDao bDao = sqlSession.getMapper(BDao.class);
		bDao.replyShape(bGroup, bStep);
		bDao.reply(bId, bName, bTitle, bContent, bGroup, bStep + 1, bIndent + 1);
	}
}