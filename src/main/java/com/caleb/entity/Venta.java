package com.caleb.entity;

import java.io.Serializable;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_venta")
public class Venta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "id_venta", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id_venta;
	@ManyToOne
	@JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "fk_venta_cliente"))
	private Cliente cliente;
	@Temporal(value = TemporalType.DATE)
	@Column(name = "fecha", nullable = false)
	private Date fecha;
	@Column(name = "pago_total", nullable = false)
	private double pago_total;
	
	private Set<DetalleVenta> detalleVentas = new HashSet<>();
	
	public Venta() { }

	public int getId_venta() {
		return id_venta;
	}
	public Cliente getCliente() {
		return cliente;
	}
	public Date getFecha() {
		return fecha;
	}
	public double getPago_total() {
		return pago_total;
	}
	public void setId_venta(int id_venta) {
		this.id_venta = id_venta;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public void setPago_total(double pago_total) {
		this.pago_total = pago_total;
	}

	public Set<DetalleVenta> getDetalleVentas() {
		return detalleVentas;
	}

	public void setDetalleVentas(Set<DetalleVenta> detalleVentas) {
		this.detalleVentas = detalleVentas;
	}
	
	
}
