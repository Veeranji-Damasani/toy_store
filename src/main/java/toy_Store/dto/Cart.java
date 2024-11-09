package toy_Store.dto;

public class Cart {
	private int caid;
	private int ca_tid;
	private double ca_tcost;
	private String ca_cemail;
	public Cart(int ca_tid, double ca_tcost, String ca_cemail) {
		this.ca_tid = ca_tid;
		this.ca_tcost = ca_tcost;
		this.ca_cemail = ca_cemail;
	}
	public int getCaid() {
		return caid;
	}
	public void setCaid(int caid) {
		this.caid = caid;
	}
	public int getCa_tid() {
		return ca_tid;
	}
	public void setCa_tid(int ca_tid) {
		this.ca_tid = ca_tid;
	}
	public double getCa_tcost() {
		return ca_tcost;
	}
	public void setCa_tcost(double ca_tcost) {
		this.ca_tcost = ca_tcost;
	}
	public String getCa_cemail() {
		return ca_cemail;
	}
	public void setCa_cemail(String ca_cemail) {
		this.ca_cemail = ca_cemail;
	}
	@Override
	public String toString() {
		return "Cart [caid=" + caid + ", ca_tid=" + ca_tid + ", ca_tcost=" + ca_tcost + ", ca_cemail=" + ca_cemail
				+ "]";
	}
	

}
