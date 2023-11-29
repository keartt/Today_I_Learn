package com.all.spring.command.board;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.all.spring.command.Command;
import com.all.spring.dao.BDao;
import com.all.spring.dto.BDto;
@Service("BListCommand")
public class BListCommand implements Command {
	@Autowired
	SqlSession sqlSession;
	@Override
	public void execute(Model model) {
		BDao bDao = sqlSession.getMapper(BDao.class);
		ArrayList<BDto> dtos = bDao.list();
		
		model.addAttribute("list",dtos);
	}

}
