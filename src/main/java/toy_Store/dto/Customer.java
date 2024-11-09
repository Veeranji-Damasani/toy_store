package toy_Store.dto;

public class Customer {
	private int cid;
	private String cemail;
	private String cpwd;
	private Double cwallet;
	public Customer(String cemail, String cpwd, Double cwallet) {
		this.cemail = cemail;
		this.cpwd = cpwd;
		this.cwallet = cwallet;
	}
	public int getCid() {
		return cid;
	}
	public void setCid(int cid) {
		this.cid = cid;
	}
	public String getCemail() {
		return cemail;
	}
	public void setCemail(String cemail) {
		this.cemail = cemail;
	}
	public String getCpwd() {
		return cpwd;
	}
	public void setCpwd(String cpwd) {
		this.cpwd = cpwd;
	}
	public Double getCwallet() {
		return cwallet;
	}
	public void setCwallet(Double cwallet) {
		this.cwallet = cwallet;
	}
	@Override
	public String toString() {
		return "Customer [cid=" + cid + ", cemail=" + cemail + ", cpwd=" + cpwd + ", cwallet=" + cwallet + "]";
	}
	
	
	
	
	

}
