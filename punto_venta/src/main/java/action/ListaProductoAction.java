package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductoDAO;
import pojo.Productos;

public class ListaProductoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private List<Productos> lista_productos;
	
	//Aqui se realizara la operación de consulta a la tabla Productos
	public String execute() {
		try
		{
			lista_productos = ProductoDAO.listProductos();
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al cargar la lista de usuarios";
			return ERROR;
		}
	}

	public List<Productos> getLista_productos() {
		return lista_productos;
	}

	public void setLista_productos(List<Productos> lista_productos) {
		this.lista_productos = lista_productos;
	}

}
