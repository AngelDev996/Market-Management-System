package unah.edu.poo.controller;

import unah.edu.poo.model.*;
import unah.edu.poo.service.*;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Controlador {
	@Autowired
	ServiceCliente serviceCliente;

	@Autowired
	ServiceContiene serviceContiene;

	@Autowired
	ServiceProducto serviceProducto;

	@Autowired
	ServiceProvee serviceProvee;

	@Autowired
	ServiceProveedor serviceProveedor;

	@Autowired
	ServiceVenta serviceVenta;

	@Autowired
	ServiceEmpleado serviceEmpleado;

	@Autowired
	PasswordEncoder passwordEncoder;

	@RequestMapping(value = "/encriptar", method = RequestMethod.GET)
	public String encriptarContrasenia() {
		List<Empleado> lista = this.serviceEmpleado.listarEmpleado();
		String contrasenia;
		for (Empleado e : lista) {
			contrasenia = passwordEncoder.encode("123");
			System.out.println("123" + " pasa a " + contrasenia);
			e.setContrasenia(contrasenia);
			this.serviceEmpleado.crearEmpleado(e);
		}
		return "encriptar";
	}

	@GetMapping({ "inicio" })
	public String inicio() {
		return "index";
	}

	@GetMapping("/cliente/crearCliente")
	public String registroCliente() {
		return "registrarCliente";
	}

	@RequestMapping(value = "/cliente/crearCliente", method = RequestMethod.POST) // listo

	public String crearCliente(@RequestParam(name = "id") int idCliente,
			@RequestParam(name = "nombre") String nombreCliente,
			@RequestParam(name = "direccion") String direccionCliente,
			@RequestParam(name = "telefono") String telefonoCliente,
			@RequestParam(name = "correo") String correoCliente) {
		Cliente cliente = new Cliente(idCliente, nombreCliente, direccionCliente, telefonoCliente, correoCliente);
		this.serviceCliente.crearCliente(cliente);

		return "registrarCliente";
	}

	@RequestMapping(value = "/cliente/buscarCliente", method = RequestMethod.GET) // listo
	public Cliente buscarCliente(@RequestParam(name = "id") int idCliente) {
		return this.serviceCliente.buscarCliente(idCliente);
	}

	@RequestMapping(value = "/cliente/listarClientes", method = RequestMethod.GET) // listo
	public String listarClientes(Model model) {
		List<Cliente> clientes = this.serviceCliente.listarClientes();
		model.addAttribute("clientes", clientes);
		return "listarClientes";
	}

	/////////////////////////////////////////////////
	@GetMapping("/producto/crearProducto")
	public String registroProducto() {
		return "registrarProducto";
	}

	@RequestMapping(value = "/producto/crearProducto", method = RequestMethod.POST) // Listo

	public String crearProducto(@RequestParam(name = "id") int idProducto,
			@RequestParam(name = "nombre") String nombreProducto, @RequestParam(name = "precioVenta") float precioVenta,
			@RequestParam(name = "precioCompra") float precioCompra, @RequestParam(name = "existencia") int existencia,
			@RequestParam(name = "descripcion") String descripcion) {
		Producto producto = new Producto(idProducto, nombreProducto, precioVenta, precioCompra, existencia,
				descripcion);
		this.serviceProducto.crearProducto(producto);

		return "registrarProducto";
	}

	@RequestMapping(value = "/producto/buscarProducto", method = RequestMethod.GET) // Listo
	public Producto buscarProducto(@RequestParam(name = "id") int idProducto) {
		return this.serviceProducto.buscarProducto(idProducto);
	}

	@RequestMapping(value = "/producto/listarProductos", method = RequestMethod.GET) // Listo
	public String listarProductos(Model model) {
		List<Producto> productos = this.serviceProducto.listarProductos();
		model.addAttribute("productos", productos);
		return "listarProductos";
	}

	/////////////////////////////////////////////////////////////////////////

	@GetMapping("/proveedor/crearProveedor")
	public String registroProveedor() {
		return "registrarProveedor";
	}

	@RequestMapping(value = "/proveedor/crearProveedor", method = RequestMethod.POST) // listo

	public String crearProveedor(@RequestParam(name = "id") int idProveedor,
			@RequestParam(name = "nombre") String nombreProveedor,
			@RequestParam(name = "telefono") String telefonoProveedor,
			@RequestParam(name = "direccion") String direccion,
			@RequestParam(name = "nombreContacto") String nombreContacto,
			@RequestParam(name = "correo") String correoProveedor) {
		Proveedor proveedor = new Proveedor(idProveedor, nombreProveedor, telefonoProveedor, direccion, nombreContacto,
				correoProveedor);
		this.serviceProveedor.crearProveedor(proveedor);

		return "registrarProveedor";
	}

	@RequestMapping(value = "/proveedor/buscarProveedor", method = RequestMethod.GET) // Listo
	public Proveedor buscarProveedor(@RequestParam(name = "id") int idProveedor) {
		return this.serviceProveedor.buscarProveedor(idProveedor);
	}

	@RequestMapping(value = "/proveedor/listarProveedor", method = RequestMethod.GET) // Listo
	public String listarProveedor(Model model) {
		List<Proveedor> proveedores = this.serviceProveedor.listarProveedores();
		model.addAttribute("proveedores", proveedores);
		return "listarProveedores";
	}
	/////////////////////////////////////////////////////////////////////

	@RequestMapping(value = "/venta/crearVenta", method = RequestMethod.GET) // listo

	public Venta crearVenta(@RequestParam(name = "id") int idVenta,
			@RequestParam(name = "fechaVenta") @DateTimeFormat(iso = ISO.DATE) LocalDate fechaVenta,
			@RequestParam(name = "idCliente") int idCliente) {
		Cliente c = this.buscarCliente(idCliente);
		Venta venta = new Venta(idVenta, fechaVenta, c);
		this.serviceVenta.crearVenta(venta);

		return venta;
	}

	@RequestMapping(value = "/venta/buscarVenta", method = RequestMethod.GET) // listo
	public Venta buscarVenta(@RequestParam(name = "id") int idVenta) {
		return this.serviceVenta.buscarVenta(idVenta);
	}

	@RequestMapping(value = "/venta/listarVentas", method = RequestMethod.GET) // listo
	public List<Venta> listarVentas() {
		return this.serviceVenta.listarVenta();
	}

	///////////////////////////////////////////////////////////////
	@RequestMapping(value = "/contiene/crearContiene", method = RequestMethod.GET) // listo
	public Contiene crearContiene(@RequestParam(name = "idVenta") int idVenta,
			@RequestParam(name = "idProducto") int idProducto, @RequestParam(name = "precio") float precio,
			@RequestParam(name = "cantidad") int cantidad) {
		Venta v = this.serviceVenta.buscarVenta(idVenta);
		Producto p = this.serviceProducto.buscarProducto(idProducto);

		Contiene tmpContiene = new Contiene(idVenta, idProducto, precio, cantidad, v, p);
		this.serviceContiene.crearContiene(tmpContiene);
		return tmpContiene;

	}

	@RequestMapping(value = "/contiene/buscarContiene", method = RequestMethod.GET) // No Listo
	public Contiene buscarContiene(@RequestParam(name = "idVenta") int idVenta,
			@RequestParam(name = "idProducto") int idProducto, @RequestParam(name = "precio") float precio,
			@RequestParam(name = "cantidad") int cantidad) {

		IdContiene idContiene = new IdContiene(idVenta, idProducto, precio, cantidad);
		return this.serviceContiene.buscarContiene(idContiene);
	}

	@RequestMapping(value = "/contiene/listarContiene", method = RequestMethod.GET) // lista
	public List<Contiene> listarContiene() {
		return this.serviceContiene.obtenerContiene();
	}

	//////////////////////////////////////////////
	@RequestMapping(value = "/provee/crearProvicion", method = RequestMethod.GET) // Listo
	public Provee crearContiene(@RequestParam(name = "idProveedor") int idProveedor,
			@RequestParam(name = "idProducto") int idProducto) {
		Proveedor proveedor = this.serviceProveedor.buscarProveedor(idProveedor);
		Producto p = this.serviceProducto.buscarProducto(idProducto);

		Provee tmpProvee = new Provee(idProveedor, idProducto, proveedor, p);
		this.serviceProvee.crearProvicion(tmpProvee);
		return tmpProvee;
	}

	@RequestMapping(value = "/provee/buscarProvicion", method = RequestMethod.GET) // listo
	public Provee buscarProvicion(@RequestParam(name = "idProveedor") int idProveedor,
			@RequestParam(name = "idProducto") int idProducto) {
		IdProvee idProvee = new IdProvee(idProveedor, idProducto);
		return this.serviceProvee.buscarProvicion(idProvee);
	}

	@RequestMapping(value = "/provee/listarProvicion", method = RequestMethod.GET) // Listo
	public List<Provee> listarProvicion() {
		return this.serviceProvee.obtenerProvicion();
	}

	///////////////////////////////////////////////////////////////////////

	@GetMapping("/empleado/crearEmpleado")
	public String registroEmpleado() {
		return "registrarEmpleado";
	}

	@RequestMapping(value = "/empleado/crearEmpleado", method = RequestMethod.POST) // listo

	public String crearEmpleado(@RequestParam(name = "id") int idEmpleado,
			@RequestParam(name = "nombre") String nombreEmpleado, @RequestParam(name = "usuario") String usuario,
			@RequestParam(name = "direccion") String direccionEmpleado,
			@RequestParam(name = "telefono") String telefonoEmpleado,
			@RequestParam(name = "correo") String correoEmpleado, @RequestParam(name = "rol") String rol,
			@RequestParam(name = "contrasenia") String contrasenia) {
		Empleado empleado = new Empleado(idEmpleado, nombreEmpleado, usuario, direccionEmpleado, telefonoEmpleado,
				correoEmpleado, rol,contrasenia);
		this.serviceEmpleado.crearEmpleado(empleado);

		return "registrarEmpleado";
	}

	@RequestMapping(value = "/empleado/buscarEmpleado", method = RequestMethod.GET) // Listo
	public Empleado buscarEmpleado(@RequestParam(name = "id") int idEmpleado) {
		return this.serviceEmpleado.buscarEmpleado(idEmpleado);
	}

	@RequestMapping(value = "/empleado/listarEmpleado", method = RequestMethod.GET) // listo
	public String listarEmpleado(Model model) {
		List<Empleado> empleados = this.serviceEmpleado.listarEmpleado();
		model.addAttribute("empleados", empleados);
		return "listarEmpleados";
	}

}
