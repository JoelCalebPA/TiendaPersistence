package com.caleb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_producto")
public class Producto implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id_producto;
	private String descripcion;
	private Categoria categoria;
	private Marca marca;
	private double precio;
	private int stock;
	
	public Producto() { 
		this.categoria = new Categoria();
		this.marca = new Marca();
	}
	
	@Id
	@Column(name = "id_producto", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_producto() {
		return id_producto;
	}
	@Column(name = "descripcion", nullable = false, length = 100)
	public String getDescripcion() {
		return descripcion;
	}
	@ManyToOne
	@JoinColumn(name = "id_categoria", foreignKey = @ForeignKey(name = "fk_pro_categ"))
	public Categoria getCategoria() {
		return categoria;
	}
	@ManyToOne
	@JoinColumn(name = "id_marca", foreignKey = @ForeignKey(name = "fk_pro_marca"))
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
	
}
