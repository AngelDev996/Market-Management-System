package unah.edu.poo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.poo.model.Venta;

public interface RepositoryVenta extends JpaRepository <Venta, Integer>{
	public Venta findById(int id);
}
