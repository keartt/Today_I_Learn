package com.all.spring.command.member;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.MDao;
import com.all.spring.dto.MDto;

@Service("MListCommad")
public class MListCommad implements Command{
	@Autowired
	SqlSession sqlSession;
	@Override
	public void execute(Model model) {
		MDao dao = sqlSession.getMapper(MDao.class);
		ArrayList<MDto> dtos = dao.list();
		
		model.addAttribute("user_list",dtos);
		
	}

}
