package com.caleb.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.caleb.entity.Categoria;
import com.caleb.util.HibernateUtil;

public class CategoriaDAOImpl implements CategoriaDAO {

	@Override
	public void crearCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actualizarCategoria(Categoria categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarCategoria(int id_categoria) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Categoria buscarCategoria(int id_categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Categoria> listarCategoria() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(SP_LISTAR_CATEGORIA)
					.addEntity(Categoria.class);
			session.getTransaction().commit();
			return (List<Categoria>)query.getResultList();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error al crear actualizar: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

}
