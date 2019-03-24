package hiroad.taxi;

public class TaxiVO {
	private int taxiNum;
	private String snum;
	private String title;
	private String location;
	private String time;
	private String contents;
	private int people;
	private String date;
	private int wantPeople;
	
	public TaxiVO(){}
	
	
	
	public TaxiVO(int taxiNum, String snum, String title, String location, String time, String contents, int people, String date, int wantPeople) {
		super();
		this.taxiNum = taxiNum;
		this.snum = snum;
		this.title = title;
		this.location = location;
		this.time = time;
		this.contents = contents;
		this.people = people;
		this.date = date;
		this.wantPeople = wantPeople;
	}
	
	public int getTaxiNum() {
		return taxiNum;
	}

	public void setTaxiNum(int taxiNum) {
		this.taxiNum = taxiNum;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public int getPeople() {
		return people;
	}

	public void setPeople(int people) {
		this.people = people;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getWantPeople() {
		return wantPeople;
	}

	public void setWantPeople(int wantPeople) {
		this.wantPeople = wantPeople;
	}



	@Override
	public String toString() {
		return "TaxiVO [taxiNum=" + taxiNum + ", snum=" + snum + ", title=" + title + ", location=" + location
				+ ", time=" + time + ", contents=" + contents + ", people=" + people + ", date=" + date + "]";
	}

}
