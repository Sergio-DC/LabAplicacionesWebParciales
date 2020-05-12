package action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pojo.Productos;

public class ListaProductoAction extends ActionSupport{
	private Productos producto;
	private List<Productos> lista_productos;
	
	public ListaProductoAction() {//Eliminar cuando ya no se ocupe
		if(this.lista_productos == null)
			lista_productos = getDataBase();
	}
	
	//Aqui se realizara la operación de consulta a la tabla Productos
	public String execute() {
		for(Productos item: this.lista_productos)
			System.out.println(item);
		return ActionSupport.SUCCESS;
	}
	
	//Eliminar cuando ya no se ocupe
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
		
//		Productos productos5 = new Productos();
//		productos5.setClave(5555);
//		productos5.setDescripcion("Queso");
//		productos5.setUnidad("pza");
//		productos5.setInventario(78);
//		productos5.setPrecio(53);
//		lista_productos_aux.add(productos5);
		
		return lista_productos_aux;
	}

	public List<Productos> getLista_productos() {
		return lista_productos;
	}

	public void setLista_productos(List<Productos> lista_productos) {
		this.lista_productos = lista_productos;
	}	
}
