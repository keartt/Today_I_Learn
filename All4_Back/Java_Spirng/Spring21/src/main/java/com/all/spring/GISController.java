package com.all.spring;

import java.util.Locale;

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


@Controller
public class GISController {

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
	@RequestMapping(value = "/save-coordinate", method = RequestMethod.POST)
    public String saveCoordinate(@RequestParam Double x, @RequestParam Double y) {
        mapService.saveCoordinate(x, y);
        return "success";
    }
	
}