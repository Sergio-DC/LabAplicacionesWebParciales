package pojo;

public class Productos {
	private int clave;
	private String descripcion;
	private String unidad;
	private int inventario;
	private int precio;
	
	public Productos() {}
	
	public Productos(int clave, String descripcion, String unidad, int inventario, int precio) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.inventario = inventario;
		this.precio = precio;
	}
	public int getClave() {
		return clave;
	}
	public void setClave(int clave) {
		this.clave = clave;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getUnidad() {
		return unidad;
	}
	public void setUnidad(String unidad) {
		this.unidad = unidad;
	}
	public int getInventario() {
		return inventario;
	}
	public void setInventario(int inventario) {
		this.inventario = inventario;
	}
	public int getPrecio() {
		return precio;
	}
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public String toString() {
		return "Productos [clave=" + clave + ", descripcion=" + descripcion + ", unidad=" + unidad + ", inventario="
				+ inventario + ", precio=" + precio + "]";
	}
	
}
