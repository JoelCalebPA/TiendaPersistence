package com.caleb.test;

import com.caleb.dao.ProductoDAOImpl;
import com.caleb.entity.Producto;

public class Test {

	public static void main(String[] args) {
		
		ProductoDAOImpl dao = new ProductoDAOImpl();
		Producto producto = new Producto();
		producto.setId_producto(54);
		producto.setDescripcion("Teclado Genius color rojo");
		producto = dao.buscarProducto(producto);
		ProductoDAOImpl dao2 = new ProductoDAOImpl();
		dao2.actualizarProducto(producto);
		System.out.println(producto.getDescripcion().toString());
	}

}
