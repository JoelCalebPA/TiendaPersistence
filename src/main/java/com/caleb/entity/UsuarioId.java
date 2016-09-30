package com.caleb.entity;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToOne;

@Embeddable
public class UsuarioId implements Serializable {

	private static final long serialVersionUID = 1L;

	private Cliente cliente;
	
	public UsuarioId() { }
	
	@OneToOne(cascade = CascadeType.ALL)
	public Cliente getCliente() {
		return cliente;
	}
	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}
		
}
