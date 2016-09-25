package com.caleb.test;

import org.junit.Test;

import com.caleb.dao.ClienteDAOImpl;
import com.caleb.entity.Cliente;

public class ClientePruebas {

	private ClienteDAOImpl dao = new ClienteDAOImpl();
	private Cliente cliente;
	
	@Test
	public void registrarCliente() {
		cliente = new Cliente();
		cliente.setNombre("Caleb Joel");
		cliente.setApellido("Arias Paytan");
		cliente.setDireccion("Lurigancho - Chosica");
		cliente.setTelefono("+51 945746400");
		dao.registrarCliente(cliente);
		System.out.println("Registro exitoso");
	}
	
	@Test
	public void actualizarCliente() {
		cliente = new Cliente();
		cliente.setId_cliente(2);
		cliente.setNombre("Caleb Joel 2");
		cliente.setApellido("Arias Paytan 2");
		cliente.setDireccion("Lurigancho - Chosica 2");
		cliente.setTelefono("+51 945746400 2");
		dao.actualizarCliente(cliente);
		System.out.println("Actualizacion exitosa");
	}
	
	@Test
	public void eliminarCliente() {
		dao.eliminarCliente(2);
		System.out.println("Cliente eliminado ");
	}
	
	@Test
	public void buscarCliente() {
		System.out.println("Clinte encontrado: " + dao.buscarCliente(1).getNombre());
	}
	
	@Test
	public void listarClientes(){
		System.out.println("Cantidad de clientes: " + dao.listarClientes().size());
	}

}
