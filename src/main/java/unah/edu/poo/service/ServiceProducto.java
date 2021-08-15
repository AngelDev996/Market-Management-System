package unah.edu.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.poo.model.Producto;

import unah.edu.poo.repository.RepositoryProducto;

@Service
public class ServiceProducto {
	@Autowired
	RepositoryProducto repositoryProducto;

	public void crearProducto(Producto producto) {
		this.repositoryProducto.save(producto);
	}

	public Producto buscarProducto(int id) {
		return this.repositoryProducto.findById(id);

	}

	public List<Producto> listarProductos() {
		return this.repositoryProducto.findAll();
	}

}
