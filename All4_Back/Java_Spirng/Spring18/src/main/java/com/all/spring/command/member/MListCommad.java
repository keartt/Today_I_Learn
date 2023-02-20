package com.all.spring.command.member;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.all.spring.dao.MDao;
import com.all.spring.dto.MDto;

public class MListCommad implements MCommand{

	@Override
	public void execute(Model model) {
		MDao mDao = new MDao();
		ArrayList<MDto> dtos = mDao.list();
		
		model.addAttribute("user_list",dtos);
		
	}

}
