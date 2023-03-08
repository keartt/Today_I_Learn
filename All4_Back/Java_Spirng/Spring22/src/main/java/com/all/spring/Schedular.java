package com.all.spring;



import org.apache.ibatis.session.SqlSession;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

import com.all.spring.GISService;

public class Schedular {

	private GISService gisService;

	private SqlSession sqlSession;
	
	public void setGisService(GISService gisService) {
		this.gisService = gisService;
	}
	
	public void setSqlSession(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}
	 

	protected void executeInternal(JobExecutionContext context) throws JobExecutionException {
		gisService.copyGISData(sqlSession);
	}
}