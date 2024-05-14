package boilerPlateEgov.test.service.impl;

import java.util.List;

import javax.annotation.Resource;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Service;

import boilerPlateEgov.test.service.testService;
import boilerPlateEgov.test.service.testVO;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("testService")
public class testServiceImpl extends EgovAbstractServiceImpl implements testService{
	
	@Resource(name = "testDAO")
	private testDAO testDAO;
	
	public List<EgovMap> selectAll() {
		return testDAO.selectAll();
	}
	
	public void insert(testVO vo) {
		testDAO.insert(vo);
	}

}
