package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.UsuarioDAO;
import pojo.Usuarios;

public class UsuarioAction extends ActionSupport{
	
	private static final long serialVersionUID = -3827439829486925185L;
	private Usuarios usuarios;
	private static List<Usuarios> lista_usuarios;
	private String auxUserId;
	
	public Usuarios getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuarios usuarios) {
		this.usuarios = usuarios;
	}

	public static List<Usuarios> getLista_usuarios() {
		return lista_usuarios;
	}
	public static void setLista_usuarios(List<Usuarios> lista_usuarios) {
		UsuarioAction.lista_usuarios = lista_usuarios;
	}

	public String getAuxUserId() {
		return auxUserId;
	}
	public void setAuxUserId(String auxUserId) {
		this.auxUserId = auxUserId;
	}



	public String agregarUsuario()
	{
		//UsuarioDAO daousuario = new UsuarioDAO();
		try
		{
			UsuarioDAO.insertUsuario(usuarios.getUser_id(), usuarios.getUser_password(), usuarios.getUser_name(), usuarios.getUser_rol(), usuarios.getUser_status());
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al crear usuario";
			return ERROR;
		}
	}
	
	public String editarUsuario()
	{
		//UsuarioDAO daousuario = new UsuarioDAO();
		try
		{
			UsuarioDAO.updateUsuario(usuarios.getUser_id(), usuarios.getUser_password(), usuarios.getUser_name(), usuarios.getUser_rol(), usuarios.getUser_status());
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al crear usuario";
			return ERROR;
		}
	}
	
	public String listAllUsuario()
	{
		try
		{
			lista_usuarios = UsuarioDAO.listUsuarios();
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al cargar la lista de usuarios";
			return ERROR;
		}
	}
	
	public String searchUsuario()
	{
		try
		{
			lista_usuarios = UsuarioDAO.searchListUsuario(auxUserId);
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al cargar la lista de usuarios";
			return ERROR;
		}
	}
	
	public String getUsuarioData()
	{	System.out.println("user_id: " + this.auxUserId);
		try
		{
			usuarios = UsuarioDAO.searchUsuario(auxUserId);
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al cargar la lista de usuarios";
			return ERROR;
		}
	}
}
