package unah.edu.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.poo.model.IdProvee;
import unah.edu.poo.model.Provee;
import unah.edu.poo.repository.RepositoryProvee;

@Service
public class ServiceProvee {
	
	@Autowired
	RepositoryProvee repositoryProvee;
	
	public void crearProvicion(Provee provee) {
		this.repositoryProvee.save(provee);
	}

	public List<Provee> obtenerProvicion() {
		return this.repositoryProvee.findAll();
	}

	public Provee buscarProvicion(IdProvee idProvee) {
		return this.repositoryProvee.getOne(idProvee);
	}

}
