package hiroad.message;

public class MessageVO {
   private int msgNum; //일련번호
   private String receiveId; //받는사람아이디(수신자)
   private String sendId; //보낸사람아이디(발신자)
   private String msgTitle; //메세지 제목
   private String msgContent; //메세지 내용
   private String sendDate; //보낸시간(발신시간)
   private String readDate; //읽은시간
   private String snum; //아이디(학번)
   
   public MessageVO(){}
   
   public MessageVO(int msgNum, String receiveId, 
         String sendId, String msg, String sendDate, 
         String readDate, String snum, String msgTitle, String msgContent) {
      super();
      this.msgNum = msgNum;
      this.receiveId = receiveId;
      this.sendId = sendId;
      this.msgTitle = msgTitle;
      this.msgContent = msgContent;
      this.sendDate = sendDate;
      this.readDate = readDate;
      this.snum = snum;
   }

   public int getMsgNum() {
      return msgNum;
   }

   public void setMsgNum(int msgNum) {
      this.msgNum = msgNum;
   }

   public String getReceiveId() {
      return receiveId;
   }

   public void setReceiveId(String receiveId) {
      this.receiveId = receiveId;
   }

   public String getSendId() {
      return sendId;
   }

   public void setSendId(String sendId) {
      this.sendId = sendId;
   }

   public String getMsgTitle() {
      return msgTitle;
   }

   public void setMsgTitle(String msgTitle) {
      this.msgTitle = msgTitle;
   }

   public String getMsgContent() {
      return msgContent;
   }

   public void setMsgContent(String msgContent) {
      this.msgContent = msgContent;
   }

   public String getSendDate() {
      return sendDate;
   }

   public void setSendDate(String sendDate) {
      this.sendDate = sendDate;
   }

   public String getReadDate() {
      return readDate;
   }

   public void setReadDate(String readDate) {
      this.readDate = readDate;
   }

   public String getSnum() {
      return snum;
   }

   public void setSnum(String snum) {
      this.snum = snum;
   }

   

}