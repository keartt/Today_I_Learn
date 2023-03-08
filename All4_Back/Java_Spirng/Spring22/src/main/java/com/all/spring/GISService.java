

package com.all.spring;

import java.time.LocalTime;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Service;
import com.all.spring.dao.GDao;

@Service
public class GISService {
	
	public void copyGISData(SqlSession sqlSession) {
		LocalTime now = LocalTime.now();
        System.out.println("copyGISData call! : " + now);
        GDao dao = sqlSession.getMapper(GDao.class);
		Integer rtn = dao.copyData();
		System.out.println("test :  " + rtn);
	}
}
