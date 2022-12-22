package com.example.models;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table (name="orden_has_productos")
public class OrdenProductoModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	@EmbeddedId
	private OrdenProductoModelLlave id;
	/*---------empiezan las relaciones--------*/
	@ManyToOne
	@MapsId("ordenId")
	@JoinColumn(name="orden_id")
	OrdenModel orden;
	@ManyToOne
	@MapsId("productoId")
	@JoinColumn(name="producto_id")
	ProductosModel producto;
	public OrdenProductoModel() {
		super();
	}
	
	

	public OrdenProductoModel(OrdenProductoModelLlave id, OrdenModel orden, ProductosModel producto) {
		super();
		this.id = id;
		this.orden = orden;
		this.producto = producto;
	}



	public OrdenModel getOrden() {
		return orden;
	}
	public void setOrden(OrdenModel orden) {
		this.orden = orden;
	}
	public ProductosModel getProducto() {
		return producto;
	}
	public void setProducto(ProductosModel producto) {
		this.producto = producto;
	}



	public OrdenProductoModelLlave getId() {
		return id;
	}



	public void setId(OrdenProductoModelLlave id) {
		this.id = id;
	}


	
	
	
	
}
