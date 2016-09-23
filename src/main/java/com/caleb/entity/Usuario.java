package com.caleb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_usuario")
public class Usuario {

	@Id
	@OneToOne
	@JoinColumn(name = "id_cliente", foreignKey = @ForeignKey(name = "fk_usr_cli"))
	private Cliente cliente;
	@Column(name = "usuario", nullable = false, length = 30)
	private String usuario;
	@Column(name = "contraseña", nullable = false, length = 30)
	private String contrasenia;
	
	public Usuario() { }

	public Cliente getCliente() {
		return cliente;
	}
	public String getUsuario() {
		return usuario;
	}
	public String getContrasenia() {
		return contrasenia;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}
	
}
