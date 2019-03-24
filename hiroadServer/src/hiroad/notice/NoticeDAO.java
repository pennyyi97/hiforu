package hiroad.notice;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hiroad.board.BoardVO;
import util.Paging;


public class NoticeDAO {
   private Connection conn;

   public NoticeDAO(){
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
   
   public ArrayList<NoticeVO> getNoticeLists(int start, int end){
       PreparedStatement pstmt;
       ResultSet rs;
       ArrayList<NoticeVO> list = null;
       
       String sql = "select title,notice_num, contents, date"
               + " from notice"
               + " order by notice_num desc LIMIT ?,?";
       
       try {
          pstmt = conn.prepareStatement(sql);
          pstmt.setInt(1, start);
          pstmt.setInt(2, end);
          rs = pstmt.executeQuery();
          list=new ArrayList<NoticeVO>();
          while(rs.next()) {
             NoticeVO vo = new NoticeVO();
             vo.setNoticeNum(rs.getInt("notice_num"));
             vo.setTitle(rs.getString("title"));
             vo.setContents(rs.getString("contents"));
             vo.setDate(rs.getString("date"));
             
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
			String sql = "select count(*) from notice";
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
   
   /* 공지사항 등록*/
   public boolean noticeForm(String title, String contents, String snum){
       boolean result = false;
       try {
          String sql = "INSERT INTO notice(notice_num,title,contents,date,snum)"
                + " VALUES (0,?,?,now(),?)";
          PreparedStatement pstmt = conn.prepareStatement(sql);
          pstmt.setString(1, title);
          pstmt.setString(2, contents);
          pstmt.setString(3, snum);
       

          if(pstmt.executeUpdate() == 1)
             result = true;
          pstmt.close();

       } catch (SQLException e) {
          e.printStackTrace();
       }
       return result;
    }
   
   public boolean noticeDelete(int noticeNum){

	      PreparedStatement pstmt;
	      boolean result = false; 

	      try {
	        
	         String sql = "delete from notice where notice_num= ? ";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1,noticeNum);
	         

	          if(pstmt.executeUpdate() >=0){
	        	 
	             result = true;
	          } pstmt.close();
			}catch(SQLException e){
				e.printStackTrace();
			}
			return result;
   }
   public NoticeVO getDetail(int noticeNum) {    
	      PreparedStatement pstmt;
	      ResultSet rs;
	      NoticeVO vo = null;

	      try {
	         String sql = "select notice_num, title, date, contents"
	               + " from notice"
	               + " where notice_num = ?";

	         pstmt = conn.prepareStatement(sql.toString());
	         pstmt.setInt(1,noticeNum);

	         rs = pstmt.executeQuery();

	         vo = new NoticeVO();

	         while(rs.next()){
	            vo.setNoticeNum(rs.getInt("notice_num"));
	          
	            vo.setTitle(rs.getString("title"));
	          
	            vo.setDate(rs.getString("date"));
	            vo.setContents(rs.getString("contents"));
	           
	           
	           

	         }
	         rs.close();
	         pstmt.close();

	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return vo;
	   }
   
   public boolean noticeUpdate(String contents, String title, int noticeNum) {
	      boolean result = false;
	      try{
	         String sql = "update notice "
	               + "set contents = ?, title = ? "
	               +"where notice_num = ?";
	         PreparedStatement pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, contents);
	         pstmt.setString(2, title);
	         pstmt.setInt(3, noticeNum);
	         int rs = pstmt.executeUpdate();
	         if(pstmt.executeUpdate() == 1){
	            result = true;
	         }
	      }catch(SQLException e){
	         e.printStackTrace();
	      }
	      return result;
	   }
}