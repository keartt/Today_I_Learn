package net.board.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BoardDAO {
	Connection con;
	PreparedStatement pstmt;
	ResultSet rs;
	
	// 커넥션 풀.. 디비 연결
	 public BoardDAO() {
	        try{
	            Context init = new InitialContext();
	              DataSource ds = (DataSource) init.lookup("java:comp/env/jdbc/OracleDB");
	              con = ds.getConnection();
	        }catch(Exception ex){
	            System.out.println("DB 연결 실패 : " + ex);
	            return;
	        }
	 }
	 
	 // 리스트 갯수를 받아와서 보드리스트 액션으로 ~
	 public int getListCount(){
		 int x= 0;
			
			try{
				pstmt=con.prepareStatement("select count(*) from board");
				rs = pstmt.executeQuery();
				
				if(rs.next()){
					x=rs.getInt(1);
				}
			}catch(Exception ex){
				System.out.println("getListCount 에러: " + ex);			
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			}
			return x;
	 }
	 
	 // 
	 public List getBoardList(int page,int limit){
			String board_list_sql="select * from "+
			"(select rownum rnum,BOARD_NUM,BOARD_NAME,BOARD_SUBJECT,"+
			"BOARD_CONTENT,BOARD_FILE,BOARD_RE_REF,BOARD_RE_LEV,"+
			"BOARD_RE_SEQ,BOARD_READCOUNT,BOARD_DATE from "+
			"(select * from board order by BOARD_RE_REF desc,BOARD_RE_SEQ asc)) "+
			"where rnum>=? and rnum<=?";
			
			List list = new ArrayList();
			
			int startrow=(page-1)*10+1; //읽기 시작할 row번호
			int endrow=startrow+limit-1; //읽기 마지막 row번호.
			try{
				pstmt = con.prepareStatement(board_list_sql);
				pstmt.setInt(1, startrow);
				pstmt.setInt(2, endrow);
				rs = pstmt.executeQuery();
				
				while(rs.next()){
					BoardBean board = new BoardBean();
					board.setBOARD_NUM(rs.getInt("BOARD_NUM"));
					board.setBOARD_NAME(rs.getString("BOARD_NAME"));
					board.setBOARD_SUBJECT(rs.getString("BOARD_SUBJECT"));
					board.setBOARD_CONTENT(rs.getString("BOARD_CONTENT"));
					board.setBOARD_FILE(rs.getString("BOARD_FILE"));
					board.setBOARD_RE_REF(rs.getInt("BOARD_RE_REF"));
					board.setBOARD_RE_LEV(rs.getInt("BOARD_RE_LEV"));
					board.setBOARD_RE_SEQ(rs.getInt("BOARD_RE_SEQ"));
					board.setBOARD_READCOUNT(rs.getInt("BOARD_READCOUNT"));
					board.setBOARD_DATE(rs.getDate("BOARD_DATE"));
					list.add(board);
				}
				
				return list;
			}catch(Exception ex){
				System.out.println("getBoardList 에러 : " + ex);
			}finally{
				if(rs!=null) try{rs.close();}catch(SQLException ex){}
				if(pstmt!=null) try{pstmt.close();}catch(SQLException ex){}
			}
			return null;
		}
	 
	 

}
