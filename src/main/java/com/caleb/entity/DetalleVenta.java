package com.caleb.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_detalle_venta")
@AssociationOverrides({ @AssociationOverride(name = "primaryKey.venta", joinColumns = @JoinColumn(name = "id_venta")),
		@AssociationOverride(name = "primaryKey.producto", joinColumns = @JoinColumn(name = "id_producto")) })
public class DetalleVenta implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private DetalleVentaId primaryKey = new DetalleVentaId();
	private int cantidad;
	private double precio;

	public DetalleVenta() { }

	@EmbeddedId
	public DetalleVentaId getPrimaryKey() {
		return primaryKey;
	}
	@Transient
	public Venta getVenta() {
		return getPrimaryKey().getVenta();
	}
	@Transient
	public Producto getProducto() {
		return getPrimaryKey().getProducto();
	}
	@Column(name = "cantidad")
	public int getCantidad() {
		return cantidad;
	}
	@Column(name = "precio")
	public double getPrecio() {
		return precio;
	}
	public void setPrimaryKey(DetalleVentaId primaryKey) {
		this.primaryKey = primaryKey;
	}
	public void setVenta(Venta venta) {
		getPrimaryKey().setVenta(venta);
	}
	public void setProducto(Producto producto) {
		getPrimaryKey().setProducto(producto);
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}

}
