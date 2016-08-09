package service;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.BoardDAO;
import entity.BoardEntity;

// 로직처리하기 위한 클래스
public class BoardService {

	public BoardService() {
		// TODO Auto-generated constructor stub
	}
	
	public boolean login(String uid, String upw) {
		
		boolean result = false;
		Connection con =  common.DBTemplate.getConnection();
		BoardDAO dao = new BoardDAO(con);
		result = dao.select(uid, upw);
		try {
			if(result) {
				con.commit();
			} else {
				con.rollback();
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 글 삭제 처리
	public boolean deleteArticle(BoardEntity entity) {
		boolean result = false;
		// DAO를 이용해서 DB처리
		Connection con =  common.DBTemplate.getConnection();
		BoardDAO dao = new BoardDAO(con);
		result = dao.delete(entity);
		
		try {
			if(result) {
				con.commit();
			} else {
				con.rollback();
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 글 등록 처리
	public boolean registerArticle(BoardEntity entity) {
		boolean result = false;
		// DAO를 이용해서 DB처리
		Connection con =  common.DBTemplate.getConnection();
		
		BoardDAO dao = new BoardDAO(con);
		result = dao.insert(entity);
		
		try {
			if(result) {
				con.commit();
			} else {
				con.rollback();
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	// 글 수정 처리
	public boolean editArticle(BoardEntity entity) {
		boolean result = false;
		
		Connection con =  common.DBTemplate.getConnection();
		BoardDAO dao = new BoardDAO(con);
		result = dao.update(entity);
		
		try {
			if(result) {
				con.commit();
			} else {
				con.rollback();
			}
			
			con.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
	}
	
	public BoardEntity searchArticleByNum(BoardEntity entity) {
		Connection con =  common.DBTemplate.getConnection();
		BoardDAO dao = new BoardDAO(con);
		BoardEntity result = dao.selectByNum(entity);
		
		con.close();
		
		return result;
	}
	
	// 글 목록 출력하기 위해서 글 목록에 대한 ArrayList를 가져오는 metho
	public ArrayList<BoardEntity> searchArticle() {
		Connection con =  common.DBTemplate.getConnection();
		BoardDAO dao = new BoardDAO(con);
		ArrayList<BoardEntity> list = dao.select();
		
		con.close();
		
		return list;
	}
}
