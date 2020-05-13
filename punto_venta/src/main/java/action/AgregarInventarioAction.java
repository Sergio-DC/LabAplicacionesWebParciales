package action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductoDAO;
import pojo.Productos;

public class AgregarInventarioAction extends ActionSupport {
	private Productos producto;
	private int clave;//Guarda la clave del producto que envia el formulario
	private int cantidad;//Guarda la cantidad del producto que envia el formulario
	private static List<Productos> lista_productos;//Se utiliza para generar registro de una BD improvisada, eliminar si ya no se necesita
	private InputStream inputStream;
	
	//Busca por clave un Producto
	public String buscarPorClave() throws IOException{
		try
		{
			producto = ProductoDAO.searchProducto(clave);
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al cargar producto";
			inputStream = new ByteArrayInputStream("Error: Producto no encontrado".getBytes("UTF-8"));
			return ERROR;
		}
	}
	
	public String execute() {
		System.out.println("hola");
		return ActionSupport.SUCCESS;
	}
	
	//Se encarga de actualizar la propiedad inventario de un objeto(Productos) en especifico 
	public String actualizarInventario() throws Exception {
		System.out.println("Clave: " + this.clave + "  Cantidad: " + this.cantidad);////Eliminar cuando ya no se ocupe
		
		try
		{
			ProductoDAO.updateInventario(clave, cantidad);
			
			inputStream = new ByteArrayInputStream("<p>Producto Actualizado</p>".getBytes("UTF-8"));
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al crear producto";
			return ERROR;
		}
		
		//Esto se ejecutará si el registro fue actualizado en la BD		
	}
	
//	public InputStream getInputStream() {
//		return inputStream;
//	}
	

	public void setClave(int clave) {
		System.out.println("Meti clave: " + clave);
		this.clave = clave;
	}	

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public Productos getProducto() {
		return producto;
	}
	
	
	
}
