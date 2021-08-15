package unah.edu.poo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import unah.edu.poo.model.Empleado;
import unah.edu.poo.repository.RepositoryEmpleado;

@Service
public class ServiceEmpleado {
	@Autowired
	RepositoryEmpleado repositoryEmpleado;

	public void crearEmpleado(Empleado empleado) {
		this.repositoryEmpleado.save(empleado);
	}

	public Empleado buscarEmpleado(int id) {
		return this.repositoryEmpleado.findById(id);

	}
	
	public List <Empleado> listarEmpleado(){
		return this.repositoryEmpleado.findAll();
	}

}
