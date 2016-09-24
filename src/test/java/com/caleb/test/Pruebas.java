package com.caleb.test;


import com.caleb.dao.ProductoDAOImpl;
import com.caleb.entity.Categoria;
import com.caleb.entity.Marca;
import com.caleb.entity.Producto;

import org.junit.Test;


public class Pruebas {

	private ProductoDAOImpl dao = new ProductoDAOImpl();
	
	@Test
	public void probarOperaciones() {
		
		System.out.println("Inicio de prueba... ");
		long inicio = System.currentTimeMillis();
		
		
		ProductoDAOImpl dao = new ProductoDAOImpl();
		Marca marca = new Marca();
		marca.setId_marca(1);
		Categoria categoria = new Categoria();
		categoria.setId_categoria(2);
		for (Producto p : dao.listarProductos(marca)) {
			System.out.println(p.getId_producto() + " - " 
								+ p.getDescripcion() + " - "
								+ p.getMarca().getDescripcion() + " - "
								+ p.getCategoria().getDescripcion() + " - "
								+ p.getPrecio() + " - "
								+ p.getStock());
		}
//		Producto p = new Producto();
//		p.setDescripcion("Nuevo Producto 2");
//		p.getCategoria().setId_categoria(5);
//		p.getMarca().setId_marca(5);
//		p.setPrecio(15.00);
//		p.setStock(10);
//		dao.crearProducto(p);
//		dao.eliminarProducto(50);
		
		
		System.out.println("Fin de prueba... ");
		long fin = System.currentTimeMillis();
		System.out.println(fin - inicio);
		
	}

}
