package hiroad.bus;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class BusDAO {
	private Connection conn;

	public BusDAO(){
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
	
	public ArrayList<BusVO> getBusLists(int start, int end){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<BusVO> list = null;

		try {
			String sql = "SELECT min(depart_time) as depart_time"
					+ " FROM bus "+ "where course='한양마장' and depart_time > current_time and station='한양여대역'" +
					" limit ?,?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<BusVO>();
			while(rs.next()){
				BusVO vo = new BusVO();
				
				//vo.setCourse(rs.getString("course"));
				//vo.setStation(rs.getString("station"));
				vo.setDepart_time(rs.getString("depart_time"));
				
				
				list.add(vo);
			}
			
			rs.close();
			pstmt.close();

		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return list; 
	}
	
	
	public ArrayList<BusVO> getBusLists2(int start, int end){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<BusVO> list = null;

		try {
			String sql = "SELECT min(depart_time) as depart_time"
					+ " FROM bus "+ "where course='한양마장' and depart_time > current_time and station='한양대역'" +
					" limit ?,?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<BusVO>();
			while(rs.next()){
				BusVO vo = new BusVO();
				
				//vo.setCourse(rs.getString("course"));
				//vo.setStation(rs.getString("station"));
				vo.setDepart_time(rs.getString("depart_time"));
				
				
				list.add(vo);
			}
			
			
			rs.close();
			pstmt.close();

		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return list; 
	}
	
	
	public ArrayList<BusVO> getBusLists3(int start, int end){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<BusVO> list = null;

		try {
			String sql = "SELECT min(depart_time) as depart_time"
					+ " FROM bus "+ "where course='한양마장' and depart_time > current_time and station='마장역'" +
					" limit ?,?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<BusVO>();
			while(rs.next()){
				BusVO vo = new BusVO();
				
				//vo.setCourse(rs.getString("course"));
				//vo.setStation(rs.getString("station"));
				vo.setDepart_time(rs.getString("depart_time"));
				
				
				list.add(vo);
			}
			
			
			rs.close();
			pstmt.close();

		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return list; 
	}
	
	
	public ArrayList<BusVO> getBusLists4(int start, int end){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<BusVO> list = null;

		try {
			String sql = "SELECT min(depart_time) as depart_time"
					+ " FROM bus "+ "where course='왕십리' and depart_time > current_time and station='한양여대역'" +
					" limit ?,?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<BusVO>();
			while(rs.next()){
				BusVO vo = new BusVO();
				
				//vo.setCourse(rs.getString("course"));
				//vo.setStation(rs.getString("station"));
				vo.setDepart_time(rs.getString("depart_time"));
				
				
				list.add(vo);
			}
			
			
			rs.close();
			pstmt.close();

		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return list; 
	}
	
	

	
	public ArrayList<BusVO> getBusLists5(int start, int end){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<BusVO> list = null;

		try {
			String sql = "SELECT min(depart_time) as depart_time"
					+ " FROM bus "+ "where course='왕십리' and depart_time > current_time and station='왕십리역'" +
					" limit ?,?";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start-1);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();
			
			list = new ArrayList<BusVO>();
			while(rs.next()){
				BusVO vo = new BusVO();
				
				//vo.setCourse(rs.getString("course"));
				//vo.setStation(rs.getString("station"));
				vo.setDepart_time(rs.getString("depart_time"));
				
				
				list.add(vo);
			}
			
			rs.close();
			pstmt.close();

		} catch (SQLException e) { 
			e.printStackTrace();
		}
		return list; 
	}
	}

