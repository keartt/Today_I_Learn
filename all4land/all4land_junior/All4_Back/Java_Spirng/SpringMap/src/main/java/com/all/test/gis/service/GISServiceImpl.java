package com.all.test.gis.service;

import java.time.LocalTime;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import com.all.test.gis.dao.GISMapper;

@Service
public class GISServiceImpl implements GISService{
	
	public void copyGISData(SqlSession sqlSession) {
		GISMapper dao = sqlSession.getMapper(GISMapper.class);
		Integer rtn = dao.copyGISData();
		System.out.println("스케쥴러에 의해 복사됨 : " + rtn);
	}
}
