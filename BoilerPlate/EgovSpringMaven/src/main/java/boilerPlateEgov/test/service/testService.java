package boilerPlateEgov.test.service;

import egovframework.rte.psl.dataaccess.util.EgovMap;

import java.util.List;

public interface testService {
	public List<EgovMap> selectAll();
	public void insert(testVO vo);
}
