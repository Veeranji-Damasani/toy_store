package toy_Store.dto;

public class Shop {
	private int sid;
	private String sname;
	private String saddress;
	private String s_ven_email;
	public Shop(String sname, String saddress, String s_ven_email) {
		this.sname = sname;
		this.saddress = saddress;
		this.s_ven_email = s_ven_email;
	}
	public int getSid() {
		return sid;
	}
	public void setSid(int sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getSaddress() {
		return saddress;
	}
	public void setSaddress(String saddress) {
		this.saddress = saddress;
	}
	public String getS_ven_email() {
		return s_ven_email;
	}
	public void setS_ven_email(String s_ven_email) {
		this.s_ven_email = s_ven_email;
	}
	@Override
	public String toString() {
		return "Shop [sid=" + sid + ", sname=" + sname + ", saddress=" + saddress + ", s_ven_email=" + s_ven_email
				+ "]";
	}
	
	

}
