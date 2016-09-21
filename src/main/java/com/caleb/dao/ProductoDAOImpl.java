package com.caleb.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.StoredProcedureQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.caleb.entity.Categoria;
import com.caleb.entity.Marca;
import com.caleb.entity.Producto;
import com.caleb.util.HibernateUtil;

public class ProductoDAOImpl implements ProductoDAO {

	@Override
	public void crearProducto(Producto producto) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
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
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.openSession();
			session.beginTransaction();
			session.update(producto);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error al crear actualizar: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			if (!sessionFactory.isClosed()) {
				sessionFactory.close();
			}
		}
	}

	@Override
	public void eliminarProducto(int id_producto) {
	}

	@Override
	public Producto buscarProducto(Producto producto) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.openSession();
		try {
			session.beginTransaction();
			producto = session.find(Producto.class, producto.getId_producto());
			session.getTransaction().commit();
			return producto;
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error al crear actualizar: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			if (!sessionFactory.isClosed()) {
				sessionFactory.close();
			}
		}
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
