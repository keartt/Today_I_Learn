package com.all.test.gis.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.ibatis.session.SqlSession;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.all.test.gis.dao.GISMapper;

@Controller
public class GISController {

	private static final Logger logger = LoggerFactory.getLogger(GISController.class);

	@Autowired
	private SqlSession sqlSession; 

	@RequestMapping(value = "/gisTest", method = RequestMethod.GET)
	public String gisTest(Locale locale, Model model) {
		return "gisTest";
	}

	@ResponseBody
	@RequestMapping(value = "/save-coordinate", method = RequestMethod.POST)
	public String saveCoordinate(@RequestParam Double x, @RequestParam Double y) {

		GISMapper dao = sqlSession.getMapper(GISMapper.class);
		dao.saveCoordinate(x, y);

		return "success";

	}

	@RequestMapping(value = "/view-coordinate", method = RequestMethod.GET)
	public ModelAndView viewCoordinate(HttpServletRequest request) {
		GISMapper dao = sqlSession.getMapper(GISMapper.class);
		ArrayList<HashMap<?, ?>> rtn = dao.viewCoordinate();

		ModelAndView model = new ModelAndView();
		model.addObject("rtn", rtn);
		model.setViewName("jsonView");

		return model;
	}
}