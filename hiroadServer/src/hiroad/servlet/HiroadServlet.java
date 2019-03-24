package hiroad.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.json.JSONArray;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

import hiroad.board.BoardVO;
import hiroad.bus.BusDAO;
import hiroad.bus.BusVO;
import hiroad.chart.ChartDAO;
import hiroad.comments.CommentsDAO;
import hiroad.comments.CommentsVO;
import hiroad.members.MembersDAO;
import hiroad.members.MembersVO;
import hiroad.message.MessageDAO;
import hiroad.message.MessageVO;
import hiroad.notice.NoticeDAO;
import hiroad.notice.NoticeVO;
import hiroad.product.ProductDAO;
import hiroad.product.ProductVO;
import hiroad.taxi.TaxiDAO;
import hiroad.taxi.TaxiVO;
import hiroad.taxiComments.TaxiCommentsDAO;
import hiroad.taxiComments.TaxiCommentsVO;
import util.Paging;
import hiroad.board.BoardDAO;



@WebServlet("/hiroad")
public class HiroadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;


	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public HiroadServlet() {
		super();

	}


	public void init(ServletConfig config) throws ServletException {
		System.out.println("init()");

	}

	public void destroy() {

		System.out.println("destroy()");
	}




	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		System.out.println("service()");
		//1) 화면에서 입력받은 데이터를 처리 request
		String cmd=request.getParameter("cmd");
		if(cmd==null) cmd="";
		String page="first.jsp";
		//2)DAO를 처리할 내용이 있으면 관련 메서드를 호출
		switch(cmd){

		case "memberList":
			page=memberList(request);
			break;

		case "main" :
			page= main(request);
			break;
		case "hanma1":
			page=hanma1(request);
			break;
		case "wang1":
			page=wang1(request);
			break;


		case "login" :
			page="login.jsp"; 
			break;
		case "loginAction":
			page = loginAction(request);//DAO연결 or 메모리 처리
			break;
		case "logout":
			page=logout(request);
			break;

		case "signup":
			page="signup.jsp";

		case "joinAction": 
			page = joinAction(request); 
			break;
		case "findpwAction" :
			page = findpwAction(request);
			break;
		case "hasconfirmId":
			page = hasconfirmId(request);
			break;
		case "dBoard":
			page=dBoard(request);
			break;
		case "noticeForm":
			page="noticeForm.jsp";
			break;
		case "noticeFormAction":
			page=noticeFormAction(request,response);
			break;

		case "udNotice":
			page=udNotice(request);
			break;

		case "account":
			page=account(request);
			break;
		case "updateMember":
			page=updateMember(request);
			break;
		case "updateMemberInfo":
			page=updateMemberInfo(request);
			break;
		case "deleteMember":
			page=deleteMember(request);
			break;
		case "releaseMember":
			page=releaseMember(request,response);
			break;

		case "Member":
			page=deleteMember(request);
			break;
		case "walking":
			page=walking(request);
			break;

		case "mypage":
			page=mypage(request);
			break;

		case "accountInfo":
			page=accountInfo(request);
			break;

		case "notice" :
			page=notice(request);
			break;
		case "timetable" :
			page=timetable(request);
			break;

		case "boardList" :
			page=boardDAO(request);
			break;


		case "search" : 
			page = boardSearch(request);
			break;
		case "acSearch":
			page=acSearch(request);
			break;
		case "searchMember":
			page = searchMember(request);
			break;


		case "lost"   :/**분실물 게시물 등록 화면*/
			page="lostForm.jsp";
			break;
		case "lostForm" :/**게시물 등록(분실물)*/
			page=lostDAO(request,response);
			break;
		case"get":
			page = "getForm.jsp";
			break;
		case "getForm":
			page=getDAO(request,response);
			break;
		case "detail" :
			page=detailDAO(request);
			page=updateHits(request); 
			break;
		case "admin":
			page="admin.jsp";
			break;

		case "cart":
			page=productDAO(request);
			break;
		case "mypageDetail":
			page="mypageDetail.jsp";
			break;
		case "delete" :
			page=delete(request, response);
			break;
		case "updateAccount":
			page=updateAccount(request);
			break;
		case "noticeDelete":
			page=noticeDelete(request,response);
			break;
		case "sendMsgDelete":
			page=sendMsgDelete(request,response);
			break;
		case "receiveMsgDelete":
			page=receiveMsgDelete(request,response);
			break;
		case "update" : /**게시물 수정*/
			page="update.jsp";
			page=update(request);
			break;
		case "updateAction"   :
			page=updateAction(request, response); //response를 넣은 건 리다이랙션 하기 위해서
			break;

		case "commentAction":
			page=commentAction(request,response);
			break;

		case "updateNotice" : 
			page="updateNotice.jsp";
			page=updateNotice(request);
			break;
		case "updateNoticeAction"   :
			page=updateNoticeAction(request, response); 
			break;
		case "msg":
			page=msg(request);
			break;
		case "msgForm":
			page=msgForm(request,response);
			break;
		case "msgSendDetail":
			page=msgSendDetail(request);
			break;
		case "msgReceiveDetail":
			page=msgReceiveDetail(request);
			break;
		case "sendMessage":
			page=sendMessage(request);
			break;
		case "receiveMessage":
			page=receiveMessage(request);
			break;
		case "commentDelete":
			page=commentDelete(request,response);
			break;
		case "taxiList": /**택시목록*/
			page=taxiList(request);
			break;
		case "taxiDetail":/**택시상세*/
			page=taxiDetail(request);
			break;
		case "taxi":/**택시등록 화면*/
			page="taxiForm.jsp";
			break;
		case "taxiForm":/**택시등록*/
			page=taxiForm(request,response);
			break;
		case "taxiSignon":/**택시신청*/
			page = taxiSignon(request,response);
			break;
		case"taxiCancel":
			page=taxiCancel(request,response);
			break;
		case"taxiDelete":
			page=taxiDelete(request,response);
			break;

		case "productBuy":
			page=productBuy(request, response);
			break;

		case "productList":
			page=ProductBuyLists(request);
			break;

		case "EmployeeProductList":
			page=EmployeeProductList(request);
			break;

		case "ParkProductList":
			page=ParkProductList(request);
			break;

		case "productDetail":
			page=productDetail(request);
			break;
		case "applyMember":
			page=applyMember(request);
			break;
		case "tcomAction":
			page=tcomAction(request,response);
			break;
		case "tcomDelete":
			page=tcomDelete(request,response);
			break;
			/**식권통계보기*/
	      case"ticketAmount":/**전체*/
	         page=ticketAmount(request);
	         break;
	      case"ticketAmoutPersonal":/**개인별*/
	         page=ticketAmoutPersonal(request);
	         break;
	      case"ticketAmountCat":/**식당별*/
	         page=ticketAmountCat(request);
	         break;
	      case "lostBoardList":
	          page=lostBoardList(request);
	          break;
	       case "getBoardList":
	          page=getBoardList(request);
	          break;   


		}
		//3)결과 페이지로 이동 포워드
		if(page != null) {
			request.getRequestDispatcher("/" + page).forward(request,response);         
		}
		//4) 실제 전송 해당 html,jsp페이지
	}//service

	private String lostBoardList(HttpServletRequest request) throws ServletException, IOException{
		BoardDAO dao=new BoardDAO();

		ArrayList<BoardVO> list;

		int totalcount = dao.getCount2();
		System.out.println(totalcount);

		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(8);
		paging.setTotalCount(totalcount);

		int start = (page - 1) * paging.getPageSize();
		int end = paging.getPageSize();


		list = dao.getCategoryBoardLists(1,start, end);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		return "lostBoard.jsp";
	}
	   
	private String getBoardList(HttpServletRequest request) throws ServletException, IOException{
		BoardDAO dao=new BoardDAO();
		ArrayList<BoardVO> list;

		int totalcount = dao.getCount3();
		System.out.println(totalcount);

		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(8);
		paging.setTotalCount(totalcount);

		int start = (page - 1) * paging.getPageSize();
		int end = paging.getPageSize();


		list = dao.getCategoryBoardLists(2,start, end);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		return "getBoardList.jsp";
	}

	/**식권구매 통계 (전체 식권)*/
	   private String ticketAmount(HttpServletRequest request) throws ServletException, IOException {
	      ChartDAO dao = new ChartDAO();
	      List<Map<String, Object>> result = dao.getPieChartData();

	      JSONArray jsonData = new JSONArray();
	      for(Map<String, Object> rowData : result){
	         JSONArray jsonRow = new JSONArray();
	         jsonRow.put(rowData.get("name"));
	         jsonRow.put(rowData.get("amount"));

	         jsonData.put(jsonRow);
	      }
	      request.setAttribute("list", jsonData);

	      return "ticketStatement.jsp";
	   }
	   
	   /**식권구매 통계(개인별)*/
	   private String ticketAmoutPersonal(HttpServletRequest request) throws ServletException, IOException {
	      ChartDAO dao = new ChartDAO();
	      HttpSession session = request.getSession();
	      String snum = (String)session.getAttribute("login");

	      List<Map<String, Object>> result = dao.getPieChartData2(snum);

	      JSONArray jsonData2 = new JSONArray();
	      for(Map<String, Object> rowData2 : result){
	         JSONArray jsonRow1 = new JSONArray();
	         jsonRow1.put(rowData2.get("name"));
	         jsonRow1.put(rowData2.get("amount"));

	         jsonData2.put(jsonRow1);
	      }
	      request.setAttribute("list", jsonData2);

	      return "ticketStatementPersonal.jsp";
	   }

	   /**식권구매 통계(식당별(학생/교직원/행파))*/
	   private String ticketAmountCat(HttpServletRequest request) throws ServletException, IOException {
	      ChartDAO dao = new ChartDAO();
	      int cat = 1;
	      int cat2 = 2;
	      int cat3 = 3;

	      List<Map<String, Object>> result = dao.getPieChartData3(cat);

	      JSONArray jsonData = new JSONArray();
	      for(Map<String, Object> rowData : result){
	         JSONArray jsonRow = new JSONArray();
	         jsonRow.put(rowData.get("name"));
	         jsonRow.put(rowData.get("amount"));

	         jsonData.put(jsonRow);
	      }

	      List<Map<String, Object>> result2 = dao.getPieChartData3(cat2);

	      JSONArray jsonData2 = new JSONArray();
	      for(Map<String, Object> rowData2 : result2){
	         JSONArray jsonRow2 = new JSONArray();
	         jsonRow2.put(rowData2.get("name"));
	         jsonRow2.put(rowData2.get("amount"));

	         jsonData2.put(jsonRow2);
	      }

	      List<Map<String, Object>> result3 = dao.getPieChartData3(cat3);

	      JSONArray jsonData3 = new JSONArray();
	      for(Map<String, Object> rowData3 : result3){
	         JSONArray jsonRow3 = new JSONArray();
	         jsonRow3.put(rowData3.get("name"));
	         jsonRow3.put(rowData3.get("amount"));

	         jsonData3.put(jsonRow3);
	      }
	      
	      request.setAttribute("list", jsonData);
	      request.setAttribute("list2", jsonData2);
	      request.setAttribute("list3", jsonData3);

	      return "ticketStatementCategory.jsp";
	   }


	private String main(HttpServletRequest request) throws ServletException, IOException{
		BusDAO dao = new BusDAO();

		ArrayList<BusVO> list = dao.getBusLists(1,56);
		request.setAttribute("list", list);

		ArrayList<BusVO> list2 = dao.getBusLists2(1,56);
		request.setAttribute("list2", list2);

		ArrayList<BusVO> list3 = dao.getBusLists3(1,56);
		request.setAttribute("list3", list3);

		ArrayList<BusVO> list4 = dao.getBusLists4(1,56);
		request.setAttribute("list4", list4);

		ArrayList<BusVO> list5 = dao.getBusLists5(1,56);
		request.setAttribute("list5", list5);


		return "main.jsp";
	}

	private String hanma1(HttpServletRequest request) throws ServletException, IOException{

		return "main.jsp";
	}
	private String wang1(HttpServletRequest request) throws ServletException, IOException{

		return "main.jsp";
	}

	private String applyMember(HttpServletRequest request) {

		TaxiDAO dao=new TaxiDAO();

		HttpSession session = request.getSession();

		int num=Integer.parseInt(request.getParameter("num"));
		String snum = (String)session.getAttribute("login");

		ArrayList<TaxiVO> list = dao.getApplyMembers(num);

		request.setAttribute("list", list);
		System.out.println(list);
		return "applyMember.jsp";
	}


	private String taxiDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		TaxiDAO dao = new TaxiDAO();
		int num=Integer.parseInt(request.getParameter("num"));
		boolean result = dao.taxiDelete(num);

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=taxiList");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "deleteFail.jsp";
	}





	private String taxiDetail(HttpServletRequest request) throws ServletException, IOException{
		TaxiDAO dao = new TaxiDAO();
		TaxiCommentsDAO tdao = new TaxiCommentsDAO();

		HttpSession session = request.getSession();
		int num=Integer.parseInt(request.getParameter("num"));
		String snum = (String)session.getAttribute("login");

		TaxiVO vo = dao.getDetail(num);
		TaxiVO tvo = dao.check(snum, num);
		ArrayList<TaxiCommentsVO> tcom = tdao.getTcom(num);

		request.setAttribute("list", vo);
		request.setAttribute("tvo", tvo);
		request.setAttribute("tcom", tcom);

		return "taxiDetail.jsp";
	}



	//택시 글쓰기
	private String taxiForm(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		TaxiDAO dao = new TaxiDAO();

		HttpSession session = request.getSession();

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String location = request.getParameter("location");
		String time = request.getParameter("time");
		//String people = request.getParameter("people");
		int people=Integer.parseInt(request.getParameter("people"));
		String snum = (String)session.getAttribute("login");

		boolean result = dao.taxi(title, location, time, contents, people, snum);

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=taxiList");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "taxiForm.jsp";
	}



	private String taxiSignon(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		TaxiDAO dao = new TaxiDAO();
		HttpSession session = request.getSession();

		int num=Integer.parseInt(request.getParameter("num"));
		String snum = (String)session.getAttribute("login");

		TaxiVO vo = dao.getDetail(num);
		TaxiVO tvo = dao.check(snum, num);

		request.setAttribute("list", vo);
		request.setAttribute("tvo", tvo);

		boolean result = dao.apply(snum, num);

		if(result) {
			dao.updatePeople(num);
			try {
				response.sendRedirect("hiroad?cmd=taxiList");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}

		return "hiroad?cmd=taxiDetail";
	}
	private String taxiCancel(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		TaxiDAO dao = new TaxiDAO();
		HttpSession session = request.getSession();

		int num=Integer.parseInt(request.getParameter("num"));
		String snum = (String)session.getAttribute("login");

		TaxiVO vo = dao.getDetail(num);
		TaxiVO tvo = dao.check(snum, num);

		request.setAttribute("list", vo);
		request.setAttribute("tvo", tvo);

		boolean result = dao.applyCancel(snum, num);

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=taxiList");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "hiroad?cmd=taxiDetail";
	}
	private String tcomAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		TaxiCommentsDAO tdao = new TaxiCommentsDAO();
		HttpSession session = request.getSession();

		int num=Integer.parseInt(request.getParameter("num"));

		String tContents = request.getParameter("tContents");
		String snum=(String)session.getAttribute("login");

		boolean result = tdao.taxiCom(num, snum, tContents);

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=taxiDetail&num=" + num);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "commentFail.jsp";
	}

	private String tcomDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		TaxiCommentsDAO tdao = new TaxiCommentsDAO();
		int num=Integer.parseInt(request.getParameter("num"));
		int tcomNum=Integer.parseInt(request.getParameter("tcomnum"));

		boolean result = tdao.tcomDelete(tcomNum);

		if(result){
			try {
				response.sendRedirect("hiroad?cmd=taxiDetail&num=" + num);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "deleteFail.jsp";
	}

	private String taxiList(HttpServletRequest request) throws ServletException, IOException{
		TaxiDAO dao = new TaxiDAO();

		ArrayList<TaxiVO> list;

		int totalcount = dao.getCount();

		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(8);
		paging.setTotalCount(totalcount);

		int start = (page - 1) * paging.getPageSize();
		int end = paging.getPageSize();
		list = dao.getTaxiLists(start, end);

		//ArrayList<TaxiVO> list = dao.getTaxiLists(1, 10);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);

		return "taxiList.jsp";
	}

	private String commentDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		CommentsDAO dao = new CommentsDAO();
		int num=Integer.parseInt(request.getParameter("num"));
		int cnum=Integer.parseInt(request.getParameter("cnum"));
		boolean result = dao.commentDelete(cnum);

		if(result){
			try {
				response.sendRedirect("hiroad?cmd=detail&num=" + num);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "deleteFail.jsp";
	}

	// msgForm에 회원 계좌 받아오기
	private String msg(HttpServletRequest request) {
		MessageDAO dao = new MessageDAO();

		String[] receiveId = request.getParameterValues("receiveId");
		request.setAttribute("receiveId", receiveId);

		HttpSession session = request.getSession();
		String snum = (String)session.getAttribute("login");

		MembersDAO md = new MembersDAO();
		MembersVO vo = md.getMember(snum);
		request.setAttribute("vo", vo);

		return "msgForm.jsp";
	}

	// 쪽지함 - 메세지 보내기
	private String msgForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		MessageDAO dao = new MessageDAO();

		String[] receiveId = request.getParameterValues("receiveId");
		request.setAttribute("receiveId", receiveId);

		String msgTitle = request.getParameter("msgTitle");
		String msgContent = request.getParameter("msgContent");

		HttpSession session = request.getSession();
		String snum = (String)session.getAttribute("login");

		MembersDAO md = new MembersDAO();
		MembersVO vo = md.getMember(snum);
		request.setAttribute("vo", vo);


		boolean result=dao.msgForm(receiveId, msgTitle, msgContent, snum);

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=account");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		dao.msgForm(receiveId, msgTitle, msgContent, snum);
		return "msgForm.jsp";
	}




	private String receiveMessage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "account.jsp";
	}


	private String sendMessage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "account.jsp";
	}


	private String updateMemberInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "updateMemberInfo.jsp";
	}


	private String updateMember(HttpServletRequest request)throws ServletException, IOException {
		MembersDAO dao = new MembersDAO();

		HttpSession session = request.getSession();
		String snum=(String)session.getAttribute("login");



		String passwd = request.getParameter("passwd");
		String email = request.getParameter("email");
		String accountBank = request.getParameter("accountBank");
		String accountNum = request.getParameter("accountNum");


		MembersVO vo = new MembersVO();

		vo.setAccountBank(request.getParameter("passwd"));
		request.setAttribute("passwd", passwd);
		vo.setAccountBank(request.getParameter("email"));
		request.setAttribute("email", email);
		vo.setAccountBank(request.getParameter("accountBank"));
		request.setAttribute("accountBank", accountBank);
		vo.setAccountNum(request.getParameter("accountNum"));
		request.setAttribute("accountNum", accountNum);


		boolean result = dao.updateMember(snum, passwd, email, accountBank, accountNum);
		if(result) {
			session.setAttribute("passwd", passwd);
			session.setAttribute("email", email);
			session.setAttribute("accountBank", accountBank);
			session.setAttribute("accountNum", accountNum);
			return "mypage.jsp";
		}

		return "fail.jsp";


	}



	//수신쪽지삭제
	private String sendMsgDelete(HttpServletRequest request, HttpServletResponse response){
		MessageDAO dao = new MessageDAO();
		int num=Integer.parseInt(request.getParameter("num"));
		boolean result = dao.sendMsgDelete(num);

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=account");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "deleteFail.jsp";
	}
	//발신쪽지삭제
	private String receiveMsgDelete(HttpServletRequest request, HttpServletResponse response){
		MessageDAO dao = new MessageDAO();
		int num=Integer.parseInt(request.getParameter("num"));
		boolean result = dao.receiveMsgDelete(num);

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=account");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "deleteFail.jsp";
	}



	//탈퇴하기
	private String deleteMember(HttpServletRequest request) throws ServletException, IOException{
		MembersDAO dao = new MembersDAO();

		HttpSession session = request.getSession();
		String snum=(String)session.getAttribute("login");



		boolean result = dao.deleteMember(snum);

		if (result == true) {
			session.invalidate();
			return "mypage.jsp";
		} else {
			return "deleteFail.jsp";
		}
	}
	//관리자 -회원탈퇴
	private String releaseMember(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		MembersDAO dao = new MembersDAO();

		String snum = request.getParameter("snum");
		request.setAttribute("snum", snum);


		boolean result = dao.deleteMember(snum);


		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=memberList");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "deleteFail.jsp";
	}


	private String msgReceiveDetail(HttpServletRequest request)throws ServletException, IOException {
		MessageDAO dao=new MessageDAO();


		int num=Integer.parseInt(request.getParameter("num")); 

		MessageVO bvo = dao.getReceiveMessageDetail(num);
		if(bvo != null && bvo.getReadDate() == null) {
			dao.readMessage(num);
		}


		request.setAttribute("list", bvo);

		return "msgReceiveDetail.jsp";

	}


	private String msgSendDetail(HttpServletRequest request)throws ServletException, IOException{
		MessageDAO dao=new MessageDAO();


		int num=Integer.parseInt(request.getParameter("num")); 

		MessageVO bvo = dao.getSendMessageDetail(num);


		request.setAttribute("list", bvo);

		return "msgSendDetail.jsp";
	}


	private String acSearch(HttpServletRequest request) {

		MembersDAO dao = new MembersDAO();

		String[] snum = request.getParameterValues("snum");
		for(int i = 0;snum != null && i < snum.length; i++) {

			MembersVO vo = new MembersVO();
			vo.setSnum(snum[i]);
			System.out.println(snum[i]);
		}
		return "acSearch.jsp";
	}





	private String updateNotice(HttpServletRequest request) throws ServletException, IOException{
		NoticeDAO dao = new NoticeDAO();

		int num=Integer.parseInt(request.getParameter("num"));
		NoticeVO list = dao.getDetail(num);

		request.setAttribute("list", list);





		return "updateNotice.jsp";
	}

	private String updateNoticeAction(HttpServletRequest request, HttpServletResponse response) {
		NoticeDAO dao = new NoticeDAO();

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");
		String snum = "hiforu";

		int num=Integer.parseInt(request.getParameter("num"));

		boolean result = dao.noticeUpdate(contents, title, num);

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=notice");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "updateFail.jsp";
	}




	private String update(HttpServletRequest request) throws ServletException, IOException{
		BoardDAO dao = new BoardDAO();

		int num=Integer.parseInt(request.getParameter("num"));
		BoardVO list = dao.getDetail(num);

		request.setAttribute("list", list);

		return "update.jsp";
	}


	private String updateAction(HttpServletRequest request, HttpServletResponse response) {
		BoardDAO dao = new BoardDAO();

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");

		int num=Integer.parseInt(request.getParameter("num"));

		boolean result = dao.updateForm(contents, title, num);/**번호가 불러와지지 않는다...!*/

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=boardList");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "updateFail.jsp";
	}



	private String memberList(HttpServletRequest request)throws ServletException, IOException {
		MembersDAO dao5 = new MembersDAO();

		ArrayList<MembersVO> list;

		int totalcount = dao5.getCount();


		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(8);
		paging.setTotalCount(totalcount);

		int start = (page - 1) * paging.getPageSize();
		int end = paging.getPageSize();

		list = dao5.getMembersLists(start, end);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		return "memberList.jsp";
	}




	// 구매 결제 내역
	private String productDAO (HttpServletRequest request) throws ServletException, IOException {
		// TODO Auto-generated method stub
		ProductDAO dao3 = new ProductDAO();

		HttpSession session = request.getSession();
		String snum=(String)session.getAttribute("login");

		ArrayList<ProductVO> list; 

		int totalcount = dao3.getCount2(snum);
		System.out.println(totalcount);

		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(5);
		paging.setTotalCount(totalcount);

		int start = (page - 1) * paging.getPageSize();
		int end = paging.getPageSize();



		list = dao3.getProductLists(snum,start,end);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		return "cart.jsp";
	}


	// 계좌 등록
	private String updateAccount(HttpServletRequest request) throws ServletException, IOException {


		HttpSession session = request.getSession();
		String snum=(String)session.getAttribute("login");

		MembersDAO dao = new MembersDAO();

		String accountBank = request.getParameter("accountBank");
		//System.out.println(accountBank);
		String accountNum = request.getParameter("accountNum");
		//System.out.println(accountNum);
		MembersVO vo = new MembersVO();
		vo.setAccountBank(request.getParameter("accountBank"));
		request.setAttribute("accountBank", accountBank);
		vo.setAccountNum(request.getParameter("accountNum"));
		request.setAttribute("accountNum", accountNum);


		boolean result = dao.updateAccount(snum, accountBank, accountNum);
		if(result) {
			session.setAttribute("accountBank", accountBank);
			session.setAttribute("accountNum", accountNum);
			return "mypage.jsp";
		}

		return "fail.jsp";


	}


	//중복체크
	private String hasconfirmId(HttpServletRequest request){
		MembersDAO dao = new MembersDAO();

		String snum = request.getParameter("snum"); 
		if(!dao.hasconfirmId(snum)) 
			request.setAttribute("hasId", "사용 가능한 아이디입니다 !");
		else
			request.setAttribute("hasId", "사용 불가능한 아이디입니다."); 
		return "hasconfirmId.jsp"; 
	}



	//비번찾기
	private String findpwAction(HttpServletRequest request)throws ServletException, IOException {
		MembersDAO dao = new MembersDAO();
		String snum = request.getParameter("snum");

		String email = request.getParameter("email");
		String passwd = dao.findPasswd(snum, email);
		request.setAttribute("passwd", passwd);
		if(passwd=="")
			return "findpw.jsp";

		return "findpwAction.jsp";
	}

	// 회원가입
	private String joinAction(HttpServletRequest request) throws ServletException, IOException{
		MembersDAO dao = new MembersDAO();
		String snum = request.getParameter("snum");		
		String passwd = request.getParameter("passwd");
		String accountBank = request.getParameter("accountBank");
		String accountNum = request.getParameter("accountNum");
		String email = request.getParameter("email");

		MembersVO vo = new MembersVO(snum,passwd,null,null, email);
		boolean result = dao.insertMember(vo);
		if(result)
			return "hiroad?cmd=login";
		return "signup.jsp";
	}

	//로그아웃
	private String logout(HttpServletRequest request) throws ServletException, IOException{
		HttpSession session = request.getSession();
		if(session!=null) session.invalidate();

		return "hiroad?cmd=main";
	}


	/**로그인*/
	private String loginAction(HttpServletRequest request) throws ServletException, IOException{



		MembersDAO dao = new MembersDAO();	
		String snum = request.getParameter("number");
		String passwd = request.getParameter("pw");
		//		boolean result = dao.login(snum, passwd);	
		MembersVO membersVO = dao.login(snum, passwd);
		//		if(result){  //A>
		if(membersVO != null) {
			HttpSession session = request.getSession(true);
			session.setAttribute("login", membersVO.getSnum());
			session.setAttribute("passwd", membersVO.getPasswd());
			session.setAttribute("email", membersVO.getEmail());
			session.setAttribute("accountBank", membersVO.getAccountBank());
			session.setAttribute("accountNum", membersVO.getAccountNum());
			return "hiroad?cmd=main";
		}else{
			return "login.jsp";
		}

	}

	// 게시물 삭제
	private String delete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BoardDAO dao = new BoardDAO();
		int num=Integer.parseInt(request.getParameter("num"));
		boolean result = dao.boardDelete(num);

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=boardList");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "deleteFail.jsp";
	}

	// 관리자 -게시물 목록 
	private String dBoard(HttpServletRequest request) {
		BoardDAO dao=new BoardDAO();

		ArrayList<BoardVO> list = dao.getBoardLists(1, 10);
		request.setAttribute("list", list);
		return "dBoard.jsp";
	}

	// 관리자 수정삭제 
	private String udNotice(HttpServletRequest request)throws ServletException, IOException {
		NoticeDAO dao1 = new NoticeDAO();

		ArrayList<NoticeVO> list;

		int totalcount = dao1.getCount();

		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(8);
		paging.setTotalCount(totalcount);

		int start = (page - 1) * paging.getPageSize();
		int end = paging.getPageSize();


		list = dao1.getNoticeLists(start, end);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);

		return "udNotice.jsp";
	}

	// 공지사항 등록
	private String noticeFormAction(HttpServletRequest request, HttpServletResponse response) {
		NoticeDAO dao=new NoticeDAO();

		String title = request.getParameter("title");
		String contents = request.getParameter("contents");


		NoticeVO vo = new NoticeVO();
		vo.setTitle(title);
		vo.setContents(contents);

		String snum = "hiforu";

		boolean result = dao.noticeForm(title, contents, snum);
		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=udNotice");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "noticeForm.jsp";
	}
	// 공지사항 삭제

	private String noticeDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		NoticeDAO dao = new NoticeDAO();
		int num=Integer.parseInt(request.getParameter("num"));
		boolean result = dao.noticeDelete(num);

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=udNotice");
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "deleteFail.jsp";
	}

	// 계좌전송
	private String account(HttpServletRequest request)throws ServletException, IOException {
		MessageDAO dao=new MessageDAO();

		HttpSession session = request.getSession();
		String snum=(String)session.getAttribute("login");

		ArrayList<MessageVO> list1 = dao.getSendMessageLists(snum, 1,10);

		request.setAttribute("list1", list1);

		ArrayList<MessageVO> list = dao.getReceiveMessageLists(snum, 1, 10);

		request.setAttribute("list", list);


		return "account.jsp";
	}


	//계좌 등록
	private String accountInfo(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "accountInfo.jsp";
	}

	// 마이페이지
	private String mypage(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "mypage.jsp";
	}


	// 도보
	private String walking(HttpServletRequest request) {
		// TODO Auto-generated method stub
		return "walking.jsp";
	}

	//조회수
	private String updateHits(HttpServletRequest request) throws ServletException, IOException{
		BoardDAO dao = new BoardDAO();

		int num=Integer.parseInt(request.getParameter("num")); 
		boolean hits = dao.hitsUpdate(num);
		return "detail.jsp";
	}
	//시간표
	private String timetable(HttpServletRequest request)throws ServletException, IOException {
		// TODO Auto-generated method stub
		return "timetable.jsp";
	}

	// 공지사항 목록 보이기
	private String notice(HttpServletRequest request)throws ServletException, IOException {
		NoticeDAO dao1 = new NoticeDAO();

		ArrayList<NoticeVO> list;

		int totalcount = dao1.getCount();

		//System.out.print(totalcount);
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(6);
		paging.setTotalCount(totalcount);

		int start = (page - 1) * paging.getPageSize();
		int end = paging.getPageSize();
		list = dao1.getNoticeLists(start, end);

		//ArrayList<NoticeVO> list = dao1.getNoticeLists(1, 10);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);
		return "notice.jsp";
	}



	/** ++로그인 한 아이디로 글 작성할 수 있게 수정
	 * 파일업로드*/
	private String lostDAO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BoardDAO dao=new BoardDAO();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");

		//String path = "C:/OOPSW/worksapce_web/hiroadServer/WebContent/upload/";
		String path = request.getServletContext().getRealPath("/upload/");
		int size = 15*1024*1024;
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size,"utf-8",new DefaultFileRenamePolicy());

			String title = multi.getParameter("title");
			String name = multi.getParameter("name");
			String contents = multi.getParameter("contents");
			Enumeration<?> files = multi.getFileNames();
			String file = (String)files.nextElement();
			String filename ="/" + multi.getFilesystemName(file);
			System.out.println(path);

			String snum=(String)session.getAttribute("login");

			boolean result = dao.lostForm(title, name, contents, filename,  snum);

			if(result) {
				try {
					response.sendRedirect("hiroad?cmd=boardList");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "lostForm.jsp";

	}

	private String getDAO(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		BoardDAO dao=new BoardDAO();
		HttpSession session = request.getSession();
		request.setCharacterEncoding("utf-8");

		String path = request.getServletContext().getRealPath("/upload/");
		int size = 15*1024*1024;
		try {
			MultipartRequest multi = new MultipartRequest(request, path, size,"utf-8",new DefaultFileRenamePolicy());

			String title = multi.getParameter("title");
			String name = multi.getParameter("name");
			String contents = multi.getParameter("contents");
			Enumeration<?> files = multi.getFileNames();
			String file = (String)files.nextElement();
			String filename ="/" + multi.getFilesystemName(file);

			System.out.println(path);

			String snum=(String)session.getAttribute("login");

			boolean result = dao.getForm(title, name, contents, filename,  snum);

			if(result) {
				try {
					response.sendRedirect("hiroad?cmd=boardList");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return "getForm.jsp";
	}

	//게시물 검색
	private String boardSearch(HttpServletRequest request) throws ServletException, IOException{
		BoardDAO dao=new BoardDAO();

		String search = request.getParameter("search");
		ArrayList<BoardVO> list;


		int totalcount = dao.countSearch(search);
		System.out.print(totalcount);

		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(8);
		paging.setTotalCount(totalcount);

		int start = (page - 1) * paging.getPageSize();
		int end = paging.getPageSize();


		list = dao.boardSearch(search,start,end);

		request.setAttribute("list", list);
		request.setAttribute("paging", paging);

		return "searchBoard.jsp";
	}

	//학번 검색
	private String searchMember(HttpServletRequest request) throws ServletException, IOException{


		MembersDAO dao = new MembersDAO();

		String search = request.getParameter("search");
		ArrayList<MembersVO> list = dao.memberSearch(search);

		request.setAttribute("list", list);



		return "acSearch.jsp";

	}






	// 게시물 상세보기
	private String detailDAO(HttpServletRequest request)throws ServletException, IOException{
		BoardDAO dao=new BoardDAO();
		CommentsDAO cdao = new CommentsDAO();

		int num=Integer.parseInt(request.getParameter("num")); 

		BoardVO bvo = dao.getDetail(num);
		ArrayList<CommentsVO> clist = cdao.getCommentList(num);

		request.setAttribute("list", bvo);
		request.setAttribute("clist", clist);
		return "detail.jsp";
	}


	//게시판 목록-DB 연결됨
	private String boardDAO(HttpServletRequest request) throws ServletException, IOException{
		BoardDAO dao=new BoardDAO();

		ArrayList<BoardVO> list;

		int totalcount = dao.getCount();

		//System.out.print(totalcount);
		int page = request.getParameter("page") == null ? 1 : Integer.parseInt(request.getParameter("page"));
		Paging paging = new Paging();
		paging.setPageNo(page);
		paging.setPageSize(8);
		paging.setTotalCount(totalcount);

		int start = (page - 1) * paging.getPageSize();
		int end = paging.getPageSize();
		list = dao.getBoardLists(start, end);

		//ArrayList<BoardVO> list = dao.getBoardLists(1, 10);
		request.setAttribute("list", list);
		request.setAttribute("paging", paging);

		return "board.jsp";
	}


	/** ++로그인 한 아이디로 댓글 작성할 수 있게 수정*/
	private String commentAction(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CommentsDAO cdao = new CommentsDAO();
		HttpSession session = request.getSession();

		int num=Integer.parseInt(request.getParameter("num"));

		String commentContents = request.getParameter("commentContents");
		String commentName = request.getParameter("commentName");
		String snum=(String)session.getAttribute("login");

		boolean result = cdao.comments(commentContents, commentName, num, snum);

		if(result) {
			try {
				response.sendRedirect("hiroad?cmd=detail&num=" + num);
			} catch (IOException e) {
				e.printStackTrace();
			}
			return null;
		}
		return "commentFail.jsp";
	}
	// 식권 구매 리스트 (학생식당)
	private String ProductBuyLists(HttpServletRequest request) {
		ProductDAO dao=new ProductDAO();
		ArrayList<ProductVO> list = dao.getProductBuyLists(2, 1, 10);
		request.setAttribute("list", list);
		return "productList.jsp";
	}

	// 카테고리별 식권 구매 리스트 (교직원식당)
	private String EmployeeProductList(HttpServletRequest request) {
		ProductDAO dao=new ProductDAO();
		ArrayList<ProductVO> list = dao.getProductBuyLists(1, 1, 10);
		request.setAttribute("list", list);
		return "emproductList.jsp";
	}

	// 카테고리별 식권 구매 리스트 (행원파크식당)
	private String ParkProductList(HttpServletRequest request) {
		ProductDAO dao=new ProductDAO();
		ArrayList<ProductVO> list = dao.getProductBuyLists(3, 1, 10);
		request.setAttribute("list", list);
		return "parkproductList.jsp";
	}

	// 식권 리스트 디테일
	private String productDetail(HttpServletRequest request)throws ServletException, IOException{
		ProductDAO dao=new ProductDAO();
		int num=Integer.parseInt(request.getParameter("num"));
		ProductVO vo = dao.getProductDetail(num);
		request.setAttribute("list", vo);

		return "productListDetail.jsp";
	}
	// 식권구매
	private String productBuy(HttpServletRequest request, HttpServletResponse response)  throws ServletException, IOException{
		ProductDAO dao = new ProductDAO();

		HttpSession session = request.getSession();
		String snum = (String)session.getAttribute("login");
		int num=Integer.parseInt(request.getParameter("num"));
		int amount=Integer.parseInt(request.getParameter("amount"));
		boolean result = dao.productBuy(snum, num, amount);
		if(snum != null) {
			if(result) {
				try {
					response.sendRedirect("hiroad?cmd=cart");
				} catch (IOException e) {
					e.printStackTrace();
				}
				return null;
			}
			return "productListDetail.jsp";
		} else {
			return "login.jsp";  
		}
	}
}
