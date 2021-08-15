package unah.edu.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.poo.model.Contiene;
import unah.edu.poo.model.IdContiene;
import unah.edu.poo.model.IdProvee;
import unah.edu.poo.model.Provee;
import unah.edu.poo.repository.RepositoryContiene;

@Service
public class ServiceContiene {
	@Autowired
	RepositoryContiene repositoryContiene;
	
	
	public void crearContiene(Contiene contiene) {
		this.repositoryContiene.save(contiene);
	}

	public List<Contiene> obtenerContiene() {
		return this.repositoryContiene.findAll();
	}

	public Contiene buscarContiene(IdContiene idContiene) {
		return this.repositoryContiene.getOne(idContiene);
	}

}
