package com.all.spring.dao;

import java.util.ArrayList;
import java.util.HashMap;

import org.apache.ibatis.annotations.Param;

public interface GDao {

	public void saveCoordinate (@Param("x") double x, @Param("y") double y) ;
	
	public ArrayList<HashMap< ? , ?>> viewCoordinate();
	
}
