package unah.edu.poo.model;

import java.io.Serializable;

import javax.persistence.Embeddable;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler" })
@Embeddable
public class IdProvee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private int idProveedor;
	private int idProducto;

	public IdProvee() {

	}

	public IdProvee(int idProveedor, int idProducto) {
		super();
		this.idProveedor = idProveedor;
		this.idProducto = idProducto;
	}
	
	
	@Override
	public boolean equals(Object obj) {
		if (obj instanceof IdProvee) {
			IdProvee tmpid = (IdProvee) obj;
			if (this.idProveedor == tmpid.getIdProveedor() && this.idProducto == tmpid.getIdProducto()) {
				return true;
			} else
				return false;
		}
		return false;
	}
	
	public int hashCode() {
		return (int) this.idProveedor + this.idProducto;
	}
	

	public int getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(int idProveedor) {
		this.idProveedor = idProveedor;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
