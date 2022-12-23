package com.example.controllers;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.models.ActivoModel;
import com.example.services.ActivoService;

@RestController
@RequestMapping("/activo")
public class ActivoController {
	@Autowired
	ActivoService activoServicio;

	@GetMapping()
	public ArrayList<ActivoModel> obtenerActivo() {
		return activoServicio.obtenerActivo();
	}
	
	@PostMapping()
	public ActivoModel guardarActivo(@RequestBody ActivoModel activo) {
		return activoServicio.guardarActivo(activo);
	}

	@DeleteMapping()
	public void borrarActivo() {
		this.activoServicio.borrarActivo();
	}

}
