package com.example.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.OrdenModel;
import com.example.repositories.OrdenRepository;

@Service
public class OrdenService {
	@Autowired
	OrdenRepository ordenRepository;
	public ArrayList<OrdenModel> obtenerOrdenes(){
		return (ArrayList<OrdenModel>) ordenRepository.findAll();
	}
	
	public OrdenModel guardarOrden(OrdenModel orden) {
		return ordenRepository.save(orden);
	}
	
}
