package boilerPlateEgov.excel.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import boilerPlateEgov.excel.service.ExcelService;
import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

@Service("excelService")
public class ExcelServiceImpl extends EgovAbstractServiceImpl implements ExcelService{
	
	@Resource(name="excelDAO")
	private ExcelDAO dao;
	
	public String test() {
		return dao.test();
	}
}
