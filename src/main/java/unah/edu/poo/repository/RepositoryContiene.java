package unah.edu.poo.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import unah.edu.poo.model.Contiene;
import unah.edu.poo.model.IdContiene;

public interface RepositoryContiene extends JpaRepository <Contiene, IdContiene > {

}
