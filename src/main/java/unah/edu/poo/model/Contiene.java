package unah.edu.poo.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})		

@Entity
@Table(name = "contiene")
@IdClass(IdContiene.class)
public class Contiene implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idVenta;
	@Id
	private int idProducto;

	private float precio;
	private int cantidad;

	@ManyToOne
	@JoinColumn(name = "idVenta", referencedColumnName = "idVenta", insertable = false, updatable = false)
	@JsonBackReference
	private Venta venta;

	@ManyToOne
	@JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
	@JsonBackReference
	private Producto producto;

	public Contiene() {

	}

	public Contiene(int idVenta, int idProducto, float precio, int cantidad, Venta venta, Producto producto) {

		this.idVenta = idVenta;
		this.idProducto = idProducto;
		this.precio = precio;
		this.cantidad = cantidad;
		this.venta = venta;
		this.producto = producto;

	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public float getPrecio() {
		return precio;
	}

	public void setPrecio(float precio) {
		this.precio = precio;
	}

	public int getCantidad() {
		return cantidad;
	}

	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}

}
