package com.caleb.dao;

import java.util.List;

import com.caleb.entity.Categoria;

public interface CategoriaDAO {

	void crearCategoria(Categoria categoria);
	void actualizarCategoria(Categoria categoria);
	void eliminarCategoria(int id_categoria);
	Categoria buscarCategoria(int id_categoria);
	List<Categoria> listarProductos();
	
}
