package com.all.spring.dao;

import org.apache.ibatis.annotations.Param;

public interface GDao {

	public void saveCoordinate (@Param("x") double x, @Param("y") double y) ;
	
}
