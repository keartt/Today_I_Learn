package com.all.spring.dao;

import java.util.ArrayList;

import org.apache.ibatis.annotations.Param;

import com.all.spring.dto.BDto;

public interface BDao {

	public BDto contentView(@Param("bId") int bId);
	public void upHit(@Param("bId") int bId);

	
	public void reply(@Param("bId") int bId, @Param("bName") String bName, @Param("bTitle") String bTitle,
			@Param("bContent") String bContent, @Param("bGroup") int bGroup, @Param("bStep") int bStep,
			@Param("bIndent") int bIndent);
	public void replyShape(@Param("bGroup") int bGroup, @Param("bStep") int bStep);

	
	public void write(@Param("bName") String bName, @Param("bTitle") String bTitle,
			@Param("bContent") String bContent, @Param("file") String file);

	public ArrayList<BDto> list();

	public void modify(@Param("bId") int bId, @Param("bName") String bName, @Param("bTitle") String bTitle,
			@Param("bContent") String bContent, @Param("file") String file);

	public void delete(@Param("bId") int bId);

	public BDto reply_view(@Param("bId") int bId);

}
