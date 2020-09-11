package com.springboot.siicoreapp.models.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="reg_roles")
public class RegRol implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_reg_rol;
	private String nombre_rol;
	private String descripcion_rol;
	private Date fecha;
	private String usuario;
	private String accion;
	public Long getId_reg_rol() {
		return id_reg_rol;
	}
	public void setId_reg_rol(Long id_reg_rol) {
		this.id_reg_rol = id_reg_rol;
	}
	public String getNombre_rol() {
		return nombre_rol;
	}
	public void setNombre_rol(String nombre_rol) {
		this.nombre_rol = nombre_rol;
	}
	public String getDescripcion_rol() {
		return descripcion_rol;
	}
	public void setDescripcion_rol(String descripcion_rol) {
		this.descripcion_rol = descripcion_rol;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getAccion() {
		return accion;
	}
	public void setAccion(String accion) {
		this.accion = accion;
	}
	@Override
	public String toString() {
		return "RRoles [id_reg_rol=" + id_reg_rol + ", nombre_rol=" + nombre_rol + ", descripcion_rol="
				+ descripcion_rol + ", fecha=" + fecha + ", usuario=" + usuario + ", accion=" + accion + "]";
	}
	
	

}
