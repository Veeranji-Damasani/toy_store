package toy_Store.dto;

public class Payment {
	private int pid;
	private double pbill;
	private int p_cus_id;
	public Payment(double pbill, int p_cus_id) {
		this.pbill = pbill;
		this.p_cus_id = p_cus_id;
	}
	public int getPid() {
		return pid;
	}
	public void setPid(int pid) {
		this.pid = pid;
	}
	public double getPbill() {
		return pbill;
	}
	public void setPbill(double pbill) {
		this.pbill = pbill;
	}
	public int getP_cus_id() {
		return p_cus_id;
	}
	public void setP_cus_id(int p_cus_id) {
		this.p_cus_id = p_cus_id;
	}
	@Override
	public String toString() {
		return "Payment [pid=" + pid + ", pbill=" + pbill + ", p_cus_id=" + p_cus_id + "]";
	}
	
	
	

}
