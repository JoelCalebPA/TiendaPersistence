package com.caleb.test;

import org.junit.Test;

import com.caleb.dao.ProductoDAOImpl;
import com.caleb.entity.Producto;

public class ProductoPruebas {

	private ProductoDAOImpl dao = new ProductoDAOImpl();
	private Producto producto;
	
	@Test
	public void registrarProducto() {
		producto = new Producto();
		producto.setDescripcion("Nuevo producto de prueba");
		producto.getCategoria().setId_categoria(1);
		producto.getMarca().setId_marca(1);
		producto.setPrecio(99.99);
		producto.setStock(100);
		dao.registrarProducto(producto);
		System.out.println("Producto Registrado : " + producto.getDescripcion());
	}
	
	@Test
	public void actualizarProducto() {
		producto = new Producto();
		producto.setId_producto(50);
		producto.setDescripcion("Nuevo producto de prueba 2");
		producto.getCategoria().setId_categoria(1);
		producto.getMarca().setId_marca(1);
		producto.setPrecio(89.99);
		producto.setStock(90);
		dao.actualizarProducto(producto);
		System.out.println("Producto Actualizado : " + producto.getDescripcion());
	}
	
	@Test
	public void eliminarProducto() {
		dao.eliminarProducto(50);
		System.out.println("Producto Eliminado : 50");
	}
	
	@Test
	public void buscarProducto() {
		System.out.println("Producto Encontrado : " + dao.buscarProducto(49).getDescripcion());
	}
	
	@Test
	public void listarProductos() {
		System.out.println("Producto Encontrados : " + dao.listarProductos().size());
		for (Producto p : dao.listarProductos()) {
			System.out.println(p.getDescripcion());
		}
	}
	
	@Test
	public void listarProductosMarca() {
		producto = new Producto();
		producto.getMarca().setId_marca(1);
		System.out.println("Producto x Marca Encontrados : " 
							+ dao.listarProductos(producto.getMarca()).size());
	}
	
	@Test
	public void listarProductosCategoria() {
		producto = new Producto();
		producto.getCategoria().setId_categoria(5);
		System.out.println("Producto x Categoria Encontrados : " 
							+ dao.listarProductos(producto.getCategoria()).size());
	}
	
}
