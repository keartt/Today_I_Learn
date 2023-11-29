package com.all.spring.command;

import java.util.ArrayList;

import org.springframework.ui.Model;

import com.all.spring.dao.BDao;
import com.all.spring.dto.BDto;

public class BListCommand implements BCommand {

	@Override
	public void execute(Model model) {
		BDao dao = new BDao();
		ArrayList<BDto> dtos = dao.list();
		
		model.addAttribute("list",dtos);
	}

}
