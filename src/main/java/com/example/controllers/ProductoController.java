package com.example.controllers;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.ProductosModel;
import com.example.services.ProductosService;

@RestController
@RequestMapping("/productos")
public class ProductoController {
	@Autowired
	ProductosService productosServicio;
	
	@GetMapping()
	public ArrayList<ProductosModel> obtenerProductos(){
		return productosServicio.obtenerProductos();
	}
	
	@GetMapping(path = "/{id}")
	public Optional<ProductosModel> obtenerProductoPorId(@PathVariable("id") Integer id) {
		return this.productosServicio.obtenerPorId(id);
	}
}
