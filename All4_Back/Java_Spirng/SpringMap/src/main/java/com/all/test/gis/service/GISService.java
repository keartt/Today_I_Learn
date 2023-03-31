package com.all.test.gis.service;

import org.apache.ibatis.session.SqlSession;

public interface GISService {
	public void copyGISData(SqlSession sqlSession);
}
