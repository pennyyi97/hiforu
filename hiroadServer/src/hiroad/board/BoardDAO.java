package hiroad.board;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import util.Paging;


/**인터페이스*/
public class BoardDAO {
	private Connection conn;

	public BoardDAO(){
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


	/**게시물 목록 조회 (10개)*/
	public ArrayList<BoardVO> getBoardLists(int start, int end){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<BoardVO> list = null;

		try {
			String sql = "SELECT board_num,category_name, board_num, title, hits"
					+ " FROM board"
					+ " order by board_num desc LIMIT ?,?"; 
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<BoardVO>();
			while(rs.next()){
				BoardVO vo = new BoardVO();
				
				vo.setCategoryName(rs.getString("category_name"));
				vo.setBoardNum(rs.getInt("board_num"));
				vo.setTitle(rs.getString("title"));
				vo.setHits(rs.getInt("hits"));

				list.add(vo);
			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return list; 
	}
	public int getCount() {
		ResultSet rs;
		PreparedStatement pstmt;	
		int cnt = 0; 
		
		try {
			String sql = "select count(*) from board";
			pstmt = conn.prepareStatement(sql);
			
			rs = pstmt.executeQuery();
		
			if(rs.next())
				cnt = rs.getInt(1);
			
			rs.close();
			pstmt.close();
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cnt;
	}

	/**게시물 작성*/
	public boolean lostForm(String title, String name, String contents, String file,  String snum){
		boolean result = false;
		try {
			String sql = "INSERT INTO board(title, name, date, contents, file, category_num, category_name, snum)"
					+ " VALUES ( ?, ?, now(), ?, ?, 1, '분실', ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, contents);
			pstmt.setString(4, file);
			pstmt.setString(5, snum);

			if(pstmt.executeUpdate() == 1)
				result = true;
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}
	

	/**습득 게시물 작성*/
	public boolean getForm(String title, String name, String contents, String file,  String snum){
		boolean result = false;
		try {
			String sql = "INSERT INTO board(title, name, date, contents, file, category_num, category_name, snum)"
					+ " VALUES ( ?, ?, now(), ?, ?, 2, '습득', ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, title);
			pstmt.setString(2, name);
			pstmt.setString(3, contents);
			pstmt.setString(4, file);
			pstmt.setString(5, snum);

			if(pstmt.executeUpdate() == 1)
				result = true;
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}
	
	
	/**조회수 증가*/
	public boolean hitsUpdate(int boardNumber){
		boolean result = false;
		PreparedStatement pstmt;

		try {
			String sql = "update board set hits=hits+1 where board_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNumber);
			if(pstmt.executeUpdate() == 1)
				result = true;
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}


	/**게시물 수정*/
	public boolean updateForm(String contents, String title, int boardNumber) {
		boolean result = false;
		try{
			String sql = "update board "
					+ "set contents = ?, title = ? "
					+"where board_num = ?";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, contents);
			pstmt.setString(2, title);
			pstmt.setInt(3, boardNumber);
			int rs = pstmt.executeUpdate();
			if(rs == 1){
				result = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}

	/**게시물삭제*/
	public boolean boardDelete(int boardNumber){

		PreparedStatement pstmt;
		boolean result = false; 

		try {
			String sql = "delete from board where board_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,boardNumber); 

			if(pstmt.executeUpdate() ==1){
				result = true;
			}	
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result; 
	}

	/**게시물 상세보기*/
	public BoardVO getDetail(int boardNum) {    
		PreparedStatement pstmt;
		ResultSet rs;
		BoardVO vo = null;

		try {
			String sql = "select board_num, category_name, title, name, date, contents, file, hits, count_comments, snum"
					+ " from board"
					+ " where board_num = ?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,boardNum);

			rs = pstmt.executeQuery();

			vo = new BoardVO();

			while(rs.next()){
				vo.setBoardNum(rs.getInt("board_num"));
				vo.setCategoryName(rs.getString("category_name"));
				vo.setTitle(rs.getString("title"));
				vo.setName(rs.getString("name"));
				vo.setDate(rs.getString("date"));
				vo.setContents(rs.getString("contents"));
				vo.setFile(rs.getString("file"));
				vo.setHits(rs.getInt("hits"));
				vo.setCountComments(rs.getInt("count_comments"));
				vo.setSnum(rs.getString("snum"));
			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}


	/**게시물 검색*/
	public ArrayList<BoardVO> boardSearch(String title, int start, int end){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<BoardVO> list = null;

		try {
			String sql="SELECT category_name, board_num, title, hits"
					+ " FROM board"
					+ " WHERE title like ? order by board_num desc LIMIT ?,?";

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+title+"%");
			pstmt.setInt(2, start);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();

			list = new ArrayList<BoardVO>();
			while(rs.next()){
				BoardVO vo = new BoardVO();

				vo.setCategoryName(rs.getString("category_name"));
				vo.setBoardNum(rs.getInt("board_num"));
				vo.setTitle(rs.getString("title"));
				vo.setHits(rs.getInt("hits"));

				list.add(vo);
			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	public int countSearch(String title){
		PreparedStatement pstmt;
		ResultSet rs;
		int count = 0;
		
		try {
			String sql = "select count(*) from board where title like ?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, "%"+title+"%");
			rs = pstmt.executeQuery();
			while (rs.next()) {
				count = rs.getInt(1);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return count;
		
	}
	/**카테고리별 검색*/
	   public ArrayList<BoardVO> getCategoryBoardLists(int categoryNum, int start, int end){
	      PreparedStatement pstmt;
	      ResultSet rs;
	      ArrayList<BoardVO> list = null;
	      
	       String sql = "SELECT board_num,category_name, board_num, title, hits"
	               + " FROM board"
	               + " WHERE category_num = ? "
	               + " order by board_num desc limit ?,?";
	       try {
	         pstmt = conn.prepareStatement(sql.toString());
	         pstmt.setInt(1, categoryNum);
	         pstmt.setInt(2, start);
	         pstmt.setInt(3, end);


	         rs = pstmt.executeQuery();

	         list = new ArrayList<BoardVO>();
	         
	         while(rs.next()){
	            BoardVO vo = new BoardVO();

	            vo.setCategoryName(rs.getString("category_name"));
	            vo.setBoardNum(rs.getInt("board_num"));
	            vo.setTitle(rs.getString("title"));
	            vo.setHits(rs.getInt("hits"));

	            list.add(vo);
	         }
	         rs.close();
	         pstmt.close();

	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return list;
	      }

		public int getCount2() {
			ResultSet rs;
			PreparedStatement pstmt;	
			int cnt = 0; 
			
			try {
				String sql = "select count(*) from board where category_num = 1 ";
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
			
				if(rs.next())
					cnt = rs.getInt(1);
				
				rs.close();
				pstmt.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return cnt;
		}
		
		public int getCount3() {
			ResultSet rs;
			PreparedStatement pstmt;	
			int cnt = 0; 
			
			try {
				String sql = "select count(*) from board where category_num = 2 ";
				pstmt = conn.prepareStatement(sql);
				
				rs = pstmt.executeQuery();
			
				if(rs.next())
					cnt = rs.getInt(1);
				
				rs.close();
				pstmt.close();
			
			} catch (SQLException e) {
				e.printStackTrace();
			}
			return cnt;
		}


	/**댓글 갯수 세기
	public boolean countComments(int boardNumber){
		boolean result = false;
		PreparedStatement pstmt;

		try {
			String sql = "update board"
					+ " set count_comments=count_comments+1"
					+ " where board_num=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, boardNumber);
			if(pstmt.executeUpdate() == 1)
				result = true;
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
*/


}