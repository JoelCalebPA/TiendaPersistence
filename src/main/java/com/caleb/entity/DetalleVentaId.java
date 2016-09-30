package com.caleb.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class DetalleVentaId implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Venta venta;
	private Producto producto;
	
	public DetalleVentaId() { }
	
	@ManyToOne(cascade = CascadeType.ALL)
	public Venta getVenta() {
		return venta;
	}
	@ManyToOne(cascade = CascadeType.ALL)
	public Producto getProducto() {
		return producto;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	
}
