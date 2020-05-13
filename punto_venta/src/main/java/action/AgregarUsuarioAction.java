package action;

import com.opensymphony.xwork2.ActionSupport;

import dao.UsuarioDAO;
import pojo.Usuarios;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

public class AgregarUsuarioAction extends ActionSupport{
	private Usuarios usuario;
	private InputStream inputStream;
	
	public String execute() throws IOException{
		
		System.out.println("Usuario Agregado");//Eliminar cuando ya no se ocupe
		System.out.println(usuario.toString());//Eliminar cuando ya no se ocupe
		
		try
		{
			boolean registrado = UsuarioDAO.insertUsuario(usuario.getUser_id(), usuario.getUser_password(), usuario.getUser_name(), usuario.getUser_rol(), usuario.getUser_status());
			if(registrado)
				System.out.println("Se registo en MYSQL");
			//Esto se ejecutará si se agrega el registro a la BD
			String messageToClient = "<p>Usuario " + usuario.getUser_name() + " registrado</p>";
			inputStream = new ByteArrayInputStream(messageToClient.getBytes("UTF-8"));
			return "REGISTER";
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al crear usuario";
			return ERROR;
		}
		
	}

	
	public Usuarios getUsuario() {
		return usuario;
	}


	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}


	public InputStream getInputStream() {
		return inputStream;
	}

}
