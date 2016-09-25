package com.caleb.dao;

import java.util.List;

import com.caleb.entity.Cliente;

public interface ClienteDAO {

	public static final String SP_ELIMINAR_CLIENTE = "CALL spEliminarCliente(:id)";
	public static final String SP_LISTAR_CLIENTES = "CALL spListarClientes()";
	
	public void registrarCliente(Cliente cliente);
	public void actualizarCliente(Cliente cliente);
	public void eliminarCliente(int id_cliente);
	public Cliente buscarCliente(int id_cliente);
	public List<Cliente> listarClientes();
	
}
