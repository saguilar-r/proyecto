	package com.springboot.siicoreapp.models.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.springframework.web.multipart.MultipartFile;

@Entity
@Table(name="productos")
public class Producto implements Serializable{
		
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id_producto;
	private String codigo;
	private String nombre_producto;
	private String descripcion;
	private int stock;
	private double precio_compra;
	private double precio_venta;
	private String marca_producto;
	private String marca_coche;
	private String referencia;
	private String modelo;
	private String lado;
	private String ubicacion;
	private String imagen;
	private boolean estado;
	
	@Transient
	private MultipartFile file;
	
	public MultipartFile getFile() {
		return file;
	}

	public void setFile(MultipartFile file) {
		this.file = file;
	}

	//DECLARAR LLAVE FORANEA
	@ManyToOne
	@JoinColumn(name="id_categoria_producto")
	private CategoriaProducto catproductos;

	public Long getId_producto() {
		return id_producto;
	}

	public void setId_producto(Long id_producto) {
		this.id_producto = id_producto;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	public String getNombre_producto() {
		return nombre_producto;
	}

	public void setNombre_producto(String nombre_producto) {
		this.nombre_producto = nombre_producto;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public double getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(double precio_compra) {
		this.precio_compra = precio_compra;
	}

	public double getPrecio_venta() {
		return precio_venta;
	}

	public void setPrecio_venta(double precio_venta) {
		this.precio_venta = precio_venta;
	}

	public String getMarca_producto() {
		return marca_producto;
	}

	public void setMarca_producto(String marca_producto) {
		this.marca_producto = marca_producto;
	}

	public String getMarca_coche() {
		return marca_coche;
	}

	public void setMarca_coche(String marca_coche) {
		this.marca_coche = marca_coche;
	}

	public String getReferencia() {
		return referencia;
	}

	public void setReferencia(String referencia) {
		this.referencia = referencia;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getLado() {
		return lado;
	}

	public void setLado(String lado) {
		this.lado = lado;
	}

	public String getUbicacion() {
		return ubicacion;
	}

	public void setUbicacion(String ubicacion) {
		this.ubicacion = ubicacion;
	}

	public String getImagen() {
		return imagen;
	}

	public void setImagen(String imagen) {
		this.imagen = imagen;
	}

	public boolean isEstado() {
		return estado;
	}

	public void setEstado(boolean estado) {
		this.estado = estado;
	}

	public CategoriaProducto getCatproductos() {
		return catproductos;
	}

	public void setCatproductos(CategoriaProducto catproductos) {
		this.catproductos = catproductos;
	}

	@Override
	public String toString() {
		return "Producto [id_producto=" + id_producto + ", codigo=" + codigo + ", nombre_producto=" + nombre_producto
				+ ", descripcion=" + descripcion + ", stock=" + stock + ", precio_compra=" + precio_compra
				+ ", precio_venta=" + precio_venta + ", marca_producto=" + marca_producto + ", marca_coche="
				+ marca_coche + ", referencia=" + referencia + ", modelo=" + modelo + ", lado=" + lado + ", ubicacion="
				+ ubicacion + ", imagen=" + imagen + ", estado=" + estado + ", catproductos=" + catproductos + "]";
	}
}
