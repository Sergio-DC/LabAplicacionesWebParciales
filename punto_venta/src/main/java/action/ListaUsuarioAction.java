package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pojo.Usuarios;

public class ListaUsuarioAction extends ActionSupport {
	private static final long serialVersionUID = 1L;
	private List<Usuarios> lista_usuarios;
	
	public ListaUsuarioAction() {
		if(this.lista_usuarios == null)
			lista_usuarios = getDataBase();
	}
	
	//Aqui se realizara la operación de consulta a la tabla Usuario
		public String execute() {
			for(Usuarios item: lista_usuarios)
				System.out.println(item);
			return ActionSupport.SUCCESS;
		}

		public List<Usuarios> getLista_usuarios() {
			return lista_usuarios;
		}
		
		//Eliminar cuando ya no se ocupe
		private ArrayList<Usuarios> getDataBase() {
			ArrayList<Usuarios> lista_usuarios_aux = new ArrayList<Usuarios>();
			Usuarios usuario1 = new Usuarios();
			usuario1.setUser_id("1111");
			usuario1.setUser_password("HOLA123");
			usuario1.setUser_name("Gerado");
			usuario1.setUser_rol("administrado");
			usuario1.setUser_status("activo");
			lista_usuarios_aux.add(usuario1);
			
			Usuarios usuario2 = new Usuarios();
			usuario2.setUser_id("2222");
			usuario2.setUser_password("gop32");
			usuario2.setUser_name("Mariana");
			usuario2.setUser_rol("ventas");
			usuario2.setUser_status("activo");
			lista_usuarios_aux.add(usuario2);
			
			Usuarios usuario3 = new Usuarios();
			usuario3.setUser_id("3333");
			usuario3.setUser_password("pvou32");
			usuario3.setUser_name("Jose");
			usuario3.setUser_rol("ventas");
			usuario3.setUser_status("inactivo");
			lista_usuarios_aux.add(usuario3);
			
			Usuarios usuario4 = new Usuarios();
			usuario4.setUser_id("4444");
			usuario4.setUser_password("shft43");
			usuario4.setUser_name("Carla");
			usuario4.setUser_rol("administrador");
			usuario4.setUser_status("activo");
			lista_usuarios_aux.add(usuario4);
			
			Usuarios usuario5 = new Usuarios();
			usuario5.setUser_id("5555");
			usuario5.setUser_password("qpe23");
			usuario5.setUser_name("Roberto");
			usuario5.setUser_rol("ventas");
			usuario5.setUser_status("activo");
			lista_usuarios_aux.add(usuario5);
			
			return lista_usuarios_aux;
		}
}
