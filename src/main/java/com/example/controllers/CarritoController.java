package com.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.CarritoModel;
import com.example.services.CarritoService;


@RestController
@RequestMapping("/carrito")
public class CarritoController {
	@Autowired
	CarritoService carritoServicio;
	
	@GetMapping()
	public ArrayList<CarritoModel> obtenerCarrito(){
		return carritoServicio.obtenerCarrito();
	}
	
	@PostMapping()
	public CarritoModel guardarCarrito(@RequestBody CarritoModel carrito) {
		return this.carritoServicio.guardarCarrito(carrito);
	}
	
	@DeleteMapping()
	public void borrarCarrito() {
		this.carritoServicio.borrarCarrito();
	}
}