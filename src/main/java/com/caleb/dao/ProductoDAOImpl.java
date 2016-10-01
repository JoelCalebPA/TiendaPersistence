package com.caleb.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.caleb.entity.Categoria;
import com.caleb.entity.Marca;
import com.caleb.entity.Producto;
import com.caleb.util.HibernateUtil;

public class ProductoDAOImpl implements ProductoDAO {
		
	private static List<Producto> productos;
	
	@Override
	public void registrarProducto(Producto producto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.persist(producto);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			System.err.println("Error al crear producto: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void actualizarProducto(Producto producto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(producto);
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error al crear actualizar: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void eliminarProducto(int id_producto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.createSQLQuery(SP_ELIMINAR_PRODUCTO)
					.setParameter("id", id_producto)
					.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error al crear actualizar: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Producto buscarProducto(int id_producto) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Producto producto = new Producto();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			producto = (Producto)session.find(Producto.class, id_producto);
			tx.commit();
			return producto;
		} catch (Exception e) {
			tx.rollback();
			System.err.println("Error al crear actualizar: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Producto> listarProductos() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		productos = new ArrayList<Producto>();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createSQLQuery(SP_LISTAR_PRODUCTOS)
					.addEntity(Producto.class);
			productos = query.getResultList();
			tx.commit();
			return productos;
		} catch (Exception e) {
			tx.rollback();
			System.err.println("Error al crear actualizar: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Producto> listarProductos(Categoria categoria) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createSQLQuery(SP_LISTAR_PRODUCTOS_X_CATEGORIA)
					.addEntity(Producto.class)
					.setParameter("id", categoria.getId_categoria());
			tx.commit();
			return (List<Producto>)query.getResultList();
		} catch (Exception e) {
			tx.rollback();
			System.err.println("Error al crear actualizar: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Producto> listarProductos(Marca marca) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			Query query = session.createSQLQuery(SP_LISTAR_PRODUCTOS_X_MARCA)
					.addEntity(Producto.class)
					.setParameter("id", marca.getId_marca());
			tx.commit();
			return (List<Producto>)query.getResultList();
		} catch (Exception e) {
			tx.rollback();
			System.err.println("Error al crear actualizar: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	
	
}
