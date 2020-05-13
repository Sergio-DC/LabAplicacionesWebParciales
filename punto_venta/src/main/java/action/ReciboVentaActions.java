package action;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import dao.ProductoDAO;
import dao.RecibosDAO;
import dao.VentasDAO;
import pojo.Productos;
import pojo.VentaTabla;

public class ReciboVentaActions extends ActionSupport {
	
	private static final long serialVersionUID = -3827439829486925185L;
	private VentaTabla producto_venta;
	private static List<VentaTabla> lista_venta;
	private String auxUserId;
	private int auxClave, auxCantidad, auxImporte;
	private Productos aux_producto;
	private InputStream inputStream;
	
	public InputStream getInputStream() {
		return inputStream;
	}
	public void setInputStream(InputStream inputStream) {
		this.inputStream = inputStream;
	}
	public VentaTabla getProducto_venta() {
		return producto_venta;
	}
	public void setProducto_venta(VentaTabla producto_venta) {
		this.producto_venta = producto_venta;
	}
	public static List<VentaTabla> getLista_venta() {
		return lista_venta;
	}
	public static void setLista_venta(List<VentaTabla> lista_venta) {
		ReciboVentaActions.lista_venta = lista_venta;
	}
	public String getAuxUserId() {
		return auxUserId;
	}
	public void setAuxUserId(String auxUserId) {
		this.auxUserId = auxUserId;
	}
	public int getAuxClave() {
		return auxClave;
	}
	public void setAuxClave(int auxClave) {
		this.auxClave = auxClave;
	}
	public int getAuxCantidad() {
		return auxCantidad;
	}
	public void setAuxCantidad(int auxCantidad) {
		this.auxCantidad = auxCantidad;
	}
	public int getAuxImporte() {
		return auxImporte;
	}
	public void setAuxImporte(int auxImporte) {
		this.auxImporte = auxImporte;
	}
	public Productos getAux_producto() {
		return aux_producto;
	}
	public void setAux_producto(Productos aux_producto) {
		this.aux_producto = aux_producto;
	}
	
	// Agrega un producto a la lista de venta
	public String agregarProducto()
	{
		int aux_preciofin;
		try
		{
			aux_producto = ProductoDAO.searchProducto(auxClave);
			producto_venta.setClave(aux_producto.getClave());
			producto_venta.setDescripcion(aux_producto.getDescripcion());
			producto_venta.setUnidad(aux_producto.getUnidad());
			producto_venta.setCantidad(auxCantidad);
			producto_venta.setPrecio_uni(aux_producto.getPrecio());
			aux_preciofin = auxCantidad * aux_producto.getPrecio();
			producto_venta.setPrecio_fin(aux_preciofin);
			lista_venta.add(producto_venta);
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al cargar producto";
			return ERROR;
		}
	}
	
	// Registra la venta en la BD
	/*public String registrarVenta()
	{
		String datesyst = "";
		String timesyst = "";
		Date dateObj = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
		DateFormat timeFormat = new SimpleDateFormat("hh:mm");
		datesyst = dateFormat.format(dateObj);
		timesyst = timeFormat.format(dateObj);
		
		int nexFolio = 100;
		
		try
		{
			RecibosDAO.insertRecibo(auxUserId, datesyst, timesyst, auxImporte);
			for (VentaTabla elemento : lista_venta)
			{
				VentasDAO.insertVenta(elemento.getClave(), nexFolio, elemento.getCantidad(), elemento.getPrecio_fin());
		    }
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al crear usuario";
			return ERROR;
		}
	}*/
	
	public String registrarVenta() throws IOException
	{	
		//System.out.println("Venta");
		//System.out.println(this.producto_venta.toString());
		int nexFolio = 100;
		try
		{
			VentasDAO.insertVenta(producto_venta.getClave(), nexFolio, producto_venta.getCantidad(), producto_venta.getPrecio_fin());
			return SUCCESS;
		}catch (Exception e)
		{
			e.printStackTrace();
			//mensajeError = "Error al crear usuario";
			inputStream = new ByteArrayInputStream("Error: Producto no encontrado".getBytes("UTF-8"));
			return ERROR;
		}
	}
}