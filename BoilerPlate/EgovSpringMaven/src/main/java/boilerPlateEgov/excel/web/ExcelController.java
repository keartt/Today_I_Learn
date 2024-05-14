package boilerPlateEgov.excel.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import boilerPlateEgov.excel.service.ExcelService;

@Controller
public class ExcelController {
	@Resource
	MappingJackson2JsonView ajaxMainView;
	
	@Resource(name = "excelService")
	private ExcelService service;
	
	@RequestMapping("excel.do")
	public String test(Model model) {
		String testCount = service.test();
		model.addAttribute("out", testCount);
		return "jsonView";
	}

}
