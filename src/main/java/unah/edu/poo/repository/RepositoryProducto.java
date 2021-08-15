package unah.edu.poo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.poo.model.Producto;

public interface RepositoryProducto extends JpaRepository <Producto, Integer> {
	public Producto findById(int id);
}
