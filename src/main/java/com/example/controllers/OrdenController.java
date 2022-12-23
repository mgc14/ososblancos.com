package com.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.OrdenModel;
import com.example.services.OrdenService;

@RestController
@RequestMapping("/ordenes")
public class OrdenController {
	@Autowired
	OrdenService ordenServicio;
	
	@GetMapping()
	public ArrayList<OrdenModel> obtenerOrdenes(){
		return ordenServicio.obtenerOrdenes();
	}
	
	@PostMapping()
	public OrdenModel guardarOrden(@RequestBody OrdenModel orden) {
		return ordenServicio.guardarOrden(orden);
	}
}
