

package hiroad.notice;

public class NoticeVO {
   private int noticeNum;
   private String title;
   private String contents;
   private String date;
   private String snum;
   
   
   public NoticeVO(){}


   public NoticeVO(int noticeNum, String title, String contents, String date, String snum) {
      super();
      this.noticeNum = noticeNum;
      this.title = title;
      this.contents = contents;
      this.date = date;
      this.snum = snum;
   }


   public int getNoticeNum() {
      return noticeNum;
   }


   public void setNoticeNum(int noticeNum) {
      this.noticeNum = noticeNum;
   }


   public String getTitle() {
      return title;
   }


   public void setTitle(String title) {
      this.title = title;
   }


   public String getContents() {
      return contents;
   }


   public void setContents(String contents) {
      this.contents = contents;
   }


   public String getDate() {
      return date;
   }


   public void setDate(String date) {
      this.date = date;
   }


   public String getSnum() {
      return snum;
   }


   public void setSnum(String snum) {
      this.snum = snum;
   }


   @Override
   public String toString() {
      return "NoticeVO [noticeNum=" + noticeNum + ", title=" + title + ", contents=" + contents + ", date=" + date
            + ", snum=" + snum + "]";
   }
   
   
}