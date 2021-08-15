package unah.edu.poo.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "producto")
public class Producto {

	@Id
	private int idProducto;
	private String nombreProducto;
	private float precioVenta;
	private float precioCompra;
	private int existencia;
	private String descripcion;

	public Producto() {

	}

	public Producto(int idProducto, String nombreProducto, float precioVenta, float precioCompra, int existencia,
			String descripcion) {
		super();
		this.idProducto = idProducto;
		this.nombreProducto = nombreProducto;
		this.precioVenta = precioVenta;
		this.precioCompra = precioCompra;
		this.existencia = existencia;
		this.descripcion = descripcion;
	}

	public int getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(int idProducto) {
		this.idProducto = idProducto;
	}

	public String getNombreProducto() {
		return nombreProducto;
	}

	public void setNombreProducto(String nombreProducto) {
		this.nombreProducto = nombreProducto;
	}

	public float getPrecioVenta() {
		return precioVenta;
	}

	public void setPrecioVenta(float precioVenta) {
		this.precioVenta = precioVenta;
	}

	public float getPrecioCompra() {
		return precioCompra;
	}

	public void setPrecioCompra(float precioCompra) {
		this.precioCompra = precioCompra;
	}

	public int getExistencia() {
		return existencia;
	}

	public void setExistencia(int existencia) {
		this.existencia = existencia;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

}
