package com.springboot.siicoreapp.models.entity;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="registro_inventario")
public class RegistroInventario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_registro_inventario;
	private String tipo_comprobante;
	private String num_comprobante;
	private Date fecha;
	private double subtotal;
	private double total;
	
	//FORANEAS
	@ManyToOne
	@JoinColumn(name="id_tercero")
	private Tercero tercero;
	public Long getId_registro_inventario() {
		return id_registro_inventario;
	}
	public void setId_registro_inventario(Long id_registro_inventario) {
		this.id_registro_inventario = id_registro_inventario;
	}
	public String getTipo_comprobante() {
		return tipo_comprobante;
	}
	public void setTipo_comprobante(String tipo_comprobante) {
		this.tipo_comprobante = tipo_comprobante;
	}
	public String getNum_comprobante() {
		return num_comprobante;
	}
	public void setNum_comprobante(String num_comprobante) {
		this.num_comprobante = num_comprobante;
	}
	public Date getFecha() {
		return fecha;
	}
	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}
	public double getSubtotal() {
		return subtotal;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public double getTotal() {
		return total;
	}
	public void setTotal(double total) {
		this.total = total;
	}

	public Tercero getTercero() {
		return tercero;
	}
	public void setTercero(Tercero tercero) {
		this.tercero = tercero;
	}
	@Override
	public String toString() {
		return "Inventario [id_registro_inventario=" + id_registro_inventario + ", tipo_comprobante=" + tipo_comprobante
				+ ", num_comprobante=" + num_comprobante + ", fecha=" + fecha + ", subtotal=" + subtotal + ", total="
				+ total + ", tercero=" + tercero + "]";
	}
}
