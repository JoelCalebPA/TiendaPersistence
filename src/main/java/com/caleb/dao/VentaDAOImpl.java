package com.caleb.dao;

import java.util.List;

import org.hibernate.Session;

import com.caleb.entity.Cliente;
import com.caleb.entity.DetalleVenta;
import com.caleb.entity.Venta;
import com.caleb.util.HibernateUtil;

public class VentaDAOImpl implements VentaDAO {

	@Override
	public void registrarVenta(Venta venta) {
		Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			session.beginTransaction();
			session.save(venta);
			session.getTransaction().commit();
		} catch (Exception e) {
			System.err.println("Error al Registrar Venta:" + e);
			session.getTransaction().rollback();
			throw new ExceptionInInitializerError(e);
		} finally {
			session.close();
		}
	}

	@Override
	public void actualizarVenta(Venta venta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void eliminarVenta(int id_venta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Venta buscarVenta(int id_venta) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> listarVentas() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Venta> listarVentas(Cliente cliente) {
		// TODO Auto-generated method stub
		return null;
	}

}
