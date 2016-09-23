package com.caleb.dao;

import java.util.ArrayList;
import java.util.List;

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
		Session session = sessionFactory.getCurrentSession();
		try {
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
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		String query;
		try {
			session.beginTransaction();
			query = "update tbl_producto set estado = 0 where id_producto = :id";
			session.createQuery(query).setParameter("id", id_producto).executeUpdate();
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
	public Producto buscarProducto(int id_producto) {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Producto producto = new Producto();
		try {
			session.beginTransaction();
			producto = (Producto)session.find(Producto.class, id_producto);
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

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Producto> listarProductos() {
		SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		List<Producto> list = new ArrayList<>();
		try {
			session.beginTransaction();
			list = (List<Producto>)session.createCriteria(Producto.class).list();
			session.getTransaction().commit();
			return list;
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
