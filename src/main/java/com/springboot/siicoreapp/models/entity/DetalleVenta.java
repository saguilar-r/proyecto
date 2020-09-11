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
@Table(name="detalle_registro_ventas")
public class DetalleVenta implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_detalle_registro_ventas;
	private int cantidad;
	private double precio;
	private double descuento;
	
	@ManyToOne
	@JoinColumn(name="id_registro_venta")
	private RegistroVenta ventas;
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	public Long getId_detalle_registro_ventas() {
		return id_detalle_registro_ventas;
	}
	public void setId_detalle_registro_ventas(Long id_detalle_registro_ventas) {
		this.id_detalle_registro_ventas = id_detalle_registro_ventas;
	}
	public int getCantidad() {
		return cantidad;
	}
	public void setCantidad(int cantidad) {
		this.cantidad = cantidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getDescuento() {
		return descuento;
	}
	public void setDescuento(double descuento) {
		this.descuento = descuento;
	}
	public RegistroVenta getVentas() {
		return ventas;
	}
	public void setVentas(RegistroVenta ventas) {
		this.ventas = ventas;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "DetalleVentas [id_detalle_registro_ventas=" + id_detalle_registro_ventas + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", descuento=" + descuento + ", ventas=" + ventas + ", producto=" + producto
				+ "]";
	}
}
