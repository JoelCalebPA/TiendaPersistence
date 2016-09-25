package com.caleb.test;

import org.junit.Test;

import com.caleb.dao.VentaDAOImpl;
import com.caleb.entity.DetalleVenta;
import com.caleb.entity.Venta;

public class VentaPruebas {

	private VentaDAOImpl dao = new VentaDAOImpl();
	private Venta venta;
	private DetalleVenta detalleVenta;
	
	@Test
	public void registrarVenta() {
		venta = new Venta();
	}

}
