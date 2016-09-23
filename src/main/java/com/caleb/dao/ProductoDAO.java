package com.caleb.dao;

import java.util.List;

import com.caleb.entity.Categoria;
import com.caleb.entity.Marca;
import com.caleb.entity.Producto;

public interface ProductoDAO {

	void crearProducto(Producto producto);
	void actualizarProducto(Producto producto);
	void eliminarProducto(int id_producto);
	Producto buscarProducto(int id_producto);
	List<Producto> listarProductos();
	List<Producto> listarProductos(Categoria categoria);
	List<Producto> listarProductos(Marca marca);
	
}
