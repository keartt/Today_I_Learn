package com.all.spring.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementCreator;
import org.springframework.jdbc.core.PreparedStatementSetter;

import com.all.spring.dto.BDto;
import com.all.spring.util.Constant;

public class BDao {

   JdbcTemplate template;
   
   public BDao() {
      this.template = Constant.template;
   }
   
   public void write(final String bName, final String bTitle, final String bContent) {
      this.template.update(new PreparedStatementCreator() {
         
         @Override
         public PreparedStatement createPreparedStatement(Connection con)
               throws SQLException {
            String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (nextval('mvc_board_seq'), ?, ?, ?, 0, currval('mvc_board_seq'), 0, 0 )";
            PreparedStatement pstmt = con.prepareStatement(query);
            pstmt.setString(1, bName);
            pstmt.setString(2, bTitle);
            pstmt.setString(3, bContent);
            return pstmt;
         }
      });
   }
   
   public ArrayList<BDto> list() {
      
      String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
      return (ArrayList<BDto>) template.query(query, new BeanPropertyRowMapper<BDto>(BDto.class));
      
   }
   
   public BDto contentView(int strID) {
      upHit(strID);
      
      String query = "select * from mvc_board where bId = " + strID;
      return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
      
   }
   
   public void modify(final String bId, final String bName, final String bTitle, final String bContent) {
      String query = "update mvc_board set bName = ?, bTitle = ?, bContent = ? where bId = ?";
      
      this.template.update(query, new PreparedStatementSetter() {
         
         @Override
         public void setValues(PreparedStatement ps) throws SQLException {
            ps.setString(1, bName);
            ps.setString(2, bTitle);
            ps.setString(3, bContent);
            ps.setInt(4, Integer.parseInt(bId));
         }
      });
      
   }
   
   public void delete(final int bId) {
      String query = "delete from mvc_board where bId=?";
      
      this.template.update(query, new PreparedStatementSetter() {
         
         @Override
         public void setValues(PreparedStatement ps) throws SQLException {
            ps.setInt(1, bId);
         }
      });
      
   }
   
   public BDto reply_view(int str) {
      String query = "select * from mvc_board where bId = " + str;
      return template.queryForObject(query, new BeanPropertyRowMapper<BDto>(BDto.class));
      
   }
   
   public void reply(final int bId, final String bName, final String bTitle, final String bContent, final String bGroup, final String bStep, final String bIndent) {
	   replyShape(bGroup, bStep);
      
      String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (nextval('mvc_board_seq'), ?, ?, ?, ?, ?, ?)";
      
      this.template.update(query, new PreparedStatementSetter() {
         
         @Override
         public void setValues(PreparedStatement ps) throws SQLException {
            ps.setString(1, bName);
            ps.setString(2, bTitle);
            ps.setString(3, bContent);
            ps.setInt(4, Integer.parseInt(bGroup));
            ps.setInt(5, Integer.parseInt(bStep) + 1);
            ps.setInt(6, Integer.parseInt(bIndent) + 1);
         }
      });
      
   }
   
   private void replyShape( final String strGroup, final String strStep) {
      String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
      
      this.template.update(query, new PreparedStatementSetter() {
         
         @Override
         public void setValues(PreparedStatement ps) throws SQLException {
            ps.setInt(1, Integer.parseInt(strGroup));
            ps.setInt(2, Integer.parseInt(strStep));
         }
      });
   }
   
   private void upHit(final int bId) {
      
      String query = "update mvc_board set bHit = bHit + 1 where bId = ?";
      this.template.update(query, new PreparedStatementSetter() {
         
         @Override
         public void setValues(PreparedStatement ps) throws SQLException {
            ps.setInt(1, bId);
         }
      });
      
   }
}