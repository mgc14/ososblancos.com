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
@Table (name="usuarios")
public class UsuarioModel {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(unique=true, nullable=false)
	private Integer id;
	private String correo;
	private String password;
	private String nombre_completo;
	
	/*----------Empiezan Relaciones--------*/
//	@OneToMany(mappedBy="usuario")//es un usuario con muchas ordenes
//	private ArrayList<OrdenModel> ordenes;
	
	
	
	
	
	public UsuarioModel() {
	}
	
	
	
	public UsuarioModel(Integer id, String correo, String password, String nombre_completo,
			ArrayList<OrdenModel> ordenes) {
		super();
		this.id = id;
		this.correo = correo;
		this.password = password;
		this.nombre_completo = nombre_completo;
		//this.ordenes = ordenes;
	}



	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getNombre_completo() {
		return nombre_completo;
	}
	public void setNombre_completo(String nombre_completo) {
		this.nombre_completo = nombre_completo;
	}

//	public ArrayList<OrdenModel> getOrdenes() {
//		return ordenes;
//	}
//
//	public void setOrdenes(ArrayList<OrdenModel> ordenes) {
//		this.ordenes = ordenes;
//	}
	
	
	
	
	
	
	
}
