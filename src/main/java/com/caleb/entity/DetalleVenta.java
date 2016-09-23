package com.caleb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_detalle_venta")
public class DetalleVenta {

	@Id
	@ManyToOne
	@JoinColumn(name = "id_venta", foreignKey = @ForeignKey(name = "fk_deta_venta"))
	private Venta venta;
	@Id
	@ManyToOne
	@JoinColumn(name = "id_venta", foreignKey = @ForeignKey(name = "fk_deta_venta"))
	private Producto producto;
	@Column(name = "cantidad", nullable = false)
	private int cantidad;
	@Column(name = "precio", nullable = false)
	private double precio;
	
	public DetalleVenta() { }

	public Venta getVenta() {
		return venta;
	}
	public Producto getProducto() {
		return producto;
	}
	public int getCantidad() {
		return cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setVenta(Venta venta) {
		this.venta = venta;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	
}
