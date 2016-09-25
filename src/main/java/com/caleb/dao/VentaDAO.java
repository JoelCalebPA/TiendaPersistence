package com.caleb.dao;

import java.util.List;

import com.caleb.entity.Cliente;
import com.caleb.entity.Venta;

public interface VentaDAO {

	public static final String SP_ELIMINAR_VENTA = "CALL spEliminarVenta(:id)";
	public static final String SP_LISTAR_VENTAS = "CALL spListarVentas()";
	public static final String SP_LISTAR_VENTAS_X_CLIENTE = "CALL spListarVentasPorCliente(:id)";
	
	public void registrarVenta(Venta venta);
	public void actualizarVenta(Venta venta);
	public void eliminarVenta(int id_venta);
	public Venta buscarVenta(int id_venta);
	public List<Venta> listarVentas();
	public List<Venta> listarVentas(Cliente cliente);
	
}
