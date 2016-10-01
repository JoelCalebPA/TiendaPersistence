package com.caleb.entity;

import java.io.Serializable;
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

@Entity
@Table(name = "tbl_producto")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id_producto;
	private String descripcion;
	private Categoria categoria = new Categoria();
	private Marca marca = new Marca();
	private double precio;
	private int stock;
	private Set<DetalleVenta> detalleVenta = new HashSet<DetalleVenta>();
	
	public Producto() { }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_producto")
	public int getId_producto() {
		return id_producto;
	}
	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}
	@ManyToOne
    @JoinColumn(name = "id_categoria")
	public Categoria getCategoria() {
		return categoria;
	}
	@ManyToOne
    @JoinColumn(name = "id_marca")
	public Marca getMarca() {
		return marca;
	}
	@Column(name = "precio", nullable = false)
	public double getPrecio() {
		return precio;
	}
	@Column(name = "stock", nullable = false)
	public int getStock() {
		return stock;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "primaryKey.producto",
            cascade = CascadeType.ALL)
	public Set<DetalleVenta> getDetalleVenta() {
		return detalleVenta;
	}
	public void setId_producto(int id_producto) {
		this.id_producto = id_producto;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public void setMarca(Marca marca) {
		this.marca = marca;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public void setDetalleVenta(Set<DetalleVenta> detalleVenta) {
		this.detalleVenta = detalleVenta;
	}

}
