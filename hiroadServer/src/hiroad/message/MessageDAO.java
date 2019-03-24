package hiroad.message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hiroad.board.BoardVO;
import util.Paging;


public class MessageDAO {
	private Connection conn;

	public MessageDAO(){
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


	//1.발신메세지조회
	public ArrayList<MessageVO> getSendMessageLists(String snum,int start, int end){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<MessageVO> list1 = null;

		String sql = "select msg_num,receive_id,msg_title,msg_content,send_date,read_date,snum"
				+ " from send"
				+ " where snum=?"
				+ " order by msg_num desc LIMIT ?,?";

		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,snum);
			pstmt.setInt(2, start-1);
			pstmt.setInt(3, end);

			rs = pstmt.executeQuery();
			list1=new ArrayList<MessageVO>();
			while(rs.next()) {
				MessageVO vo = new MessageVO();
				vo.setSnum(rs.getString("snum"));
				vo.setMsgNum(rs.getInt("msg_num"));
				vo.setReceiveId(rs.getString("receive_id"));

				vo.setMsgTitle(rs.getString("msg_title"));
				vo.setMsgContent(rs.getString("msg_content"));
				vo.setSendDate(rs.getString("send_date"));
				vo.setReadDate(rs.getString("read_date"));

				list1.add(vo);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list1;

	}

	// 2.수신메시지 조회
	public ArrayList<MessageVO> getReceiveMessageLists(String snum,int start, int end){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<MessageVO> list = null;

		String sql = "select msg_num,send_id,msg_title,msg_content,send_date,read_date,snum"
				+ " from receive"
				+ " where snum=?"
				+ " order by msg_num desc LIMIT ?,?";
		try {
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,snum);
			pstmt.setInt(2, start-1);
			pstmt.setInt(3, end);
			rs = pstmt.executeQuery();
			list=new ArrayList<MessageVO>();
			while(rs.next()) {
				MessageVO vo = new MessageVO();
				vo.setSnum(rs.getString("snum"));
				vo.setMsgNum(rs.getInt("msg_num"));
				vo.setSendId(rs.getString("send_id"));
				vo.setMsgTitle(rs.getString("msg_title"));
				vo.setMsgContent(rs.getString("msg_content"));
				vo.setSendDate(rs.getString("send_date"));
				vo.setReadDate(rs.getString("read_date"));

				list.add(vo);
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return list;

	}
	// 3. 메시지 발송
	public boolean msgForm(String[] receiveId, String msgTitle, String msgContent, String snum){
		if(receiveId == null || receiveId.length == 0) {
			return false;
		}
		try {
			String sql = "INSERT INTO send(receive_id, msg_title, msg_content, send_date, read_date, snum)"
					+ "VALUES(?,?,?,now(),NULL,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql);

			for(int i = 0; i < receiveId.length; i++) {
				pstmt.setString(1, receiveId[i]);

				pstmt.setString(2, msgTitle);
				pstmt.setString(3, msgContent);
				pstmt.setString(4, snum);

				pstmt.executeUpdate();
			}
			pstmt.close();
			pstmt=null;
			sql = "INSERT INTO receive( send_id, msg_title, msg_content, send_date, read_date, snum)"
					+ "VALUES(?,?,?,now(),NULL,?)";
			pstmt = conn.prepareStatement(sql);

			for(int i = 0; i < receiveId.length; i++) {
				pstmt.setString(1, snum);

				pstmt.setString(2, msgTitle);
				pstmt.setString(3, msgContent);
				pstmt.setString(4, receiveId[i]);
				pstmt.executeUpdate();
			}

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return true;
	}


	// 4.보낸메세지 조회

	public MessageVO getSendMessageDetail(int msgNum) {    
		PreparedStatement pstmt;
		ResultSet rs;
		MessageVO vo = null;

		try {
			String sql = "select msg_num,receive_id,msg_title,msg_content,send_date,read_date"
					+ " from send"
					+ " where msg_num = ?";

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1,msgNum);

			rs = pstmt.executeQuery();

			vo = new MessageVO();

			while(rs.next()){
				vo.setMsgNum(rs.getInt("msg_num"));
				vo.setReceiveId(rs.getString("receive_id"));
				vo.setMsgTitle(rs.getString("msg_title"));
				vo.setMsgContent(rs.getString("msg_content"));
				vo.setSendDate(rs.getString("send_date"));
				vo.setReadDate(rs.getString("read_date"));




			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	//받은메세지 조회
	public MessageVO getReceiveMessageDetail(int msgNum) {    
		PreparedStatement pstmt;
		ResultSet rs;
		MessageVO vo = null;

		try {
			String sql = "select msg_num,send_id,msg_title,msg_content,send_date,read_date"
					+ " from receive"
					+ " where msg_num = ?";

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setInt(1,msgNum);

			rs = pstmt.executeQuery();

			vo = new MessageVO();

			while(rs.next()){
				vo.setMsgNum(rs.getInt("msg_num"));
				vo.setSendId(rs.getString("send_id"));
				vo.setMsgTitle(rs.getString("msg_title"));
				vo.setMsgContent(rs.getString("msg_content"));
				vo.setSendDate(rs.getString("send_date"));
				vo.setReadDate(rs.getString("read_date"));




			}
			rs.close();
			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return vo;
	}
	// 5. 읽음
	public boolean readMessage(int msgNum){
		boolean result = false;
		boolean result2 = false;
		PreparedStatement pstmt = null;

		try {

			String sql = "update receive"
					+ " set read_date=now()"
					+ " where msg_num=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, msgNum);
			pstmt.executeUpdate();


			result = true;
			pstmt = null;

			sql = "update send"
					+ " set read_date=now()"
					+ " where msg_num=?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setInt(1, msgNum);
			pstmt.executeUpdate();
			if(pstmt.executeUpdate() == 1) 
				result2 = true;
			if(result == true && result2 == true) {
				result = true;
			} else {
				result = false;
			}

			pstmt.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result; 
	}


	//메세지 삭제
	public boolean sendMsgDelete(int msgNum){

		PreparedStatement pstmt;
		boolean result = false; 


		try {

			String sql = "delete from send where msg_num= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,msgNum);


			if(pstmt.executeUpdate() >=0){

				result = true;
			} pstmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}
	public boolean receiveMsgDelete(int msgNum){

		PreparedStatement pstmt;
		boolean result = false;


		try {

			String sql = "delete from receive where msg_num= ? ";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,msgNum);


			if(pstmt.executeUpdate() >=0){

				result = true;
			} pstmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		return result;
	}





}
