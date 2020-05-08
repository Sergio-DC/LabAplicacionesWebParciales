package action;


import com.opensymphony.xwork2.ActionSupport;

public class RegisterAction extends ActionSupport {
	private static final long serialVersionUID = -3827439829486925185L;
	// getters and setters...
	private String uname, udeg, uemail, upass, msg;

	@Override
	public String execute() throws Exception {
		System.out.println("Uname Saved: " + uname);
		System.out.println("Udeg Saved: " + udeg);
		System.out.println("Uemail Saved: " + uemail);
		System.out.println("Upass Saved: " + upass);
		return "REGISTER";
	}

	public String getUname() {
		return uname;
	}

	public void setUname(String uname) {
		this.uname = uname;
	}

	public String getUdeg() {
		return udeg;
	}

	public void setUdeg(String udeg) {
		this.udeg = udeg;
	}

	public String getUemail() {
		return uemail;
	}

	public void setUemail(String uemail) {
		this.uemail = uemail;
	}

	public String getUpass() {
		return upass;
	}

	public void setUpass(String upass) {
		this.upass = upass;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	
}