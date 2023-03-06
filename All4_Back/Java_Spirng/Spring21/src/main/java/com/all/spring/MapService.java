package com.all.spring;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.all.spring.dao.GDao;

@Service("MapService")
public class MapService {
	@Autowired
	SqlSession sqlSession;
	
	 public void saveCoordinate(Double x, Double y) {
		 System.out.println(sqlSession);
		 GDao dao = sqlSession.getMapper(GDao.class);
		 dao.saveCoordinate(x, y);
	    }
}
