package hiroad.chart;

public class ChartVO {
	private String snum; //학번
	private int ticketNum; //분류번호
	private String ticketName; //분류이름
	private int tcatNum;
	private String tcatName;

	public ChartVO() {}

	public ChartVO(String snum, int ticketNum, String ticketName, int tcatNum, String tcatName) {
		super();
		this.snum = snum;
		this.ticketNum = ticketNum;
		this.ticketName = ticketName;
		this.tcatNum = tcatNum;
		this.tcatName = tcatName;
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

	public int getTcatNum() {
		return tcatNum;
	}

	public void setTcatNum(int tcatNum) {
		this.tcatNum = tcatNum;
	}

	public String getTcatName() {
		return tcatName;
	}

	public void setTcatName(String tcatName) {
		this.tcatName = tcatName;
	}

	@Override
	public String toString() {
		return "ChartVO [snum=" + snum + ", ticketNum=" + ticketNum + ", ticketName=" + ticketName + ", tcatNum="
				+ tcatNum + ", tcatName=" + tcatName + "]";
	}


}
