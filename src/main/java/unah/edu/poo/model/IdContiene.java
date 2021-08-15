package unah.edu.poo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Embeddable
public class IdContiene implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idVenta;
	private int idProducto;
	private float precio;
	private int cantidad;

	public IdContiene() {

	}

	public IdContiene(int idVenta, int idProducto, float precio, int cantidad) {

		this.idVenta = idVenta;
		this.idProducto = idProducto;
		this.precio = precio;
		this.cantidad = cantidad;
	}
	

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IdContiene) {
			IdContiene tmpid = (IdContiene) obj;
			if (this.idVenta == tmpid.getIdVenta() && this.idProducto == tmpid.getIdProducto()) {
				return true;
			} else
				return false;
		}
		return false;
	}
	
	public int hashCode() {
		return (int) ((int)this.idVenta + this.idProducto+this.cantidad+this.precio);
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	


}
