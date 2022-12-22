package com.example.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.models.CarritoModel;
import com.example.repositories.CarritoRepository;

@Service
public class CarritoService {
	@Autowired
	CarritoRepository carritoRepositorio;
	public ArrayList<CarritoModel> obtenerCarrito(){
		return (ArrayList<CarritoModel>) carritoRepositorio.findAll();
	}
	
	public CarritoModel guardarCarrito(CarritoModel carrito) {
		return carritoRepositorio.save(carrito);
	}
	
	public void borrarCarrito() {
		carritoRepositorio.deleteAll();
	}
}
