package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pojo.Productos;

public class AgregarInventarioAction extends ActionSupport {
	private Productos producto;//Se utiliza para generar registro de una BD improvisada, eliminar si ya no se necesita
	private int clave;//Representa la clave del producto
	private int cantidad;//Se utiliza para actualizar la propiedad inventario de un Producto
	private static List<Productos> lista_productos;//Se utiliza para generar registro de una BD improvisada, eliminar si ya no se necesita
	static int veces = 0;

	//Simula una BD con 5 registros de la tabla Productos
	public AgregarInventarioAction() {
		if(this.lista_productos == null) {
			lista_productos = getDataBase();
		}
	}
	//Busca por clave un Producto
	public String buscarPorClave() {
		for(Productos item : lista_productos) {
			System.out.println("Lista productos: " + item.getDescripcion());
			if(item.getClave() == this.clave) {
				System.out.println("Produto Encontrado");
				producto = item;
				System.out.println(producto.toString());
				return ActionSupport.SUCCESS;
			}
		}
		return ActionSupport.ERROR;		
	}
	
	//Se encarga de actualizar la propiedad inventario de un objeto(Productos) en especifico 
	public String actualizarInventario() {
		return "UPDATED";
		
	}
	
	private ArrayList<Productos> getDataBase() {
		ArrayList<Productos> lista_productos_aux = new ArrayList<Productos>();
		Productos producto1 = new Productos();
		producto1.setClave(1111);
		producto1.setDescripcion("Jabon");
		producto1.setUnidad("caja");
		producto1.setInventario(10);
		producto1.setPrecio(25);
		lista_productos_aux.add(producto1);
		
		Productos producto2 = new Productos();
		producto2.setClave(2222);
		producto2.setDescripcion("Cereal");
		producto2.setUnidad("pza");
		producto2.setInventario(32);
		producto2.setPrecio(21);
		lista_productos_aux.add(producto2);
		
		Productos producto3 = new Productos();
		producto3.setClave(3333);
		producto3.setDescripcion("Pasta Dental");
		producto3.setUnidad("pza");
		producto3.setInventario(23);
		producto3.setPrecio(12);
		lista_productos_aux.add(producto3);
		
		Productos producto4 = new Productos();
		producto4.setClave(4444);
		producto4.setDescripcion("Shampoo");
		producto4.setUnidad("caja");
		producto4.setInventario(56);
		producto4.setPrecio(72);
		lista_productos_aux.add(producto4);
		
		Productos productos5 = new Productos();
		productos5.setClave(5555);
		productos5.setDescripcion("Queso");
		productos5.setUnidad("pza");
		productos5.setInventario(78);
		productos5.setPrecio(53);
		lista_productos_aux.add(productos5);
		
		return lista_productos_aux;
	}

	public int getClave() {
		return clave;
	}

	public void setClave(int clave) {
		this.clave = clave;
	}	

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	
	public void setProducto(Productos producto) {
		this.producto = producto;
	}
	public Productos getProducto() {
		System.out.println("Que retorna: " + producto.toString());
		return producto;
	}
	
	
	
}
