package toy_Store.dto;

public class Toys {
	private int tid;
	private String tbrand;
	private Double tcost;
	private String ttype;
	private String tcolor;
	private int tquantity;
	private String t_ven_email;
	public Toys(String tbrand, Double tcost, String ttype, String tcolor, int tquantity,String t_ven_email) {
		this.tbrand = tbrand;
		this.tcost = tcost;
		this.ttype = ttype;
		this.tcolor = tcolor;
		this.tquantity = tquantity;
		this.t_ven_email=t_ven_email;
	}
	
	public String getT_ven_email() {
		return t_ven_email;
	}

	public void setT_ven_email(String t_ven_email) {
		this.t_ven_email = t_ven_email;
	}

	public int getTid() {
		return tid;
	}
	public void setTid(int tid) {
		this.tid = tid;
	}
	public String getTbrand() {
		return tbrand;
	}
	public void setTbrand(String tbrand) {
		this.tbrand = tbrand;
	}
	public Double getTcost() {
		return tcost;
	}
	public void setTcost(Double tcost) {
		this.tcost = tcost;
	}
	public String getTtype() {
		return ttype;
	}
	public void setTtype(String ttype) {
		this.ttype = ttype;
	}
	public String getTcolor() {
		return tcolor;
	}
	public void setTcolor(String tcolor) {
		this.tcolor = tcolor;
	}
	public int getTquantity() {
		return tquantity;
	}
	public void setTquantity(int tquantity) {
		this.tquantity = tquantity;
	}

	@Override
	public String toString() {
		return "Toys [tid=" + tid + ", tbrand=" + tbrand + ", tcost=" + tcost + ", ttype=" + ttype + ", tcolor="
				+ tcolor + ", tquantity=" + tquantity + ", t_ven_email=" + t_ven_email + "]";
	}
	
	
	

}
