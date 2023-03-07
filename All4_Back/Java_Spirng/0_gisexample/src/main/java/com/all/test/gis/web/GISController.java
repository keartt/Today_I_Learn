package com.all.test.gis.web;

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
import org.springframework.web.servlet.ModelAndView;

import com.all.test.gis.dao.GISMapper;

@Controller
public class GISController {

	private static final Logger logger = LoggerFactory.getLogger(GISController.class);

	@Autowired
	private SqlSession sqlSession; // servlet에 설정한 이름과 같으므로 setDao 안 만들어도 쓸 수 있음!

	@RequestMapping(value = "/gisMain", method = RequestMethod.GET)
	public String gisMain(Locale locale, Model model) {
		return "gisMain";
	}
	
	@RequestMapping(value = "/regPoint", method = RequestMethod.GET)
	public ModelAndView regPoint(HttpServletRequest request) {
		GISMapper dao = sqlSession.getMapper(GISMapper.class);
		Double x = Double.parseDouble(request.getParameter("coordX"));
		Double y = Double.parseDouble(request.getParameter("coordY"));
		
		Integer rtn = dao.regTargetPoint(x, y);
		
		ModelAndView model = new ModelAndView();
		model.addObject("rtn", rtn);
		model.setViewName("jsonView");
		
		return model;
	}
	
	@RequestMapping(value = "/regPointSearch", method = RequestMethod.GET)
	public ModelAndView regPointSearch(HttpServletRequest request) {
		GISMapper dao = sqlSession.getMapper(GISMapper.class);
		ArrayList<HashMap<?, ?>> rtn = dao.regTargetPointSearch();
		
		ModelAndView model = new ModelAndView();
		model.addObject("rtn", rtn);
		model.setViewName("jsonView");
		
		return model;
	}
}