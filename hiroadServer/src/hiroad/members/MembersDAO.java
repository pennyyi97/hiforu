package hiroad.members;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import hiroad.board.BoardVO;
import hiroad.notice.NoticeVO;
import hiroad.product.ProductVO;
import util.Paging;


public class MembersDAO {
	private Connection conn;

	public MembersDAO(){
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
	/*로그인-성공*/
	public MembersVO login(String snum, String passwd){
		PreparedStatement pstmt;
		ResultSet rs;
		//		boolean result = false;

		try {
			String sql = "select snum, passwd,email, account_bank, account_num from members where snum=? and passwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  snum);
			pstmt.setString(2, passwd);
			rs = pstmt.executeQuery();

			if(rs.next()) {
				MembersVO membersVO = new MembersVO();
				membersVO.setSnum(rs.getString("snum"));
				membersVO.setEmail(rs.getString("email"));
				membersVO.setAccountBank(rs.getString("account_bank"));
				membersVO.setAccountNum(rs.getString("account_num"));

				return membersVO;
			}
			//				result = true;	

			rs.close();
			pstmt.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
		return null;
		//		return result;
	}
	/*회원가입-성공*/
	public boolean insertMember(MembersVO vo) {
		PreparedStatement pstmt;
		boolean result = false; 

		try {
			String sql = "insert into members(snum,passwd,account_bank,account_num,email) values(?,?,?,?,?)";

			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getSnum());
			pstmt.setString(2, vo.getPasswd());
			pstmt.setString(3, vo.getAccountBank());
			pstmt.setString(4, vo.getAccountNum());
			pstmt.setString(5, vo.getEmail());

			if(pstmt.executeUpdate() == 1)
				result = true;	

			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
		return result; 

	}
	/*비번찾기-성공*/
	public String findPasswd(String snum,String email) {
		String passwd = "";
		String sql ="select passwd from members where snum = ? and email = ?"; 
		try{
			PreparedStatement pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, snum);   
			pstmt.setString(2, email);
			ResultSet rs=pstmt.executeQuery();	
			if(rs.next())
				passwd = rs.getString("passwd");	
			rs.close();
			pstmt.close();			
		}catch (SQLException e){
			e.printStackTrace();
		}
		return passwd; 
	}
	/*중복체크-성공*/
	public boolean hasconfirmId(String snum){
		boolean result = false;

		String sql = "select count(snum) from members where snum = ?";
		try {
			PreparedStatement stmt=conn.prepareStatement(sql);
			stmt.setString(1, snum);
			ResultSet rs=stmt.executeQuery();
			rs.next(); 
			result=(rs.getInt(1)>0); 
			rs.close();
			stmt.close();
		}catch(SQLException e){
			e.printStackTrace();
		}

		return result;
	}

	/*회원정보수정 -성공*/

	public boolean updateMember(String snum, String passwd, String email, String accountBank,String accountNum){
		PreparedStatement pstmt = null;
		boolean result = false;
		
		try{
			String sql = "update members set passwd = ? , email=?, account_bank=?,account_num=? where snum = ?";
			 pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, passwd);
			pstmt.setString(2, email);
			pstmt.setString(3, accountBank);
			pstmt.setString(4, accountNum);
			pstmt.setString(5, snum);
			pstmt.executeUpdate();

			
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	/*계좌 등록- 성공*/

	public boolean updateAccount(String snum,String accountBank,String accountNum){
		PreparedStatement pstmt = null;
		boolean result = false;

		try{
			conn.setAutoCommit(false);
			String sql = "update members set account_bank = ?,account_num = ? where snum = ?";
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, accountBank);
			pstmt.setString(2, accountNum);
			pstmt.setString(3, snum);
			pstmt.executeUpdate();

			conn.commit();
			conn.setAutoCommit(true);
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}


	/*회원 목록-성공*/
	public ArrayList<MembersVO> getMembersLists(int start, int end){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<MembersVO> list = new ArrayList<MembersVO>();

		String sql = "select snum,passwd,account_bank,account_num,email"
				+ " from members"
				
				+ " order by snum desc LIMIT ?,?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, start);
			pstmt.setInt(2, end);
			rs = pstmt.executeQuery();

			while(rs.next()) {
				MembersVO vo = new MembersVO();

				vo.setSnum(rs.getString("snum"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setAccountBank(rs.getString("account_bank"));
				vo.setAccountNum(rs.getString("account_num"));
				vo.setEmail(rs.getString("email"));

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
			String sql = "select count(*) from members";
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
	/*회원검색-성공*/
	public ArrayList<MembersVO> memberSearch(String snum){
		PreparedStatement pstmt;
		ResultSet rs;
		ArrayList<MembersVO> list = null;

		try {
			String sql="SELECT snum"
					+ " FROM members"
					+ " WHERE snum like ? ";

			pstmt = conn.prepareStatement(sql.toString());
			pstmt.setString(1, "%"+snum+"%");

			rs = pstmt.executeQuery();

			list = new ArrayList<MembersVO>();
			while(rs.next()){
				MembersVO vo = new MembersVO();

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

	/*회원탈퇴-성공*/
	public boolean deleteMember(String snum) {
		PreparedStatement pstmt=null;
		boolean result = false; 

		try {
			String sql = "delete from members where snum = ?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, snum);


			pstmt.executeUpdate();
			result = true;
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if(pstmt != null) {
				try {
					pstmt.close();
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		return result;
	}
	/*특정회원정보 가져오기-성공*/
	public MembersVO getMember(String snum){
		PreparedStatement pstmt;
		ResultSet rs;
		MembersVO vo = null;

		String sql = "select snum,passwd,account_bank,account_num,email"
				+ " from members"
				+ " where snum=?";

		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, snum);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				vo = new MembersVO();

				vo.setSnum(rs.getString("snum"));
				vo.setPasswd(rs.getString("passwd"));
				vo.setAccountBank(rs.getString("account_bank"));
				vo.setAccountNum(rs.getString("account_num"));
				vo.setEmail(rs.getString("email"));

				
			}
			rs.close();
			pstmt.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vo;
	}
}
