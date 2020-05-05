package pojo;

import java.time.LocalDate;
import java.time.LocalTime;


public class Recibos {
	private int folio;
	private String user_id;
	private LocalDate fecha;
	private LocalTime hora;
	private String monto;
	private String tipo_pago;
	
	public Recibos() {}
	
	public Recibos(int folio, String user_id, LocalDate fecha, LocalTime hora, String monto, String tipo_pago) {
		super();
		this.folio = folio;
		this.user_id = user_id;
		this.fecha = fecha;
		this.hora = hora;
		this.monto = monto;
		this.tipo_pago = tipo_pago;
	}
	
	public int getFolio() {
		return folio;
	}
	public void setFolio(int folio) {
		this.folio = folio;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	public LocalTime getHora() {
		return hora;
	}
	public void setHora(LocalTime hora) {
		this.hora = hora;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	public String getTipo_pago() {
		return tipo_pago;
	}
	public void setTipo_pago(String tipo_pago) {
		this.tipo_pago = tipo_pago;
	}	
	
}
