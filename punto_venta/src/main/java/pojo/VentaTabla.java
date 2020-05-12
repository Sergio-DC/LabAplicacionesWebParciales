package pojo;


public class VentaTabla {
	private int clave;
	private String descripcion;
	private String unidad;
	private int cantidad;
	private int precio_uni;
	private int precio_fin;
	
	public VentaTabla(int clave, String descripcion, String unidad, int cantidad, int precio_uni, int precio_fin) {
		super();
		this.clave = clave;
		this.descripcion = descripcion;
		this.unidad = unidad;
		this.cantidad = cantidad;
		this.precio_uni = precio_uni;
		this.precio_fin = precio_fin;
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

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

	public int getPrecio_uni() {
		return precio_uni;
	}

	public void setPrecio_uni(int precio_uni) {
		this.precio_uni = precio_uni;
	}

	public int getPrecio_fin() {
		return precio_fin;
	}

	public void setPrecio_fin(int precio_fin) {
		this.precio_fin = precio_fin;
	}
	
}
