package unah.edu.poo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.poo.model.IdProvee;
import unah.edu.poo.model.Provee;

public interface RepositoryProvee extends JpaRepository <Provee, IdProvee>{

}
