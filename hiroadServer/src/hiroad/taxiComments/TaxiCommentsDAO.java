package hiroad.taxiComments;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


public class TaxiCommentsDAO {
	private Connection conn;

	public TaxiCommentsDAO(){
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

	/**댓글작성*/
	public boolean taxiCom(int taxiNum, String snum, String tContents){
		boolean result = false;
		try {
			String sql = "INSERT INTO taxi_comments(tcom_contents, snum, date, taxi_num)"
					+ " VALUES (?,?,now(),?)";

			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, tContents);
			pstmt.setString(2, snum);
			pstmt.setInt(3, taxiNum);

			if(pstmt.executeUpdate() == 1)
				result = true;
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	/**댓글수정*/
	public boolean updateTcom(int tcomNum, String tContents){
		boolean result = false;
		try {
			String sql = "update taxi_comments"
					+ " set tcom_contents = ?"
					+ " where tcom_num = ?";

			PreparedStatement pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, tContents);
			pstmt.setInt(2, tcomNum);

			int rs = pstmt.executeUpdate();
			if (rs == 1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}

	/**댓글삭제*/
	public boolean tcomDelete(int tcomNum){
		boolean result = false;
		PreparedStatement pstmt;

		try {
			String sql = "delete from taxi_comments where tcom_num = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, tcomNum);

			int rs = pstmt.executeUpdate();
			if (rs==1) {
				result = true;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;

	}

	/**댓글조회*/
	public ArrayList<TaxiCommentsVO> getTcom(int taxiNum){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<TaxiCommentsVO> list = null;

		try {
			String sql = "select taxi_num, tcom_num, snum, tcom_contents, date"
					+ " from taxi_comments"
					+ " where taxi_num=?";

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, taxiNum);
			rs=pstmt.executeQuery();

			list = new ArrayList<TaxiCommentsVO>();

			while (rs.next()) {
				TaxiCommentsVO vo = new TaxiCommentsVO();

				vo.setTaxiNum(rs.getInt("taxi_num"));
				vo.setTcomNum(rs.getInt("tcom_num"));
				vo.setSnum(rs.getString("snum"));
				vo.settContents(rs.getString("tcom_contents"));
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

};
