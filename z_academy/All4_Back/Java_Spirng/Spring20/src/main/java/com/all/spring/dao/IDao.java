package com.all.spring.dao;

import java.util.ArrayList;

import com.all.spring.dto.ContentDto;

public interface IDao {
	
	public ArrayList<ContentDto> listDao();
	public void writeDao(String mWriter, String mContetnt);
	public ContentDto viewDao(String strID);
	public void deleteDao(String bId);
}
