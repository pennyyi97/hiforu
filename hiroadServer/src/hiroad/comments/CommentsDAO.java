package hiroad.comments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class CommentsDAO {
	private Connection conn;
	
	public CommentsDAO(){
		try{
			//1 driver loading
			Class.forName("com.mysql.jdbc.Driver");
			//2 DB연결(드라이버 매니저를 통해 커넥션을 연결한다.
			String url = "jdbc:mysql://128.134.114.237:3306/db216230043";
			String id = "216230043";
			String pw = "rudqls9700!";
			conn = DriverManager.getConnection(url, id, pw);
		}catch(Exception e){
			e.printStackTrace(); //혹시 예외발생했을 때 경로를 제공해주는 메소드
		}//catch
	}
	
	/**댓글목록 삭제
	
	
	public CommentsVO commentLists(int boardNum) {
		PreparedStatement pstmt;
		ResultSet rs;
		CommentsVO vo = null;
		
		
		String sql = "select comment_num, comment_contents, comment_name, comments.date"
				+ " from comments, board"
				+ " where board.board_num = comments.board_num"
				+ " and comments.board_num = ?"
				+ " order by comments.date";
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNum);
			rs = pstmt.executeQuery();
			
			vo = new CommentsVO();
			
			while(rs.next()){
				vo.setCommentNum(rs.getInt("comment_num"));
				vo.setCommentContents(rs.getString("comment_contents"));
				vo.setCommentName(rs.getString("comment_name"));
				vo.setDate(rs.getString("date"));
			}
			rs.close();
			pstmt.close();
			
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return vo;
		
	}*/
	
	/**댓글등록*/
	public boolean comments(String commentContents, String commentName, int boardNum, String snum){
		
		boolean result = false;
		try {
			String sql = "INSERT INTO comments(comment_contents, comment_name, date, board_num, snum)"
					+ " VALUES (?, ?, now(), ?, ?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, commentContents);
			pstmt.setString(2, commentName);
			pstmt.setInt(3, boardNum);
			pstmt.setString(4, snum);

			if(pstmt.executeUpdate() == 1)
				result = true;
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}
	
	public boolean updateComments(int commentNum, String commentContents){
		boolean result = false;
		try {
			String sql = "update comments"
					+ " set comment_contents = ?"
					+ " where comment_num = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, commentContents);
			pstmt.setInt(2, commentNum);
			
			int rs = pstmt.executeUpdate();
			if (rs == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public boolean commentDelete(int commentNum){
		boolean result = false;
		PreparedStatement pstmt;
		
		try {
			String sql = "delete from comments where comment_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, commentNum);
			
			int rs = pstmt.executeUpdate();
			if (rs==1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
		
	}
	
	  public ArrayList<CommentsVO> getCommentList(int boardNum){
	      PreparedStatement pstmt;
	      ResultSet rs;
	      ArrayList<CommentsVO> list = null;
	      
	      try {
	         String sql = "select board_num, comment_num, comment_name, comment_contents, date, snum"
	               + " from comments"
	               + " where board_num=?";
	         
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, boardNum);
	         rs=pstmt.executeQuery();
	         
	         list = new ArrayList<CommentsVO>();
	         
	         while (rs.next()) {
	            CommentsVO vo = new CommentsVO();
	            
	            vo.setBoardNum(rs.getInt("board_num"));
	            vo.setCommentNum(rs.getInt("comment_num"));
	            vo.setCommentName(rs.getString("comment_name"));
	            vo.setCommentContents(rs.getString("comment_contents"));
	            vo.setDate(rs.getString("date"));
	            vo.setSnum(rs.getString("snum"));
	            
	            list.add(vo);
	         }
	         
	         rs.close();
	         pstmt.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      return list;
	      
	   }

	 public CommentsVO commentDetail(int commentNum){
	      PreparedStatement pstmt;
	      ResultSet rs;
	      CommentsVO vo = null;
	      try {
	         String sql = "select comment_num, comment_name, comment_contents, snum"
	               + " from comments"
	               + " where comment_num = ?";
	         
	         pstmt = conn.prepareStatement(sql.toString());
	         pstmt.setInt(1, commentNum);
	         
	         rs = pstmt.executeQuery();
	         
	         vo = new CommentsVO();
	         
	         while (rs.next()) {
	            vo.setCommentNum(rs.getInt("comment_num"));
	            vo.setCommentName(rs.getString("comment_name"));
	            vo.setCommentContents(rs.getString("comment_contents"));
	            vo.setSnum(rs.getString("snum"));
	            
	         }
	         rs.close();
	         pstmt.close();
	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      
	      return vo;
	      
	   }


}
