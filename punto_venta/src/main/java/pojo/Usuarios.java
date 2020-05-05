package pojo;

public class Usuarios {
	private String user_id;
	private String user_password;
	private String user_name;
	private String user_rol;
	private String user_status;
	
	public Usuarios() {}
	
	public Usuarios(String user_id, String user_password, String user_name, String user_rol, String user_status) {
		super();
		this.user_id = user_id;
		this.user_password = user_password;
		this.user_name = user_name;
		this.user_rol = user_rol;
		this.user_status = user_status;
	}
	
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getUser_password() {
		return user_password;
	}
	public void setUser_password(String user_password) {
		this.user_password = user_password;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getUser_rol() {
		return user_rol;
	}
	public void setUser_rol(String user_rol) {
		this.user_rol = user_rol;
	}
	public String getUser_status() {
		return user_status;
	}
	public void setUser_status(String user_status) {
		this.user_status = user_status;
	}

	@Override
	public String toString() {
		return "Usuarios [user_id=" + user_id + ", user_password=" + user_password + ", user_name=" + user_name
				+ ", user_rol=" + user_rol + ", user_status=" + user_status + "]";
	}
	
}
