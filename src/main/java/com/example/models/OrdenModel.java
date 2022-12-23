package com.example.models;

import java.sql.Date;
import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table (name="orden")
public class OrdenModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;
	//@Temporal(TemporalType.DATE)
	//private Date fecha;
	private Integer precio_final;
	private String direccion;
	private Integer id_producto;
	private Integer id_usuario;
	
	/*----------------empiezan las relaciones-------------*/
	//@ManyToOne
	//private UsuarioModel usuario;
	//@OneToMany(mappedBy="orden")
	//private ArrayList<OrdenProductoModel> ordenProductos;
	
	public OrdenModel() {
		super();
	}
	
	public OrdenModel(Integer id, Date fecha, Integer precio_final, String direccion, Integer id_producto
			,Integer id_usuario) {
		super();
		this.id = id;
		//this.fecha = fecha;
		this.precio_final = precio_final;
		this.direccion = direccion;
		this.id_producto=id_producto;
		this.id_usuario=id_usuario;
		//this.usuario = usuario;
		//this.ordenProductos = ordenProductos;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

//	public Date getFecha() {
//		return fecha;
//	}
//
//	public void setFecha(Date fecha) {
//		this.fecha = fecha;
//	}

	public Integer getPrecio_final() {
		return precio_final;
	}

	public void setPrecio_final(Integer precio_final) {
		this.precio_final = precio_final;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public Integer getId_producto() {
		return id_producto;
	}

	public void setId_producto(Integer id_producto) {
		this.id_producto = id_producto;
	}

	public Integer getId_usuario() {
		return id_usuario;
	}

	public void setId_usuario(Integer id_usuario) {
		this.id_usuario = id_usuario;
	}
}
