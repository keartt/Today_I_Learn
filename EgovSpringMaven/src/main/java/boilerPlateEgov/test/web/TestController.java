package boilerPlateEgov.test.web;

import java.util.List;

import javax.annotation.Resource;

import egovframework.rte.fdl.cmmn.exception.FdlException;
import egovframework.rte.fdl.idgnr.EgovIdGnrService;
import egovframework.rte.psl.dataaccess.util.EgovMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import boilerPlateEgov.test.service.testService;
import boilerPlateEgov.test.service.testVO;

@Controller
@RequestMapping("test")
public class TestController {
	
	@Resource
	MappingJackson2JsonView ajaxMainView;
	
	@Resource(name = "testService")
	private testService testService;

	@Resource(name = "idGenTest")
	private EgovIdGnrService idGen;

	private static final Logger LOGGER = LoggerFactory.getLogger(TestController.class);

	@RequestMapping("/insert.do")
	public String testInsert(Model model, @RequestBody testVO vo) throws FdlException {
		LOGGER.info("{}거 들어옴", vo);
		vo.setTestId(idGen.getNextStringId());
		testService.insert(vo);
		model.addAttribute("page", "test.do");
		return "jsonView";
	}

	@RequestMapping("/selectAll.do")
	public String testSelect(Model model) {
		List<EgovMap> voList = testService.selectAll();
		model.addAttribute("testdb", voList);
		return "jsonView";
	}
}
