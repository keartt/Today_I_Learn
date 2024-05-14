package com.all.spring.command.member;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.MDao;
import com.all.spring.dto.MDto;

@Service("MyPageViewCommand")
public class MyPageViewCommand implements Command {
	@Autowired
	SqlSession sqlSession;
	
	@Override
	public void execute(Model model) {
		Map<String, Object> map = model.asMap();
		HttpServletRequest request = (HttpServletRequest) map.get("request");
		
		MDao dao = sqlSession.getMapper(MDao.class);
		MDto dto = dao.memberView(request.getParameter("user_id"));
		model.addAttribute("member", dto);
	}
}
