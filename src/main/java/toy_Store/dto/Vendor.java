package toy_Store.dto;

public class Vendor {
	private int vid;
	private String vemail;
	private String vpwd;
	public Vendor(String vemail, String vpwd) {
		this.vemail = vemail;
		this.vpwd = vpwd;
	}
	public int getVid() {
		return vid;
	}
	public void setVid(int vid) {
		this.vid = vid;
	}
	public String getVemail() {
		return vemail;
	}
	public void setVemail(String vemail) {
		this.vemail = vemail;
	}
	public String getVpwd() {
		return vpwd;
	}
	public void setVpwd(String vpwd) {
		this.vpwd = vpwd;
	}
	@Override
	public String toString() {
		return "Vendor [vid=" + vid + ", vemail=" + vemail + ", vpwd=" + vpwd + "]";
	}
	
	

}
