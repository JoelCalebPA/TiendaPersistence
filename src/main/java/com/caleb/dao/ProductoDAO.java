package com.caleb.dao;

import java.util.List;

import com.caleb.entity.Categoria;
import com.caleb.entity.Marca;
import com.caleb.entity.Producto;

interface ProductoDAO {

	void crearProducto(Producto producto);
	void actualizarProducto(Producto producto);
	void eliminarProducto(int id_producto);
	Producto buscarProducto(Producto producto);
	List<Producto> listarProductos();
	List<Producto> listarProductos(Categoria categoria);
	List<Producto> listarProductos(Marca marca);
	
}
