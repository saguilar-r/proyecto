package com.springboot.siicoreapp.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="categoria_productos")
public class CategoriaProducto implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	
	private Long id_categoria_producto;
	private String nombre;
	private boolean estado;
	
	public Long getId_categoria_producto() {
		return id_categoria_producto;
	}
	public void setId_categoria_producto(Long id_categoria_producto) {
		this.id_categoria_producto = id_categoria_producto;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public boolean isEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}
	@Override
	public String toString() {
		return "CatProductos [id_categoria_producto=" + id_categoria_producto + ", nombre=" + nombre + ", estado=" + estado + "]";
	}
	
	

}
