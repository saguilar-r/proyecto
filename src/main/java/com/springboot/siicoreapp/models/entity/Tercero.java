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
@Table(name="terceros")
public class Tercero implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_tercero;
	private String tipo_documento;
	private String num_documento;
	private String razon_social;
	private String telefono;
	private String direccion;
	private String ciudad;
	private String email;
	private String persona_contacto;
	private String telefon_contacto;
	private boolean estado;
	
	@ManyToOne
	@JoinColumn(name="id_categoria_tercero")
	private CategoriaTercero categoria;

	public Long getId_tercero() {
		return id_tercero;
	}

	public void setId_tercero(Long id_tercero) {
		this.id_tercero = id_tercero;
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

	public String getRazon_social() {
		return razon_social;
	}

	public void setRazon_social(String razon_social) {
		this.razon_social = razon_social;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getCiudad() {
		return ciudad;
	}

	public void setCiudad(String ciudad) {
		this.ciudad = ciudad;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPersona_contacto() {
		return persona_contacto;
	}

	public void setPersona_contacto(String persona_contacto) {
		this.persona_contacto = persona_contacto;
	}

	public String getTelefon_contacto() {
		return telefon_contacto;
	}

	public void setTelefon_contacto(String telefon_contacto) {
		this.telefon_contacto = telefon_contacto;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public CategoriaTercero getCategoria() {
		return categoria;
	}

	public void setCategoria(CategoriaTercero categoria) {
		this.categoria = categoria;
	}

	@Override
	public String toString() {
		return "Tercero [id_tercero=" + id_tercero + ", tipo_documento=" + tipo_documento + ", num_documento="
				+ num_documento + ", razon_social=" + razon_social + ", telefono=" + telefono
				+ ", direccion=" + direccion + ", ciudad=" + ciudad + ", email=" + email + ", persona_contacto="
				+ persona_contacto + ", telefon_contacto=" + telefon_contacto + ", estado=" + estado + ", categoria="
				+ categoria + "]";
	}
}
