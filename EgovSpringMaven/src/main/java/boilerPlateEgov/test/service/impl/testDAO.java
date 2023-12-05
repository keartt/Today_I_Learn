package boilerPlateEgov.test.service.impl;

import java.util.List;

import egovframework.rte.psl.dataaccess.util.EgovMap;
import org.springframework.stereotype.Repository;

import boilerPlateEgov.test.service.testVO;
import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("testDAO")
public class testDAO extends EgovAbstractMapper{
	
	public List<EgovMap> selectAll() {
		return selectList("testSelectAll");
	}

	public void insert(testVO vo) {
		insert("testInsert", vo);
	}
}
