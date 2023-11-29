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
@Service("BContentCommand")
public class BContentCommand implements Command {
	@Autowired
	SqlSession sqlSession;
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		int bId = Integer.parseInt(request.getParameter("bId"));
		
		BDao bDao = sqlSession.getMapper(BDao.class);
		bDao.upHit(bId);
		BDto bdto = bDao.contentView(bId);
		model.addAttribute("content_view", bdto); 
	}
	

}
