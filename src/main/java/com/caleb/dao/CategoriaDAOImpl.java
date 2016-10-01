package com.caleb.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

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
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createSQLQuery(SP_LISTAR_CATEGORIA)
					.addEntity(Categoria.class);
			tx.commit();
			return (List<Categoria>)query.getResultList();
		} catch (Exception e) {
			tx.rollback();
			System.err.println("Error al crear actualizar: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

}
