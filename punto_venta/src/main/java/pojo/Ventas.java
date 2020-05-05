package pojo;

public class Ventas {
	private int clave;
	private int folio;
	private int cantidad;
	private int precio_final;
	
	public Ventas() {}

	public Ventas(int clave, int folio, int cantidad, int precio_final) {
		super();
		this.clave = clave;
		this.folio = folio;
		this.cantidad = cantidad;
		this.precio_final = precio_final;
	}
	
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public int getPrecio_final() {
		return precio_final;
	}
	public void setPrecio_final(int precio_final) {
		this.precio_final = precio_final;
	}
	
	@Override
	public String toString() {
		return "Ventas [clave=" + clave + ", folio=" + folio + ", cantidad=" + cantidad + ", precio_final="
				+ precio_final + "]";
	}
	
}
