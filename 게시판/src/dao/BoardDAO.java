package dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import entity.BoardEntity;

public class BoardDAO {

	Connection con;
	public BoardDAO(Connection con) {
		this.con = con;
	}
	
	// 글 수정
	public boolean update(BoardEntity entity) {
		boolean result = false;
		
		try {
			String sql = "update board set articleTitle=?, articleContent=? where articleNum=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, entity.getArticleTitle());
			pstmt.setString(2, entity.getArticleContent());
			pstmt.setInt(3, entity.getArticleNum());
			
			int count = pstmt.executeUpdate();
			
			//System.out.println(count);
			
			if(count >= 1) {
				result = true;
			} else {
				result = false;
			}
			
			pstmt.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean delete(BoardEntity entity) {
		boolean result = false;
		
		
		try {
			// SQL 문장을 만들어서 PreparedStatement 생성
			String sql = "delete from board where articleNum=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, entity.getArticleNum());
			
			int count = pstmt.executeUpdate();
			
			
			
			if(count == 1) {
				result = true;
			} else {
				result = false;
			}
			
			pstmt.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean select(String uid, String upw) {
		boolean result = false;
		
		try {
		// SQL 문장을 만들어서 PreparedStatement 생성
			String sql = "select * from board_user where uid=? and upw=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, uid);
			pstmt.setString(2, upw);
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				result = true;
 			} else {
 				result = false;
 			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public BoardEntity selectByNum(BoardEntity entity) {
		BoardEntity article = new BoardEntity();
		
		try {
			// SQL 문장을 만들어서 PreparedStatement 생성
			String sql = "select articleNum, articleTitle, articleContent, articleWriter, articleDate from board where articleNum=?";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, entity.getArticleNum());
			
			ResultSet rs = pstmt.executeQuery();
			
			if(rs.next()) {
				article.setArticleNum(rs.getInt("articleNum"));
				article.setArticleTitle(rs.getString("articleTitle"));
				article.setArticleContent(rs.getString("articleContent"));
				article.setArticleWriter(rs.getString("articleWriter"));
				article.setArticleDate(rs.getString("articleDate"));
			} 
			
			pstmt.close();
			rs.close();
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
		return article;
	}
	
	public ArrayList<BoardEntity> select() {
		ArrayList<BoardEntity> list = new ArrayList<BoardEntity>();
		
		try {			
			// SQL 문장을 만들어서 PreparedStatement 생성
			String sql = "select articleNum, articleTitle, articleContent, articleWriter, articleDate from board";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				BoardEntity entity = new BoardEntity();
				entity.setArticleNum(rs.getInt("articleNum"));
				entity.setArticleTitle(rs.getString("articleTitle"));
				entity.setArticleWriter(rs.getString("articleWriter"));
				entity.setArticleDate(rs.getString("articleDate"));
				
				list.add(entity);
			}
			

			
			pstmt.close();
			rs.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	public boolean insert(BoardEntity entity) {
		boolean result = false;
		
		
		try {
			Connection con = common.DBTemplate.getConnection();
			
			// SQL 문장을 만들어서 PreparedStatement 생성
			String sql = "select MAX(articleNum) from board";
			PreparedStatement pstmt = con.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			rs.next();
			int num = rs.getInt(1) + 1;
			
			sql = "insert into board values(?,?,?,?,?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, num);
			pstmt.setString(2, entity.getArticleTitle());
			pstmt.setString(3, entity.getArticleContent());
			pstmt.setString(4, entity.getArticleWriter());
			pstmt.setString(5, entity.getArticleDate());
			
			int count = pstmt.executeUpdate();
			
			
			
			if(count == 1) {
				result = true;
				con.commit();
			} else {
				result = false;
				con.rollback();
			}
			
			pstmt.close();
			rs.close();
			con.close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return result;
	}
}
