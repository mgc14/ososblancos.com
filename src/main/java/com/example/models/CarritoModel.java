package com.example.models;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

	@Entity
	@Table (name="carrito")
	public class CarritoModel {
		@Id
		@GeneratedValue(strategy=GenerationType.IDENTITY)
		@Column(unique=true, nullable=false)
		private Integer id;
		private Integer id_producto;
		private Integer precio;
		private String marca;
		private String imagen_frontal;
		private String imagen_nutricional;
		private String categoria;
		
		/*-------empiezan relaciones----------*/
		//@OneToMany
		//private ArrayList<OrdenProductoModel> ordenProductos;
		
		public CarritoModel() {
			super();
		}
		
		

		public CarritoModel(Integer id, Integer id_producto, Integer precio, String marca, String imagen_frontal,
				String imagen_nutricional, String categoria) {
			super();
			this.id = id;
			this.id_producto = id_producto;
			this.precio = precio;
			this.marca = marca;
			this.imagen_frontal = imagen_frontal;
			this.imagen_nutricional = imagen_nutricional;
			this.categoria = categoria;
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



		public Integer getId_producto() {
			return id_producto;
		}



		public void setId_producto(Integer id_producto) {
			this.id_producto = id_producto;
		}
		
	}
