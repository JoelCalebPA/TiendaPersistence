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
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_categoria")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id_categoria;
	private String descripcion;
	private Set<Producto> productos = new HashSet<Producto>();
	
	public Categoria() { }
	public Categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public Categoria(int id_categoria, String descripcion) {
		super();
		this.id_categoria = id_categoria;
		this.descripcion = descripcion;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_categoria")
	public int getId_categoria() {
		return id_categoria;
	}
	@Column(name = "descripcion")
	public String getDescripcion() {
		return descripcion;
	}
	@Transient
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "categoria")
	public Set<Producto> getProductos() {
		return productos;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public void setProductos(Set<Producto> productos) {
		this.productos = productos;
	}
	
	
	
}
