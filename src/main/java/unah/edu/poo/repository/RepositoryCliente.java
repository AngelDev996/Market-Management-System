package unah.edu.poo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.poo.model.Cliente;

public interface RepositoryCliente extends JpaRepository <Cliente, Integer> {
	public Cliente findById(int id);

}
