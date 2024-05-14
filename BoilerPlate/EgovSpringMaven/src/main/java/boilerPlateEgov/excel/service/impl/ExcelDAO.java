package boilerPlateEgov.excel.service.impl;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractMapper;

@Repository("excelDAO")
public class ExcelDAO extends EgovAbstractMapper{

	/**
	 * if you want another session and using second Database
	 * follow under line code
	 * @param sqlSession
	 */
	@Resource(name = "sqlSession2")
    public void setSqlSessionFactory(SqlSessionFactory sqlSession) {
    	super.setSqlSessionFactory(sqlSession);
    }
	
	public String test() {
		return selectOne("testdev");
	}
}
