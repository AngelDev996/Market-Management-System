package unah.edu.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.poo.model.Cliente;
import unah.edu.poo.repository.RepositoryCliente;

@Service
public class ServiceCliente {
	@Autowired
	RepositoryCliente repositoryCliente;

	public void crearCliente(Cliente cliente) {
		this.repositoryCliente.save(cliente);
	}

	public Cliente buscarCliente(int id) {
		return this.repositoryCliente.findById(id);

	}
	
	public List <Cliente> listarClientes(){
		return this.repositoryCliente.findAll();
	}

}
