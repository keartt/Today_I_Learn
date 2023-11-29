package com.all.test.gis.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

public interface GISMapper {
	public void saveCoordinate (@Param("x") double x, @Param("y") double y) ;
	public ArrayList<HashMap<?,?>> viewCoordinate();
	public Integer copyGISData(); 
}
