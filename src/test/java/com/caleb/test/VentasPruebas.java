package com.caleb.test;

import static org.junit.Assert.*;

import java.util.Date;

import org.junit.Test;

import com.caleb.dao.ClienteDAOImpl;
import com.caleb.dao.ProductoDAOImpl;
import com.caleb.dao.VentaDAOImpl;
import com.caleb.entity.Cliente;
import com.caleb.entity.DetalleVenta;
import com.caleb.entity.Producto;
import com.caleb.entity.Venta;

public class VentasPruebas {

	private VentaDAOImpl dao = new VentaDAOImpl();
	private Venta venta = new Venta();
	private Producto producto;
	private Cliente cliente;
	private DetalleVenta detalleVenta;
	private ProductoDAOImpl pdao = new ProductoDAOImpl();
	private ClienteDAOImpl cdao = new ClienteDAOImpl();
	
	@Test
	public void test() {
		cliente = new Cliente();
		cliente = cdao.buscarCliente(1);
		producto = new Producto();
		producto = pdao.buscarProducto(9);
		detalleVenta = new DetalleVenta();
		detalleVenta.setProducto(producto);
		detalleVenta.setVenta(venta);
		detalleVenta.setCantidad(10);
		detalleVenta.setPrecio(5);
		venta.setCliente(cliente);
		venta.setFecha(new Date());
		venta.setPago_total(999);
		venta.addDetalleVenta(detalleVenta);
		dao.registrarVenta(venta);
	}

}
