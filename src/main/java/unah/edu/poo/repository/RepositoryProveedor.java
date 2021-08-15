package unah.edu.poo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.poo.model.Proveedor;

public interface RepositoryProveedor extends JpaRepository <Proveedor, Integer> {
	public Proveedor findById(int id);
}
