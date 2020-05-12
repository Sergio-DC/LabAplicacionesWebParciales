package action;

import com.opensymphony.xwork2.ActionSupport;

import pojo.Productos;

public class AgregarProductoAction extends ActionSupport{

	private static final long serialVersionUID = -3827439829486925185L;
	private Productos productos;

	@Override
	public String execute() throws Exception {
		System.out.println("Clave del Producto Saved: " + productos.getClave());//Eliminar cuando ya no se ocupe
		System.out.println("Descripcion Saved: " + productos.getDescripcion());//Eliminar cuando ya no se ocupe
		System.out.println("Unidad de Venta Saved: " + productos.getUnidad());//Eliminar cuando ya no se ocupe
		System.out.println("Invenatario Saved: " + productos.getInventario());//Eliminar cuando ya no se ocupe
		System.out.println("Precio de Venta Saved: " + productos.getPrecio());//Eliminar cuando ya no se ocupe
		return "REGISTER";
	}

	public Productos getProductos() {
		return productos;
	}

	public void setProductos(Productos productos) {
		this.productos = productos;
	}

	
	
}