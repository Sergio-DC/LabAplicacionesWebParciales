package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductoDAO;
import pojo.Productos;

public class ProductoAction extends ActionSupport {
	
	private static final long serialVersionUID = -3827439829486925185L;
	private Productos productos;
	private static List<Productos> lista_productos;
	private int auxClave;
	
	public static List<Productos> getLista_productos() {
		return lista_productos;
	}

	public static void setLista_productos(List<Productos> lista_productos) {
		ProductoAction.lista_productos = lista_productos;
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}
	
	public int getAuxClave() {
		return auxClave;
	}

	public void setAuxClave(int auxClave) {
		this.auxClave = auxClave;
	}
	
	public String agregarProducto()
	{
		//ProductoDAO daoproducto = new ProductoDAO();
		try
		{
			ProductoDAO.insertProducto(productos.getClave(), productos.getDescripcion(), productos.getUnidad(), productos.getInventario(), productos.getPrecio());
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al crear producto";
			return ERROR;
		}
	}
	
	public String editarProducto()
	{
		//ProductoDAO daoproducto = new ProductoDAO();
		try
		{
			ProductoDAO.updateProducto(productos.getClave(), productos.getDescripcion(), productos.getUnidad(), productos.getInventario(), productos.getPrecio());
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al editar producto";
			return ERROR;
		}
	}
	
	public String listAllProducto()
	{
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
	
	public String searchProducto()
	{
		try
		{
			lista_productos = ProductoDAO.searchListProducto(auxClave);
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al cargar la lista de usuarios";
			return ERROR;
		}
	}
	
	public String getProdutcoData()
	{
		try
		{
			productos = ProductoDAO.searchProducto(auxClave);
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al cargar producto";
			return ERROR;
		}
	}

	
}
