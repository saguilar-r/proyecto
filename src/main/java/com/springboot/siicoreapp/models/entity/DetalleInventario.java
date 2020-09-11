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
@Table(name="detalle_registro_inventarios")
public class DetalleInventario implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_detalle_registro_inventario;
	private int cantidad;
	private double precio;
	
	@ManyToOne
	@JoinColumn(name="id_registro_inventario")
	private RegistroInventario inventario;
	@ManyToOne
	@JoinColumn(name="id_producto")
	private Producto producto;
	
	public Long getId_detalle_registro_inventario() {
		return id_detalle_registro_inventario;
	}
	public void setId_detalle_registro_inventario(Long id_detalle_registro_inventario) {
		this.id_detalle_registro_inventario = id_detalle_registro_inventario;
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
	public RegistroInventario getInventario() {
		return inventario;
	}
	public void setInventario(RegistroInventario inventario) {
		this.inventario = inventario;
	}
	public Producto getProducto() {
		return producto;
	}
	public void setProducto(Producto producto) {
		this.producto = producto;
	}
	@Override
	public String toString() {
		return "DetalleInventario [id_detalle_registro_inventario=" + id_detalle_registro_inventario + ", cantidad="
				+ cantidad + ", precio=" + precio + ", inventario=" + inventario + ", producto=" + producto + "]";
	}
}
