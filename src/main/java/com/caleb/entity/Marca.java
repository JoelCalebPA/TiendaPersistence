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
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_marca")
public class Marca implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_marca;
	private String descripcion;
	private Set<Producto> productos = new HashSet<Producto>();
	
	public Marca() { }
	public Marca(int id_marca) {
		this.id_marca = id_marca;
	}
	public Marca(int id_marca, String descripcion) {
		super();
		this.id_marca = id_marca;
		this.descripcion = descripcion;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_marca")
	public int getId_marca() {
		return id_marca;
	}
	@Column(name = "nombre")
	public String getDescripcion() {
		return descripcion;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "marca")
	public Set<Producto> getProductos() {
		return productos;
	}
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
}
