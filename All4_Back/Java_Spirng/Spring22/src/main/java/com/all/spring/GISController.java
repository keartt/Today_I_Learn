package com.all.spring;

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

import com.all.spring.dao.GDao;


@Controller
public class GISController {
	@Autowired
	private SqlSession sqlSession;

	private static final Logger logger = LoggerFactory.getLogger(GISController.class);

	@RequestMapping(value = "/gisMain", method = RequestMethod.GET)
	public String gisMain(Locale locale, Model model) {
		return "/gisMain";
	}
	
	@RequestMapping(value = "/gisTest", method = RequestMethod.GET)
	public String gisTest(Locale locale, Model model) {
		return "/gisTest";
	}
	
	
	@Autowired
	MapService mapService;
	@ResponseBody
	@RequestMapping(value = "/save-coordinate", method = RequestMethod.POST)
    public String saveCoordinate(@RequestParam Double x, @RequestParam Double y) {
        mapService.saveCoordinate(x, y);
        return "success";
    }

	@RequestMapping(value = "/view-coordinate", method = RequestMethod.GET)
	public ModelAndView viewCoordinate(HttpServletRequest request) {
		System.out.println("1" + sqlSession);

		GDao dao = sqlSession.getMapper(GDao.class);
		ArrayList<HashMap<?, ?>> rtn = dao.viewCoordinate();
		
		ModelAndView model = new ModelAndView();
		model.addObject("rtn", rtn);
		System.out.println("2" +rtn);
		model.setViewName("jsonView");
		
		return model;
	}
	
}