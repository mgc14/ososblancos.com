package com.example.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.ActivoModel;
import com.example.repositories.ActivoRepository;

@Service
public class ActivoService {
	@Autowired
	ActivoRepository activoRepositorio;
	public ArrayList<ActivoModel> obtenerActivo(){
		return (ArrayList<ActivoModel>) activoRepositorio.findAll();
	}
	
	public ActivoModel guardarActivo(ActivoModel activo) {
		return activoRepositorio.save(activo);
	}
	 public void borrarActivo() {
		 activoRepositorio.deleteAll();
	 }
}
