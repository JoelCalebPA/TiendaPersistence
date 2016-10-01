package com.caleb.test;

import org.junit.Test;

import com.caleb.dao.CategoriaDAOImpl;
import com.caleb.entity.Categoria;

public class CategoriaTest {

	private CategoriaDAOImpl dao = new CategoriaDAOImpl();
	
	@Test
	public void listarCategorias() {
		for (Categoria c : dao.listarCategoria()) {
			System.out.println(c.getDescripcion());
		}
		
	}
	
}
