package hiroad.product;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hiroad.board.BoardVO;
import util.Paging;

public class ProductDAO {
	private Connection conn;

	public ProductDAO(){
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
	
	//상품 조회 - 첫화면(학생식당)
	public ArrayList<ProductVO> getProductBuyLists(int tcategoryNum, int start, int end){
	      PreparedStatement pstmt;
	      ResultSet rs;
	      ArrayList<ProductVO> list = null;
	      //입력값이 없는 쿼리문 & 입력값은 없지만 
	      try {
	         String sql = "SELECT ticket_num, ticket_name, price, ticket_file, tcategory_num"
	               + " FROM ticket_info"
	               + " WHERE tcategory_num = ?"
	               + " ORDER BY ticket_num asc LIMIT ?,?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setInt(1, tcategoryNum);
	         pstmt.setInt(2, start-1);
	         pstmt.setInt(3, end);
	         rs = pstmt.executeQuery();
	         
	         list=new ArrayList<ProductVO>();
	         while(rs.next()){
	            ProductVO vo = new ProductVO();
	            
	            vo.setTicketNum(rs.getInt("ticket_num"));
	            vo.setTicketName(rs.getString("ticket_name"));
	            vo.setPrice(rs.getInt("price"));
	            vo.setFile(rs.getString("ticket_file"));
	            vo.setTcatecoryNum(rs.getInt("tcategory_num"));
	            
	            list.add(vo);
	         }
	         rs.close();
	         pstmt.close();

	      } catch (SQLException e) { 
	         e.printStackTrace();
	      }
	      return list; 
	}
	
	//상품 디테일 조회
	public ProductVO getProductDetail(int ticketNum) {    
	      PreparedStatement pstmt;
	      ResultSet rs;
	      ProductVO vo = null;

	      try {
	         String sql = "select ticket_num, ticket_name, price, ticket_file, tcategory.tcategory_name"
	        		 + " from ticket_info, tcategory"
					 + " where ticket_info.tcategory_num = tcategory.tcategory_num"
	                 + " and ticket_num = ?";

	         pstmt = conn.prepareStatement(sql.toString());
	         pstmt.setInt(1,ticketNum);
	         rs = pstmt.executeQuery();
	         vo = new ProductVO();
	         while(rs.next()){
	        	vo.setTicketNum(rs.getInt("ticket_num"));
	            vo.setTicketName(rs.getString("ticket_name"));
	            vo.setPrice(rs.getInt("price"));
	            vo.setFile(rs.getString("ticket_file"));
	            vo.setTcategoryName(rs.getString("tcategory_name"));
	         }
	         rs.close();
	         pstmt.close();

	      } catch (SQLException e) {
	         e.printStackTrace();
	      }
	      return vo;
	   }
	
	//상품 구매
	public boolean productBuy(String snum, int ticketNum, int amount){
		boolean result = false;
		try {
			String sql = "INSERT INTO ticket_buy(date, qrcode, snum, ticket_num)"
					+ " VALUES (now(), 'http://m.site.naver.com/0pq9a', ?, ?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			int updcnt = 0;
			
			for(int i = 0; i < amount; i++) {
				pstmt.setString(1, snum);
				pstmt.setInt(2, ticketNum);
				updcnt += pstmt.executeUpdate();
			}
			pstmt.close();
			
			result = amount == updcnt;

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	//마이페이지에 보이는 상품리스트
	   public ArrayList<ProductVO> getProductLists(String snum, int start, int end){
	      PreparedStatement pstmt;
	       ResultSet rs;
	       ArrayList<ProductVO> list = null;
	      //입력값이 없는 쿼리문 & 입력값은 없지만 
	      try {
	         String sql = "select ticket_name, date, ticket_info.price, ticket_info.ticket_file"
	               + " from ticket_info, ticket_buy"
	               + " where ticket_info.ticket_num = ticket_buy.ticket_num"
	               + " and ticket_buy.snum=? order by ticket_buy_num desc limit ?,?";
	         pstmt = conn.prepareStatement(sql);

	         pstmt.setString(1, snum);
	         pstmt.setInt(2, start);
	         pstmt.setInt(3, end);
	         rs = pstmt.executeQuery();

	         list=new ArrayList<ProductVO>();
	            while(rs.next()){
	               ProductVO vo = new ProductVO();
	               
	               vo.setTicketName(rs.getString("ticket_name"));
	               vo.setDate(rs.getString("date"));
	               vo.setPrice(rs.getInt("price"));
	               vo.setFile(rs.getString("ticket_file"));

	               
	               list.add(vo);
	            }
	            rs.close();
	            pstmt.close();

	         } catch (SQLException e) { 
	            e.printStackTrace();
	         }
	         return list; 
	      }
	   
	   public int getCount2(String snum) {
	      ResultSet rs;
	      PreparedStatement pstmt;   
	      int cnt = 0; 
	      
	      try {
	         String sql = "select count(*) from ticket_info, ticket_buy "
	               + "where ticket_info.ticket_num = ticket_buy.ticket_num and ticket_buy.snum=?";
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, snum);
	         
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
	
}
