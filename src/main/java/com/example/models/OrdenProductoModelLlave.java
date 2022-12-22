package com.example.models;

import java.io.Serializable;

import jakarta.persistence.Column;

public class OrdenProductoModelLlave implements Serializable{
	@Column(name="orden_id")
	Integer ordenId;
	
	@Column(name="producto_id")
	Integer productoId;
}
