package unah.edu.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.poo.model.Proveedor;
import unah.edu.poo.repository.RepositoryProveedor;

@Service
public class ServiceProveedor {
	@Autowired
	RepositoryProveedor repositoryProveedor;
	
	
	public void crearProveedor(Proveedor proveedor) {
		this.repositoryProveedor.save(proveedor);
	}

	public Proveedor buscarProveedor(int id) {
		return this.repositoryProveedor.findById(id);

	}
	
	public List <Proveedor> listarProveedores(){
		return this.repositoryProveedor.findAll();
	}
	
	

}
