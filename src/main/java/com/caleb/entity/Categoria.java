package com.caleb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_categoria")
public class Categoria implements Serializable{

	private static final long serialVersionUID = 1L;

	private int id_categoria;
	private String descripcion;
	
	public Categoria() { }
	public Categoria(int id_categoria, String descripcion) {
		super();
		this.id_categoria = id_categoria;
		this.descripcion = descripcion;
	}
	
	@Id
	@Column(name = "id_categoria", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_categoria() {
		return id_categoria;
	}
	@Column(name = "descripcion", nullable = false, length = 100)
	public String getDescripcion() {
		return descripcion;
	}
	public void setId_categoria(int id_categoria) {
		this.id_categoria = id_categoria;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
