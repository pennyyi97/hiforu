package hiroad.chart;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ChartDAO {
	private Connection conn;
	
	public ChartDAO(){
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
	/**전체 차트그리기(학생/교직원/행파 구분없이)*/
	public List<Map<String, Object>> getPieChartData(){
		List<ChartVO> list = getAmount();
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for(ChartVO row : list) {
			Map<String, Object> rowData = new HashMap<String, Object>();
			rowData.put("name", row.getTicketName());
			rowData.put("amount", row.getTicketNum());
			
			result.add(rowData);
		}
		return result;
	}
	
	
	/**개인별 차트그리기*/
	public List<Map<String, Object>> getPieChartData2(String snum){
		List<ChartVO> list = getStAmount(snum);
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for(ChartVO row : list) {
			Map<String, Object> rowData = new HashMap<String, Object>();
			rowData.put("snum", row.getSnum());
			rowData.put("name", row.getTicketName());
			rowData.put("amount", row.getTicketNum());
			
			result.add(rowData);
		}
		return result;
	}
	
	/**전체 차트그리기(학생/교직원/행파)*/
	public List<Map<String, Object>> getPieChartData3(int tcatNum){
		List<ChartVO> list = getAmountCategory(tcatNum);
		
		List<Map<String, Object>> result = new ArrayList<Map<String, Object>>();
		for(ChartVO row : list) {
			Map<String, Object> rowData = new HashMap<String, Object>();
			rowData.put("name", row.getTicketName());
			rowData.put("amount", row.getTicketNum());
			
			result.add(rowData);
		}
		return result;
	}
	/**전체 식권 통계*/
	public ArrayList<ChartVO> getAmount(){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<ChartVO> list = new ArrayList<ChartVO>();
		
		try {
			String sql = "select ticket_name , count(tb.ticket_num) as '구매량'"
					+ " from ticket_info ti, ticket_buy tb"
					+ " where tb.ticket_num = ti.ticket_num"
					+ " group by ticket_name, tb.ticket_num"
					+ " order by count(tb.ticket_num) desc";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ChartVO vo = new ChartVO();
				
				vo.setTicketName(rs.getString("ticket_name"));
				vo.setTicketNum(rs.getInt("구매량"));
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**개인별 식권 구매 통계*/
	public ArrayList<ChartVO> getStAmount(String snum){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<ChartVO> list = new ArrayList<ChartVO>();
		
		try {
			String sql = "select snum, ticket_name, count(tb.ticket_num) as '구매량'"
					+ " from ticket_info ti, ticket_buy tb"
					+ " where tb.ticket_num = ti.ticket_num"
					+ " and snum = ?"
					+ " group by snum, ticket_name, tb.ticket_num"
					+ " order by count(tb.ticket_num) desc";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, snum);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ChartVO vo = new ChartVO();
				
				vo.setSnum(rs.getString("snum"));
				vo.setTicketName(rs.getString("ticket_name"));
				vo.setTicketNum(rs.getInt("구매량"));
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
	
	/**전체 식권 통계*/
	public ArrayList<ChartVO> getAmountCategory(int tcatNum){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<ChartVO> list = new ArrayList<ChartVO>();
		
		try {
			String sql = "select ticket_name, count(tb.ticket_num) as '구매량', tcategory_name"
					+ " from ticket_info ti, ticket_buy tb, tcategory tc"
					+ " where tb.ticket_num = ti.ticket_num"
					+ " and ti.tcategory_num = tc.tcategory_num"
					+ " and ti.tcategory_num = ?"
					+ " group by ticket_name, tb.ticket_num, tcategory_name"
					+ " order by count(tb.ticket_num) desc";
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tcatNum);
			rs = pstmt.executeQuery();
			
			while (rs.next()) {
				ChartVO vo = new ChartVO();
				
				vo.setTicketName(rs.getString("ticket_name"));
				vo.setTicketNum(rs.getInt("구매량"));
				vo.setTcatName(rs.getString("tcategory_name"));
				
				list.add(vo);
			}
			rs.close();
			pstmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return list;
	}
}
