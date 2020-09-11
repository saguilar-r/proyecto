package com.springboot.siicoreapp.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cargos")
public class Cargo implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_cargo;
	private String nombre_cargo;
	private boolean estado;
	
	public Long getId_cargo() {
		return id_cargo;
	}
	public void setId_cargo(Long id_cargo) {
		this.id_cargo = id_cargo;
	}
	public String getNombre_cargo() {
		return nombre_cargo;
	}
	public void setNombre_cargo(String nombre_cargo) {
		this.nombre_cargo = nombre_cargo;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "Cargo [id_cargo=" + id_cargo + ", nombre_cargo=" + nombre_cargo + ", estado=" + estado + "]";
	}
	
	

}
