package hiroad.members;

public class MembersVO {
	private String snum;
	private String passwd;
	private String accountBank;
	private String accountNum;
	private String email;
	
	public MembersVO(){}
	
	public MembersVO(String snum, String passwd, String account_bank, String account_num, String email) {
		super();
		this.snum = snum;
		this.passwd = passwd;
		this.accountBank = account_bank;
		this.accountNum= account_num;
		this.email = email;
		
	}
	
	public MembersVO(String snum){
		this.snum = snum;
		this.accountBank = accountBank;
		this.accountNum = accountNum;
	}

	public String getSnum() {
		return snum;
	}

	public void setSnum(String snum) {
		this.snum = snum;
	}

	public String getPasswd() {
		return passwd;
	}

	public void setPasswd(String passwd) {
		this.passwd = passwd;
	}

	public String getAccountBank() {
		return accountBank;
	}

	public void setAccountBank(String accountBank) {
		this.accountBank = accountBank;
	}

	public String getAccountNum() {
		return accountNum;
	}

	public void setAccountNum(String accountNum) {
		this.accountNum = accountNum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((accountBank == null) ? 0 : accountBank.hashCode());
		result = prime * result + ((accountNum == null) ? 0 : accountNum.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + ((passwd == null) ? 0 : passwd.hashCode());
		result = prime * result + ((snum == null) ? 0 : snum.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		MembersVO other = (MembersVO) obj;
		if (accountBank == null) {
			if (other.accountBank != null)
				return false;
		} else if (!accountBank.equals(other.accountBank))
			return false;
		if (accountNum == null) {
			if (other.accountNum != null)
				return false;
		} else if (!accountNum.equals(other.accountNum))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (passwd == null) {
			if (other.passwd != null)
				return false;
		} else if (!passwd.equals(other.passwd))
			return false;
		if (snum == null) {
			if (other.snum != null)
				return false;
		} else if (!snum.equals(other.snum))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "MembersVO [snum=" + snum + ", passwd=" + passwd + ", accountBank=" + accountBank + ", accountNum="
				+ accountNum + ", email=" + email + "]";
	}

	
	
	
}
