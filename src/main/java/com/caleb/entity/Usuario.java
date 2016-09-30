package com.caleb.entity;

import java.io.Serializable;

import javax.persistence.AssociationOverride;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "tbl_usuario")
@AssociationOverride(name = "primaryKey.cliente", joinColumns = @JoinColumn(name = "id_cliente"))
public class Usuario implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private UsuarioId primaryKey = new UsuarioId();
	private String usuario;
	private String password;
	
	public Usuario() { }

	@EmbeddedId
	public UsuarioId getPrimaryKey() {
		return primaryKey;
	}
	@Transient
	public Cliente getCliente() {
		return getPrimaryKey().getCliente();
	}
	@Column(name = "usuario")
	public String getUsuario() {
		return usuario;
	}
	@Column(name = "password")
	public String getPassword() {
		return password;
	}
	public void setPrimaryKey(UsuarioId primaryKey) {
		this.primaryKey = primaryKey;
	}
	public void setCliente(Cliente cliente) {
		this.getPrimaryKey().setCliente(cliente);
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	
	
	
}
