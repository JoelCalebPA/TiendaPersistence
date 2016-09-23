package com.caleb.test;

import com.caleb.dao.ProductoDAOImpl;
import com.caleb.entity.Producto;

public class Test {

	public static void main(String[] args) {
		
		ProductoDAOImpl dao = new ProductoDAOImpl();
		Producto producto = new Producto();
		producto.setId_producto(50);
		producto = dao.buscarProducto(producto.getId_producto());
		System.out.println(producto.getDescripcion().toString());
		
	}

}
