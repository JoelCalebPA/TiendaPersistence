package com.caleb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.caleb.entity.Categoria;
import com.caleb.entity.Marca;
import com.caleb.entity.Producto;
import com.caleb.util.HibernateUtil;

public class ProductoDAOImpl implements ProductoDAO {

	private SessionFactory sessionFactory;
	private Session session;
	
	@Override
	public void crearProducto(Producto producto) {
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.save(producto);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error al crear producto: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			if (!sessionFactory.isClosed()) {
				sessionFactory.close();
			}
		}
	}

	@Override
	public void actualizarProducto(Producto producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarProducto(int id_producto) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Producto buscarProducto(int id_producto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listarProductos() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listarProductos(Categoria categoria) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Producto> listarProductos(Marca marca) {
		// TODO Auto-generated method stub
		return null;
	}

	
	
}
