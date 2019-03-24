package hiroad.taxiComments;

public class TaxiCommentsVO {
	private String snum;
	private int taxiNum;
	private int tcomNum;
	private String tContents;
	private String date;
	
	public TaxiCommentsVO(){}

	public TaxiCommentsVO(String snum, int taxiNum, int tcomNum, String tContents, String date) {
		super();
		this.snum = snum;
		this.taxiNum = taxiNum;
		this.tcomNum = tcomNum;
		this.tContents = tContents;
		this.date = date;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public int getTaxiNum() {
		return taxiNum;
	}

	public void setTaxiNum(int taxiNum) {
		this.taxiNum = taxiNum;
	}

	public int getTcomNum() {
		return tcomNum;
	}

	public void setTcomNum(int tcomNum) {
		this.tcomNum = tcomNum;
	}

	public String gettContents() {
		return tContents;
	}

	public void settContents(String tContents) {
		this.tContents = tContents;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}
	
	
}
