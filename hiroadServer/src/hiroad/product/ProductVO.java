package hiroad.product;

public class ProductVO {
	private String ticketBuyNum; //구매번호
	private int price; //가격
	private String date; //구매날짜
	private String qrcode; //qr 코드 url
	private String snum; //학번
	private int ticketNum; //분류번호
	private String ticketName; //분류이름
	private String file; //식단 사진
	private int tcatecoryNum; //티켓카테고리번호
	private String tcategoryName; //티켓카테고리이름
	
	public ProductVO() {}

	public ProductVO(String ticketBuyNum, int price, String date, String qrcode, String snum, int ticketNum,
			String ticketName, String file, int tcatecoryNum, String tcategoryName) {
		super();
		this.ticketBuyNum = ticketBuyNum;
		this.price = price;
		this.date = date;
		this.qrcode = qrcode;
		this.snum = snum;
		this.ticketNum = ticketNum;
		this.ticketName = ticketName;
		this.file = file;
		this.tcatecoryNum = tcatecoryNum;
		this.tcategoryName = tcategoryName;
	}

	public String getTicketBuyNum() {
		return ticketBuyNum;
	}

	public void setTicketBuyNum(String ticketBuyNum) {
		this.ticketBuyNum = ticketBuyNum;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getQrcode() {
		return qrcode;
	}

	public void setQrcode(String qrcode) {
		this.qrcode = qrcode;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public int getTicketNum() {
		return ticketNum;
	}

	public void setTicketNum(int ticketNum) {
		this.ticketNum = ticketNum;
	}

	public String getTicketName() {
		return ticketName;
	}

	public void setTicketName(String ticketName) {
		this.ticketName = ticketName;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getTcatecoryNum() {
		return tcatecoryNum;
	}

	public void setTcatecoryNum(int tcatecoryNum) {
		this.tcatecoryNum = tcatecoryNum;
	}

	public String getTcategoryName() {
		return tcategoryName;
	}

	public void setTcategoryName(String tcategoryName) {
		this.tcategoryName = tcategoryName;
	}
	
}
