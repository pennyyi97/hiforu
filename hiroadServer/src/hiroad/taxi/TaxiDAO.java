package hiroad.taxi;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hiroad.members.MembersVO;
import hiroad.message.MessageVO;
import hiroad.product.ProductVO;
import util.Paging;


public class TaxiDAO {
   private Connection conn;

   public TaxiDAO(){
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
   /**택시 게시판 목록(최신순)*/
   public ArrayList<TaxiVO> getTaxiLists(int start, int end){
      PreparedStatement pstmt;
      ResultSet rs;
      ArrayList<TaxiVO> list = null;

      String sql = "select taxi_num, snum, title, people, want_people"
            + " from taxi"
            + " order by taxi_num desc limit ?,?";

      try {
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, start);
         pstmt.setInt(2, end);
         rs = pstmt.executeQuery();

         list = new ArrayList<TaxiVO>();
         while (rs.next()) {
            TaxiVO vo = new TaxiVO();

            vo.setTaxiNum(rs.getInt("taxi_num"));
            vo.setSnum(rs.getString("snum"));
            vo.setTitle(rs.getString("title"));
            vo.setPeople(rs.getInt("people"));
            vo.setWantPeople(rs.getInt("want_people"));

            list.add(vo);
         }
         rs.close();
         pstmt.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return list;

   }
   /*택시 등록*/
   public boolean taxi(String title, String location, String time, String contents, int people, String snum){
      boolean result = false;
      try {
         String sql = "insert into taxi(title, location, time, contents, people, date, snum)"
               + " values(?, ?, ?, ?, ?, now(), ?)";
         PreparedStatement pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, title);
         pstmt.setString(2, location);
         pstmt.setString(3, time);
         pstmt.setString(4, contents);
         pstmt.setInt(5, people);
         pstmt.setString(6, snum);

         if(pstmt.executeUpdate() == 1)
            result = true;
         pstmt.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;
   }
   public int getCount() {
 		ResultSet rs;
 		PreparedStatement pstmt;	
 		int cnt = 0; 
 		
 		try {
 			String sql = "select count(*) from taxi";
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
/*신청하기*/
   public boolean apply(String snum, int taxiNum){
      boolean result = false;
      PreparedStatement pstmt, pstmt1;
      ResultSet rs;

      try {
         String sql1 = "select * from apply where snum=? and taxi_num=?";
         pstmt = conn.prepareStatement(sql1);
         pstmt.setString(1, snum);
         pstmt.setInt(2, taxiNum);
         rs = pstmt.executeQuery();
         
         if (!rs.next()) {
            String sql = "insert into apply(snum,taxi_num) values(?,?)";
            pstmt1 = conn.prepareStatement(sql);
            pstmt1.setString(1, snum);
            pstmt1.setInt(2, taxiNum);

            if(pstmt1.executeUpdate() == 1)
               result = true;
            pstmt1.close();
            result = true;
         }
         pstmt.close();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;
   }
   //택시 동승자 목록 조회
   public ArrayList<TaxiVO> getApplyMembers( int taxiNum){
      PreparedStatement pstmt;
      ResultSet rs;
      ArrayList<TaxiVO> list = new ArrayList<TaxiVO>();

      
   String sql = "select snum from taxi where taxi_num=? "
          +"union select apply.snum from taxi,apply where taxi.taxi_num=apply.taxi_num and taxi.taxi_num=?";
   

      try {
         pstmt = conn.prepareStatement(sql);
         
         pstmt.setInt(1, taxiNum);
         pstmt.setInt(2, taxiNum);
     
         rs = pstmt.executeQuery();

         while(rs.next()) {
            TaxiVO vo = new TaxiVO();

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
 
 
  
   public TaxiVO check(String snum, int taxiNum){
      PreparedStatement pstmt;
      ResultSet rs;
      TaxiVO vo = null;
      
      try {
         String sql = "select snum, taxi_num from apply where snum=? and taxi_num=?";

         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, snum);
         pstmt.setInt(2, taxiNum);
         rs = pstmt.executeQuery();

         vo = new TaxiVO();

         while(rs.next()){
            vo.setSnum(rs.getString("snum"));
            vo.setTaxiNum(rs.getInt("taxi_num"));
         }
         
         rs.close();
         pstmt.close();

      } catch (SQLException e) {
         e.printStackTrace();
      }
      return vo;
   }
   
   
   public boolean applyCancel(String snum, int taxiNum){
      PreparedStatement pstmt;
      boolean result = false;

      try {
         String sql = "delete from apply where snum =? and taxi_num = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setString(1, snum);
         pstmt.setInt(2, taxiNum);

         if (pstmt.executeUpdate() == 1) {
            pstmt.close();
            String sql1 = "update taxi set want_people=want_people-1 where taxi_num=?";
            pstmt = conn.prepareStatement(sql1);
            pstmt.setInt(1, taxiNum);
            
            if(pstmt.executeUpdate() ==1)
               result = true;
         }
         pstmt.close();

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return result;
   }
   
   public boolean taxiDelete(int taxiNum){
      PreparedStatement pstmt;
      boolean result = false;

      try {
         String sql = "delete from taxi where taxi_num = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, taxiNum);

         if (pstmt.executeUpdate() == 1) {
            result = true;
         }
         pstmt.close();

      } catch (SQLException e) {
         e.printStackTrace();
      }

      return result;

   }

   public boolean updatePeople(int taxiNum){
      boolean result = false;
      PreparedStatement pstmt;

      try {
         String sql = "update taxi set want_people = want_people + 1 where taxi_num = ?";
         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1, taxiNum);
         if(pstmt.executeUpdate() == 1)
            result = true;
         pstmt.close();

      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;

   }


   public TaxiVO getDetail(int taxiNum) {    
      PreparedStatement pstmt;
      ResultSet rs;
      TaxiVO vo = null;

      try {
         String sql = "select taxi_num, title, location, time, contents, people, snum, want_people"
               + " from taxi"
               + " where taxi_num = ?";

         pstmt = conn.prepareStatement(sql);
         pstmt.setInt(1,taxiNum);

         rs = pstmt.executeQuery();

         vo = new TaxiVO();

         while(rs.next()){
            vo.setTaxiNum(rs.getInt("taxi_num"));
            vo.setTitle(rs.getString("title"));
            vo.setLocation(rs.getString("location"));
            vo.setTime(rs.getString("time"));
            vo.setContents(rs.getString("contents"));
            vo.setPeople(rs.getInt("people"));
            vo.setSnum(rs.getString("snum"));
            vo.setWantPeople(rs.getInt("want_people"));

         }
         rs.close();
         pstmt.close();

      } catch (SQLException e) {
         e.printStackTrace();
      }
      return vo;
   }

}