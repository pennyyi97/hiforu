package hiroad.board;

public class BoardVO {
	private int boardNum;
	private String title;
	private int hits;
	private String name;
	private String date;
	private String contents;
	private String file;
	private int countComments;
	private String snum;
	private int categoryNum;
	private String categoryName;

	public BoardVO(){}

	public BoardVO(int boardNum, String title, int hits, String name, String date, String contents, String file,
			int countComments, String snum, int categoryNum, String categoryName) {
		super();
		this.boardNum = boardNum;
		this.title = title;
		this.hits = hits;
		this.name = name;
		this.date = date;
		this.contents = contents;
		this.file = file;
		this.countComments = countComments;
		this.snum = snum;
		this.categoryNum = categoryNum;
		this.categoryName = categoryName;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getHits() {
		return hits;
	}

	public void setHits(int hits) {
		this.hits = hits;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getContents() {
		return contents;
	}

	public void setContents(String contents) {
		this.contents = contents;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	public int getCountComments() {
		return countComments;
	}

	public void setCountComments(int countComments) {
		this.countComments = countComments;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public int getCategoryNum() {
		return categoryNum;
	}

	public void setCategoryNum(int categoryNum) {
		this.categoryNum = categoryNum;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	


}