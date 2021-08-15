package unah.edu.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.poo.model.Venta;
import unah.edu.poo.repository.RepositoryVenta;

@Service
public class ServiceVenta {
	@Autowired
	RepositoryVenta repositoryVenta;

	public void crearVenta(Venta venta) {
		this.repositoryVenta.save(venta);
	}

	public Venta buscarVenta(int id) {
		return this.repositoryVenta.findById(id);

	}

	public List<Venta> listarVenta() {
		return this.repositoryVenta.findAll();
	}
}
