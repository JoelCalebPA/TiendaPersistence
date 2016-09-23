package com.caleb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_cliente")
public class Cliente {

	@Id
	@Column(name = "id_cliente", nullable = false, unique = true)
	@GeneratedValue
	private int id_cliente;
	@Column(name = "nombre", nullable = false, length = 30)
	private String nombre;
	@Column(name = "apellido", nullable = false, length = 30)
	private String apellido;
	@Column(name = "direccion", nullable = false, length = 100)
	private String direccion;
	@Column(name = "telefono", nullable = false, length = 30)
	private String telefono;
	
	public Cliente() { }

	public int getId_cliente() {
		return id_cliente;
	}
	public String getNombre() {
		return nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public String getDireccion() {
		return direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setId_cliente(int id_cliente) {
		this.id_cliente = id_cliente;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	
}
