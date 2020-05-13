package action;

import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pojo.Productos;
import pojo.Usuarios;
import pojo.VentaTabla;

public class ReciboVentaActions extends ActionSupport {
	
	private static final long serialVersionUID = -3827439829486925185L;
	private VentaTabla producto_venta;
	private static List<VentaTabla> lista_venta;
	private String auxUserId;
	private int auxClave, auxCantidad, auxImporte;
	private Productos aux_producto;
	
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
	
	
}