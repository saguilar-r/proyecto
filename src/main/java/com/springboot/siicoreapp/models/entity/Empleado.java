package com.springboot.siicoreapp.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="empleados")
public class Empleado implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_empleado;
	
	private String tipo_documento;
	private String num_documento;
	private String nombre_1;
	private String nombre_2;
	private String apellido_1;
	private String apellido_2;
	private String direccion;
	private String telefono;
	private String email;
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_cargo")
	private Cargo cargo;
	
	public Long getId_empleado() {
		return id_empleado;
	}
	public void setId_empleado(Long id_empleado) {
		this.id_empleado = id_empleado;
	}
	public String getTipo_documento() {
		return tipo_documento;
	}
	public void setTipo_documento(String tipo_documento) {
		this.tipo_documento = tipo_documento;
	}
	public String getNum_documento() {
		return num_documento;
	}
	public void setNum_documento(String num_documento) {
		this.num_documento = num_documento;
	}
	public String getNombre_1() {
		return nombre_1;
	}
	public void setNombre_1(String nombre_1) {
		this.nombre_1 = nombre_1;
	}
	public String getNombre_2() {
		return nombre_2;
	}
	public void setNombre_2(String nombre_2) {
		this.nombre_2 = nombre_2;
	}
	public String getApellido_1() {
		return apellido_1;
	}
	public void setApellido_1(String apellido_1) {
		this.apellido_1 = apellido_1;
	}
	public String getApellido_2() {
		return apellido_2;
	}
	public void setApellido_2(String apellido_2) {
		this.apellido_2 = apellido_2;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public boolean getEstado() {
		return estado;
	}
	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public Cargo getCargo() {
		return cargo;
	}
	public void setCargo(Cargo cargo) {
		this.cargo = cargo;
	}
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	@Override
	public String toString() {
		return "Empleado [id_empleado=" + id_empleado + ", tipo_documento=" + tipo_documento + ", num_documento="
				+ num_documento + ", nombre_1=" + nombre_1 + ", nombre_2=" + nombre_2 + ", apellido_1=" + apellido_1
				+ ", apellido_2=" + apellido_2 + ", direccion=" + direccion + ", telefono=" + telefono + ", email="
				+ email + ", estado=" + estado + ", cargo=" + cargo + "]";
	}
	
}
