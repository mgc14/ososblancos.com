package com.example.models;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table (name="productos")
public class ProductosModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;
	private Integer precio;
	private String marca;
	private String imagen_frontal;
	private String imagen_nutricional;
	private String categoria;
	
	/*-------empiezan relaciones----------*/
	//@OneToMany
	//private ArrayList<OrdenProductoModel> ordenProductos;
	
	public ProductosModel() {
		super();
	}
	
	public ProductosModel(Integer id, Integer precio, String marca, String imagen_frontal, String imagen_nutricional,
			String categoria, ArrayList<OrdenProductoModel> ordenProductos) {
		super();
		this.id = id;
		this.precio = precio;
		this.marca = marca;
		this.imagen_frontal = imagen_frontal;
		this.imagen_nutricional = imagen_nutricional;
		this.categoria = categoria;
		//this.ordenProductos = ordenProductos;
	}

	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getPrecio() {
		return precio;
	}
	public void setPrecio(Integer precio) {
		this.precio = precio;
	}
	public String getMarca() {
		return marca;
	}
	public void setMarca(String marca) {
		this.marca = marca;
	}
	public String getImagen_frontal() {
		return imagen_frontal;
	}
	public void setImagen_frontal(String imagen_frontal) {
		this.imagen_frontal = imagen_frontal;
	}
	public String getImagen_nutricional() {
		return imagen_nutricional;
	}
	public void setImagen_nutricional(String imagen_nutricional) {
		this.imagen_nutricional = imagen_nutricional;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	//public ArrayList<OrdenProductoModel> getOrdenProductos() {
	//	return ordenProductos;
	//}

	//public void setOrdenProductos(ArrayList<OrdenProductoModel> ordenProductos) {
	//	this.ordenProductos = ordenProductos;
	//}
	
	
}
