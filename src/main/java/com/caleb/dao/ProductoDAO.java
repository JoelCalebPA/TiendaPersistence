package com.caleb.dao;

import java.util.List;

import com.caleb.entity.Categoria;
import com.caleb.entity.Marca;
import com.caleb.entity.Producto;

public interface ProductoDAO {

	public static final String SP_ELIMINAR_PRODUCTO = "CALL spEliminarProducto(:id)";
	public static final String SP_LISTAR_PRODUCTOS = "CALL spListarProductos()";
	public static final String SP_LISTAR_PRODUCTOS_X_CATEGORIA = "CALL spListarProductosPorCategoria(:id)";
	public static final String SP_LISTAR_PRODUCTOS_X_MARCA = "CALL spListarProductosPorMarca(:id)";
	
	void registrarProducto(Producto producto);
	void actualizarProducto(Producto producto);
	void eliminarProducto(int id_producto);
	Producto buscarProducto(int id_producto);
	List<Producto> listarProductos();
	List<Producto> listarProductos(Categoria categoria);
	List<Producto> listarProductos(Marca marca);
	
}
