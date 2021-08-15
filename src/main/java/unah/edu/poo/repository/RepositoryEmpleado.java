package unah.edu.poo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.poo.model.Empleado;

public interface RepositoryEmpleado extends JpaRepository<Empleado, Integer> {
	public Empleado findById(int id);
	

}
