package com.all.test.gis.dao;

import java.util.ArrayList;
import java.util.HashMap;

public interface GISMapper {
	
	//좌표 등록
	public Integer regTargetPoint(Double coordX, Double coordY);
	//등록 좌표 조회
	public ArrayList<HashMap<?,?>> regTargetPointSearch();
	//testlayer2 좌표 복사
	public Integer copyGISData(); 

}
