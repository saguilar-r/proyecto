package com.springboot.siicoreapp.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria_tercero")
public class CategoriaTercero implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_categoria_tercero;
	private String nombre;
	
	public Long getId_categoria_tercero() {
		return id_categoria_tercero;
	}
	public void setId_categoria_tercero(Long id_categoria_tercero) {
		this.id_categoria_tercero = id_categoria_tercero;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	@Override
	public String toString() {
		return "Categoria [id_categoria_tercero=" + id_categoria_tercero + ", nombre=" + nombre + "]";
	}
	
	

}
