package com.caleb.test;

import com.caleb.dao.ProductoDAOImpl;
import com.caleb.entity.Producto;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class Pruebas {

	@Test
	public void probarOperaciones() {
		ProductoDAOImpl dao = new ProductoDAOImpl();
		Producto producto = new Producto();
		producto.setDescripcion("nuevo producto");
		producto.getMarca().setId_marca(5);
		producto.getCategoria().setId_categoria(5);
		producto.setPrecio(25.00);
		producto.setStock(10);
		dao.crearProducto(producto);
	}

}
