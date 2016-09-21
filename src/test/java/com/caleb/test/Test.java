package com.caleb.test;

import com.caleb.dao.ProductoDAOImpl;
import com.caleb.entity.Categoria;
import com.caleb.entity.Marca;
import com.caleb.entity.Producto;

public class Test {

	public static void main(String[] args) {
		
		ProductoDAOImpl dao = new ProductoDAOImpl();
		Producto producto = new Producto();
		producto.setDescripcion("Teclado");
		producto.setId_categoria(new Categoria(5));
		producto.setId_marca(new Marca(12));
		producto.setPrecio(45.00);
		producto.setStock(10);
		System.out.println(producto.getId_categoria().getId_categoria());
		System.out.println(producto.getId_marca().getId_marca());
		dao.crearProducto(producto);
		System.out.println(producto.getDescripcion().toString());
	}

}
