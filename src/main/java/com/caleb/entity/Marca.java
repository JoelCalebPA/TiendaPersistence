package com.caleb.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_marca")
public class Marca implements Serializable{

	private static final long serialVersionUID = 1L;
	
	private int id_marca;
	private String descripcion;
	
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
	@Column(name = "id_marca", nullable = false, unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_marca() {
		return id_marca;
	}
	@Column(name = "nombre", nullable = false, length = 30)
	public String getDescripcion() {
		return descripcion;
	}
	public void setId_marca(int id_marca) {
		this.id_marca = id_marca;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
}
