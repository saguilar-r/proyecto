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
@Table(name="detalle_registro_compras")
public class DetalleCompra implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long id_detalle_registro_compra;
	private int cantidad;
	private double precio;
	private double descuento;
	
	@ManyToOne
	@JoinColumn(name="id_registro_compra")
	private RegistroCompra compra;
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;
	public Long getId_detalle_registro_compra() {
		return id_detalle_registro_compra;
	}
	public void setId_detalle_registro_compra(Long id_detalle_registro_compra) {
		this.id_detalle_registro_compra = id_detalle_registro_compra;
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
	public RegistroCompra getCompra() {
		return compra;
	}
	public void setCompra(RegistroCompra compra) {
		this.compra = compra;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "DetalleCompras [id_detalle_registro_compra=" + id_detalle_registro_compra + ", cantidad=" + cantidad
				+ ", precio=" + precio + ", descuento=" + descuento + ", compra=" + compra + ", producto=" + producto
				+ "]";
	}
}
