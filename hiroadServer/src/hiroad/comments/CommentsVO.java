package hiroad.comments;

public class CommentsVO {
	private int commentNum;
	private String commentContents;
	private String commentName;
	private String date;
	private int boardNum;
	private String snum;
	
	public CommentsVO(){}

	public CommentsVO(int commentNum, String commentContents, String commentName, String date, int boardNum,
			String snum) {
		super();
		this.commentNum = commentNum;
		this.commentContents = commentContents;
		this.commentName = commentName;
		this.date = date;
		this.boardNum = boardNum;
		this.snum = snum;
	}

	public int getCommentNum() {
		return commentNum;
	}

	public void setCommentNum(int commentNum) {
		this.commentNum = commentNum;
	}

	public String getCommentContents() {
		return commentContents;
	}

	public void setCommentContents(String commentContents) {
		this.commentContents = commentContents;
	}

	public String getCommentName() {
		return commentName;
	}

	public void setCommentName(String commentName) {
		this.commentName = commentName;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public int getBoardNum() {
		return boardNum;
	}

	public void setBoardNum(int boardNum) {
		this.boardNum = boardNum;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	@Override
	public String toString() {
		return "CommentsVO [commentNum=" + commentNum + ", commentContents=" + commentContents + ", commentName="
				+ commentName + ", date=" + date + ", boardNum=" + boardNum + ", snum=" + snum + "]";
	}

	

}
