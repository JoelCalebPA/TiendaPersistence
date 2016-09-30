package com.caleb.dao;

import java.util.List;

import com.caleb.entity.Categoria;

public interface CategoriaDAO {

	public static final String SP_LISTAR_CATEGORIA = "CALL spListarCategoria()";
	
	void crearCategoria(Categoria categoria);
	void actualizarCategoria(Categoria categoria);
	void eliminarCategoria(int id_categoria);
	Categoria buscarCategoria(int id_categoria);
	List<Categoria> listarCategoria();
	
}
