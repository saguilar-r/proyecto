package com.springboot.siicoreapp.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="roles")
public class Rol implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_rol;
	private String nombre_rol;
	
	
	public Long getId_rol() {
		return id_rol;
	}
	public void setId_rol(Long id_rol) {
		this.id_rol = id_rol;
	}
	public String getNombre_rol() {
		return nombre_rol;
	}
	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}
	@Override
	public String toString() {
		return "Roles [id_rol=" + id_rol + ", nombre_rol=" + nombre_rol + "]";
	}
	
}
