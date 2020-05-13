package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.UsuarioDAO;
import pojo.Usuarios;

public class ListaUsuarioAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<Usuarios> lista_usuarios;
	
	//Aqui se realizara la operación de consulta a la tabla Usuario
		public String execute() {
			try
			{
				lista_usuarios = UsuarioDAO.listUsuarios();
				return ActionSupport.SUCCESS;
			}catch (Exception e)
			{
				e.printStackTrace();
				//mensajeError = "Error al cargar la lista de usuarios";
				return ERROR;
			}
		}

		public List<Usuarios> getLista_usuarios() {
			return lista_usuarios;
		}

		public void setLista_usuarios(List<Usuarios> lista_usuarios) {
			this.lista_usuarios = lista_usuarios;
		}
}
