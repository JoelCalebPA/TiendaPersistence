package com.caleb.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_venta")
public class Venta implements Serializable {
		
	private static final long serialVersionUID = 1L;
	
	private int id_venta;
	private Cliente cliente;
	private Date fecha;
	private double pago_total;
    private Set<DetalleVenta> detalleVenta = new HashSet<DetalleVenta>();
	
	public Venta() { }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_venta")
	public int getId_venta() {
		return id_venta;
	}
	@ManyToOne
    @JoinColumn(name = "id_cliente")
	public Cliente getCliente() {
		return cliente;
	}
	@Temporal(value = TemporalType.DATE)
	@Column(name = "fecha")
	public Date getFecha() {
		return fecha;
	}
	@Column(name = "pago_total")
	public double getPago_total() {
		return pago_total;
	}
	@Transient
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "primaryKey.venta",
            cascade = CascadeType.ALL)
	public Set<DetalleVenta> getDetalleVenta() {
		return detalleVenta;
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
	public void setDetalleVenta(Set<DetalleVenta> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}
	public void addDetalleVenta(DetalleVenta detalleVenta) {
		this.detalleVenta.add(detalleVenta);
	}
	
}
