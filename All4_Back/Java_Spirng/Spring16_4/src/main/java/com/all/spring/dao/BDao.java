package com.all.spring.dao;

import java.sql.*;
import javax.sql.*;
import javax.naming.*;

import com.all.spring.dto.BDto;
import java.util.ArrayList;

public class BDao {
	DataSource dataSource;
	Connection connection = null;
	PreparedStatement preparedStatement = null;
	ResultSet resultSet = null;

	public BDao() {
		try {
			Context init = new InitialContext();
			dataSource = (DataSource) init.lookup("java:comp/env/jdbc/postgreSQL");

			System.out.println("db 연결성공 bdao");

		} catch (Exception e) {
			System.out.println("db 연결실패 bdao");
			e.printStackTrace();
		}
	}

	// 전체조회
	public ArrayList<BDto> list() {

		ArrayList<BDto> dtos = new ArrayList<BDto>();
		try {
			connection = dataSource.getConnection();

			String query = "select bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent from mvc_board order by bGroup desc, bStep asc";
			preparedStatement = connection.prepareStatement(query);
			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				int bId = resultSet.getInt("bId");
				String bName = resultSet.getString("bName");
				String bTitle = resultSet.getString("bTitle");
				String bContent = resultSet.getString("bContent");
				Timestamp bDate = resultSet.getTimestamp("bDate");
				int bHit = resultSet.getInt("bHit");
				int bGroup = resultSet.getInt("bGroup");
				int bStep = resultSet.getInt("bStep");
				int bIndent = resultSet.getInt("bIndent");

				BDto dto = new BDto(bId, bName, bTitle, bContent, bDate, bHit, bGroup, bStep, bIndent);
				dtos.add(dto);
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return dtos;
	}

	// 작성
	public void write(String bName, String bTitle, String bContent) {

		try {
			connection = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bHit, bGroup, bStep, bIndent) values (nextval('mvc_board_seq'), ?, ?, ?, 0, currval('mvc_board_seq'), 0, 0 )";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			int rn = preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}

	}

	// 조회
	public BDto getBDto(int id) {
		System.out.println("조회 dao 진입");
		BDto bDto = new BDto();
		try {
			connection = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);

			resultSet = preparedStatement.executeQuery();

			while (resultSet.next()) {
				bDto.setbId(resultSet.getInt("bId"));
				bDto.setbName(resultSet.getString("bName"));
				bDto.setbTitle(resultSet.getString("bTitle"));
				bDto.setbContent(resultSet.getString("bContent"));
				bDto.setbDate(resultSet.getTimestamp("bDate"));
				bDto.setbHit(resultSet.getInt("bHit"));
				bDto.setbGroup(resultSet.getInt("bGroup"));
				bDto.setbStep(resultSet.getInt("bStep"));
				bDto.setbIndent(resultSet.getInt("bIndent"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null)
					resultSet.close();
				if (preparedStatement != null)
					preparedStatement.close();
				if (connection != null)
					connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bDto;
	}

	// 수정

	public void modify(String bId, String bName, String bTitle, String bContent) {
		System.out.println("수정 dao 진입");
		try {
			connection = dataSource.getConnection();
			String query = "update mvc_board set bName = ?,bTitle = ?, bContent = ? where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bId));
		} catch (Exception e) {
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

	}

	public void delete(String bId) {
		System.out.println("삭제 dao 진입");
		try {
			connection = dataSource.getConnection();
			String query = "delete from mvc_board where bId=?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(bId));
			preparedStatement.executeUpdate();
		} catch (Exception e) {
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	// 답변 .. 일단 조회랑 동일함
	public BDto reply_view(String id) {
		BDto bDto = new BDto();
		try {
			connection = dataSource.getConnection();
			String query = "select * from mvc_board where bId = ?";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setInt(1, Integer.parseInt(id));
			resultSet = preparedStatement.executeQuery();
			
			if(resultSet.next()) {
				bDto.setbId(resultSet.getInt("bId"));
				bDto.setbName(resultSet.getString("bName"));
				bDto.setbTitle(resultSet.getString("bTitle"));
				bDto.setbContent(resultSet.getString("bContent"));
				bDto.setbDate(resultSet.getTimestamp("bDate"));
				bDto.setbHit(resultSet.getInt("bHit"));
				bDto.setbGroup(resultSet.getInt("bGroup"));
				bDto.setbStep(resultSet.getInt("bStep"));
				bDto.setbIndent(resultSet.getInt("bIndent"));
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		return bDto;
	}
	
	public void reply(String bId, String bName, String bTitle, String bContent, String bGroup, String bStep, String bIndent) {
		replyShape(bGroup, bStep);
		
		Connection connection = null;
		PreparedStatement preparedStatement = null;
		
		try {
			connection = dataSource.getConnection();
			String query = "insert into mvc_board (bId, bName, bTitle, bContent, bGroup, bStep, bIndent) values (nextval('mvc_board_seq'), ?, ?, ?, ?, ?, ?)";
			preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, bName);
			preparedStatement.setString(2, bTitle);
			preparedStatement.setString(3, bContent);
			preparedStatement.setInt(4, Integer.parseInt(bGroup));
			preparedStatement.setInt(5, Integer.parseInt(bStep) + 1);
			preparedStatement.setInt(6, Integer.parseInt(bIndent) + 1);
			
			preparedStatement.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
	}
	
	private void replyShape( String strGroup, String strStep) {
		try {
			connection = dataSource.getConnection();
			String query = "update mvc_board set bStep = bStep + 1 where bGroup = ? and bStep > ?";
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, Integer.parseInt(strGroup));
			preparedStatement.setInt(2, Integer.parseInt(strStep));

			preparedStatement.executeUpdate();

		} catch (Exception e) {

			e.printStackTrace();

		} finally {

			try {
				if(preparedStatement != null) preparedStatement.close();
				if(connection != null) connection.close();

			} catch (Exception e2) {

				e2.printStackTrace();

			}
		}
	}
	
	


}