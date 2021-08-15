package unah.edu.poo.model;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "venta")
public class Venta {

	@Id
	private int idVenta;
	private LocalDate fechaventa;

	@ManyToOne
	@JoinColumn(name = "idCliente")
	@JsonBackReference
	private Cliente cliente;

	public Venta() {
	}

	public Venta(int idVenta, LocalDate fechaventa, Cliente cliente) {

		this.idVenta = idVenta;
		this.fechaventa = fechaventa;
		this.cliente = cliente;
	}

	public int getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(int idVenta) {
		this.idVenta = idVenta;
	}

	public LocalDate getFechaventa() {
		return fechaventa;
	}

	public void setFechaventa(LocalDate fechaventa) {
		this.fechaventa = fechaventa;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	

}
