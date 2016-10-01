package com.caleb.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;

import com.caleb.entity.Cliente;
import com.caleb.util.HibernateUtil;

public class ClienteDAOImpl implements ClienteDAO {

	@Override
	public void registrarCliente(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(cliente);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error al Registrar Cliente:" + e);
			session.getTransaction().rollback();
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void actualizarCliente(Cliente cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.update(cliente);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error al Actualizar Cliente:" + e);
			session.getTransaction().rollback();
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public void eliminarCliente(int id_cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.createSQLQuery(SP_ELIMINAR_CLIENTE)
					.setParameter("id", id_cliente)
					.executeUpdate();
			session.getTransaction().commit();
		} catch (Exception e) {
			session.getTransaction().rollback();
			System.err.println("Error al Eliminar Cliente: " + e);
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	@Override
	public Cliente buscarCliente(int id_cliente) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		Cliente cliente = new Cliente();
		try {
			session.beginTransaction();
			cliente = (Cliente)session.find(Cliente.class, id_cliente);
			session.getTransaction().commit();
			return cliente;
		} catch (Exception e) {
			System.err.println("Error al Buscar Cliente:" + e);
			session.getTransaction().rollback();
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public List<Cliente> listarClientes() {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			Query query = session.createSQLQuery(SP_LISTAR_CLIENTES)
					.addEntity(Cliente.class);
			session.getTransaction().commit();
			return (List<Cliente>)query.getResultList();
		} catch (Exception e) {
			System.err.println("Error al Listar Clientes:" + e);
			session.getTransaction().rollback();
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	
	
}
