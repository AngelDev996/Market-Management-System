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
@Table(name = "provee")
@IdClass(IdProvee.class)
public class Provee implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	private int idProveedor;

	@Id
	private int idProducto;

	@ManyToOne
	@JoinColumn(name = "idProveedor", referencedColumnName = "idProveedor", insertable = false, updatable = false)
	@JsonBackReference
	private Proveedor proveedor;

	@ManyToOne
	@JoinColumn(name = "idProducto", referencedColumnName = "idProducto", insertable = false, updatable = false)
	@JsonBackReference
	private Producto producto;

	public Provee() {

	}

	public Provee(int idProveedor, int idProducto, Proveedor proveedor, Producto producto) {

		this.idProveedor = idProveedor;
		this.idProducto = idProducto;
		this.proveedor = proveedor;
		this.producto = producto;
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
