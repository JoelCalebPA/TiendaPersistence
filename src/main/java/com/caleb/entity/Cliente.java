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
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_cliente")
public class Cliente implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private int id_cliente;
	private String nombre;
	private String apellido;
	private String direccion;
	private String telefono;
	private String usuario;
	private String password;
	private Set<Venta> ventas = new HashSet<Venta>();
	
	public Cliente() { }

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_cliente")
	public int getId_cliente() {
		return id_cliente;
	}
	@Column(name = "nombre")
	public String getNombre() {
		return nombre;
	}
	@Column(name = "apellido")
	public String getApellido() {
		return apellido;
	}
	@Column(name = "direccion")
	public String getDireccion() {
		return direccion;
	}
	@Column(name = "telefono")
	public String getTelefono() {
		return telefono;
	}
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "cliente")
	public Set<Venta> getVentas() {
		return ventas;
	}
	@Column(name = "usuario")
	public String getUsuario() {
		return usuario;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
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
	public void setVentas(Set<Venta> ventas) {
		this.ventas = ventas;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
